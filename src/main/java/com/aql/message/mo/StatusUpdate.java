package com.aql.message.mo;

/**
 * <p>The status of an <class>MTSmsMessage</class> which can be one of a number of states</p>
 *
 * <p>The status values can be -
 * <br/>
 * 1 = Delivered to Handset <br/>
 * 2 = Rejected from Handset<br/>
 * 4 = Buffered in transit (phone probably off / out of reception) <br/>
 * 8 = Accepted by SMSC<br/>
 * 16 = Rejected by SMSC <br/>
 * <br/>
 * see http://www.aql.com/site/devel_soap.php for more details
 * </p><p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * </p><p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  </p><p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * </p><p>
 * @author johnhunsley
 * Date: 01-Oct-2008
 * Time: 14:17:21
 */
public class StatusUpdate {
    private String phoneNumber;
    private long messageId;
    private int status;

    /**
     *
     * @param phoneNumber
     * @param messageId
     * @param status
     */
    public StatusUpdate(final String phoneNumber, final String messageId, final String status) {
        this.phoneNumber = phoneNumber;
        this.messageId = Long.parseLong(messageId);
        this.status = Integer.parseInt(status);
    }

    /**
     *
     */
    public StatusUpdate() {}

    /**
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return transactionId
     */
    public long getMessageId() {
        return messageId;
    }

    /**
     *
     * @param messageId
     */
    public void setMessageId(final int messageId) {
        this.messageId = messageId;
    }

    /**
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(final int status) {
        this.status = status;
    }
}
