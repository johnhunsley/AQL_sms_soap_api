package com.aql.message.mt.sms;

import com.aql.message.mt.MTMessage;

/**
 * <p>Represents a Mobile Terminated, (MT), SMS Message which is to be sent
 * through the Aql MT SMS SOAP service.</p>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * </p><p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * </p><p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * </p>
 * @author johnhunsley
 * Date: 01-Oct-2008
 * Time: 13:29:16
 */
public class MTSmsMessage extends MTMessage {
    public static final String TEXT_TYPE = "text";
    public static final String FLASH_TYPE = "flash";
    private String message;
    private String messageType;

    /**
     *
     */
    public MTSmsMessage() {
        this.messageType = TEXT_TYPE;
    }

    /**
     *
     * @return  message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return messageType
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     *
     * @param messageType
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
