package com.aql.message.mt;

/**
 * <p>Respresents a response made by the Aql SOAP api following a successful request
 * to the SendSoapSms service.</p>
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
 * Time: 13:30:28
 */
public class MTResponse {
    private String responseCode;
    private String description;
    public final static String OK = "OK";

    /**
     *
     * @return responseCode
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     *
     * @param responseCode
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
