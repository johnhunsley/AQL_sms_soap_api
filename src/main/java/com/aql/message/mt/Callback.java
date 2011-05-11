package com.aql.message.mt;

/**
 * <p>Represents the call back url passed to the Aql api for a <class>MTSmsMessage</class>
 * Aql will push status information to this url over http.</p>
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
 * Date: 01-Oct-2008
 * Time: 13:46:56
 */
public class Callback {
    public static final String HTTP_GET_TYPE = "HTTPGET";
    public final static String MESSAGE_CALLBACK_PARAM = "messageId";
    private String callbackUrl;
    private String type;

    /**
     *
     */
    public Callback() {}

    /**
     *
     * @param callbackUrl
     * @param id
     */
    public Callback(String callbackUrl, final long id) {
        this.callbackUrl = callbackUrl+"&"+MESSAGE_CALLBACK_PARAM +"="+Long.toString(id);
        this.type = HTTP_GET_TYPE;

    }

    /**
     *
     * @return callbackUrl
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
