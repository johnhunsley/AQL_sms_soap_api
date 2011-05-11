package com.aql.message.mt;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.xml.transform.StringSource;
import org.apache.log4j.Logger;
import com.aql.message.AqlException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 * <p>Translates an <class>MTMessage</class> implementation object to the SOAP XML schema required
 * to send a message through on of the Aql outbound message APIs. </p>
 * <p>Utilizes the Spring-ws web service package along with an XML/Object mapping solution to map the
 * given <class>MTMessage</class> object to the required SOAP XML body schema as defined by the Aql
 * outbound web service operation.</p>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *  </p><p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  </p><p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * </p>
 * @author johnhunsley
 * Date: 09-Oct-2008
 */
public class AqlMTSoapClient {
    private final static String AUTH_HEADER_NODE = "<auth>\n";
    private final static String _AUTH_HEADER_NODE = "</auth>";
    private final static String USERNAME_HEADER_NODE = "<username>";
    private final static String _USERNAME_HEADER_NODE = "</username>\n";
    private final static String PASSWORD_HEADER_NODE = "<password>";
    private final static String _PASSWORD_HEADER_NODE = "</password>\n";
    private WebServiceTemplate webServiceTemplate;
    private final String callbackUrl;
    private StringBuffer headerBuffer;
    private Logger logger = Logger.getLogger(AqlMTSoapClient.class);

    /**
     *
     * @param webServiceTemplate
     */
    public AqlMTSoapClient(WebServiceTemplate webServiceTemplate,
                              final String callbackUrl,
                              final String username,
                              final String password) {
        this.callbackUrl = callbackUrl;
        this.webServiceTemplate = webServiceTemplate;
        //build the header
        headerBuffer = new StringBuffer(AUTH_HEADER_NODE);
        headerBuffer.append(USERNAME_HEADER_NODE);
        headerBuffer.append(username);
        headerBuffer.append(_USERNAME_HEADER_NODE);
        headerBuffer.append(PASSWORD_HEADER_NODE);
        headerBuffer.append(password);
        headerBuffer.append(_PASSWORD_HEADER_NODE);
        headerBuffer.append(_AUTH_HEADER_NODE);
    }

    /**
     * <p>Set the callback url in the message before sending.</p>
     *
     * @param mTMessage
     * @return Response
     * @throws com.aql.message.AqlException if the message was not successfully processed by the Aql SoapSendSms service
     */
    public MTResponse sendMTMessage(final MTMessage mTMessage) throws AqlException {
        if(logger.isDebugEnabled())
            logger.debug("AqlMTSmsSoapClient is sending an MT Message with id "+mTMessage.getId());

        mTMessage.setCallbackUrl(callbackUrl);

        MTResponse response = (MTResponse)webServiceTemplate.marshalSendAndReceive(
                mTMessage, new WebServiceMessageCallback() {

            /**
             * Add the header before sending.
             *
             * @param webServiceMessage
             */
            public void doWithMessage(WebServiceMessage webServiceMessage) {

                try {
                    SoapMessage soapMessage = (SoapMessage)webServiceMessage;
                    SoapHeader soapHeader = soapMessage.getSoapHeader();
                    StringSource headerSource = new StringSource(headerBuffer.toString());
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.transform(headerSource, soapHeader.getResult());

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        if(!response.getResponseCode().equals(MTResponse.OK))
            throw new AqlException("message send error "+response.getDescription());

        if(logger.isDebugEnabled()) logger.debug("Aql soap api responded successfully - "+response.getDescription());

        return response;
    }
}
