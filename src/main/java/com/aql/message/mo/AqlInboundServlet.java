package com.aql.message.mo;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aql.message.mt.Callback;

/**
 * <p>
 * Receives the information in the call back made from Aql concerning the Geo
 * MO message data for virtual mobile numbers.
 * <p/>
 * <p>
 * The parameters must also match the following
 * <p/>
 * <b>MO Geo Message information -</b>
 * <br/><br/>
 * originator  	%o  	The sender's number <br/>
 * destination 	%d 	    The destination number<br/>
 * message 	    %m 	    The message body<br/>
 * time 	    %t 	    Message timestamp in YYYY-MM-DD HH:MM:SS format <br/>
 * unix_time 	%x 	    Message timestamp as a Unix timestamp <br/>
 * udh 	        %u 	    The UDH header, eg: for decoding concatenated messages <br/>
 * id 	        %i 	    A unique identifier for the message<br/>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * </p>
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  </p>
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * </p>
 * @author johnhunsley
 * Date: 01-Oct-2008
 * Time: 14:16:31
 */
public class AqlInboundServlet extends HttpServlet {
    //Status update HTTP parameters
    public final static String SU_REPORTCODE_PARAM = "reportcode";
    public final static String SU_DESTINATION_PARAM = "destinationnumber";
    //MO message HTTP Parameters
    public final static String MO_DESTINATION_PARAM = "gwNumber";
    public final static String MO_GEO_DESTINATION_PARAM = "destination";
    public final static String MO_ORIGINATOR_PARAM = "originator";
    public final static String MO_MESSAGE_PARAM = "message";
    public final static String MO_TIME_PARAM = "smsTime";
    public final static String MO_GEO_TIME_PARAM = "time";
    public final static String MO_TMEZONE_PARAM = "timeZone";
    public final static String MO_NETWORK_PARAM = "network";
    public final static String MO_ID_PARAM = "id";
    public final static String MO_STATUS_PARAM = "status";
    private Logger logger = Logger.getLogger(AqlInboundServlet.class);

    /**
     * Process either an MO message or a status update. If the details for either
     * are incomplete no further processing for this call will happen.
     *
     * @param request
     * @param response
     */
    public void service(HttpServletRequest request, HttpServletResponse response) {
        if(logger.isDebugEnabled()) logger.debug("AqlInboundServlet is being invoked");

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(
                                                    request.getSession().getServletContext());
        InboundReceiver inboundReceiver = (InboundReceiver)context.getBean("inboundReceiver");

        //check for status update values
        String phoneNumber = request.getParameter(SU_DESTINATION_PARAM);
        String messageId = request.getParameter(Callback.MESSAGE_CALLBACK_PARAM);
        String status = request.getParameter(SU_REPORTCODE_PARAM);

        //check for MO message values
        String moPhoneNumber = request.getParameter(MO_ORIGINATOR_PARAM);
        String moDestination = request.getParameter(MO_GEO_DESTINATION_PARAM);
        String moMessage = request.getParameter(MO_MESSAGE_PARAM);
        String moId = request.getParameter(MO_ID_PARAM);
        String moSmsTime = request.getParameter(MO_GEO_TIME_PARAM);

        //is this a valid MO message?
        if((moPhoneNumber != null && moPhoneNumber.length() > 0) &&
                    (moDestination != null && moDestination.length() > 0) &&
                        (moMessage != null && moMessage.length() > 0) &&
                            (moId != null && moId.length() > 0))  {
            if(logger.isDebugEnabled()) logger.debug("AqlInboundServlet is processing a valid MO Message");

            try {
                MOSmsMessage moSmsMessage = new MOSmsMessage(moMessage,
                                                             moId,
                                                             moPhoneNumber,
                                                             moSmsTime,
                                                             moDestination);
                inboundReceiver.receive(moSmsMessage);

            } catch(Exception e) {
                e.printStackTrace();
            }
        //or is it a valid status update callback?
        } else if((phoneNumber != null && phoneNumber.length() > 0) &&
                    (messageId != null && messageId.length() > 0) &&
                                (status != null && status.length() > 0)) {
            if(logger.isDebugEnabled()) logger.debug("AqlInboundServlet is processing a valid status update");

            try {
                StatusUpdate update = new StatusUpdate(phoneNumber, messageId, status);

                inboundReceiver.receive(update);

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
