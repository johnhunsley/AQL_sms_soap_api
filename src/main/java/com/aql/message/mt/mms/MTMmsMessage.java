package com.aql.message.mt.mms;

import com.aql.message.mt.MTMessage;

/**
 * <p>Represents a Mobile Terminated, MT, MMS Message sent to the Aql SoapSendMMSNot operation</p>
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
 * Date: 09-Oct-2008
 * Time: 10:08:15
 */
public class MTMmsMessage extends MTMessage {
    private String subject;
    private String mmsUrl;
    private String fileSize;
    private String classification;
    private String expiry;

    /**
     *
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return mmsUrl
     */
    public String getMmsUrl() {
        return mmsUrl;
    }

    /**
     *
     * @param mmsUrl
     */
    public void setMmsUrl(String mmsUrl) {
        this.mmsUrl = mmsUrl;
    }

    /**
     *
     * @return fileSize
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     *
     * @param fileSize
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    /**
     *
     * @return classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     *
     * @param classification
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     *
     * @return expiry
     */
    public String getExpiry() {
        return expiry;
    }

    /**
     *
     * @param expiry
     */
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
