package com.aql.message.mt;

/**
 * <p>Respresents the common compenents of a Mobile Terminated, (MT), message sent through one of the
 * Aql outbound APIs. This class may be extended  to represent any MT message such as SMS, MMS.</p>
 * <p>All MT messages, what ever the implementation, require an array of destination phone numbers, an originator
 * and a <class>Callback</class> object if status updates are required</p>
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
 */
public abstract class MTMessage {
    protected long id;
    protected String[] destinationArray;
    protected String originator;
    protected Callback callback;

    /**
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return destinationArray
     */
    public String[] getDestinationArray() {
        return destinationArray;
    }

    /**
     *
     * @param destinationArray
     */
    public void setDestinationArray(String[] destinationArray) {
        this.destinationArray = destinationArray;
    }

    /**
     *
     * @return originator
     */
    public String getOriginator() {
        return originator;
    }

    /**
     *
     * @param originator
     */
    public void setOriginator(String originator) {
        this.originator = originator;
    }

    /**
     *
     * @return callback
     */
    public Callback getCallback() {
        return callback;
    }

    /**
     *
     * @param callback
     */
    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    /**
     * This method is called by the <class>AqlMTSmsSoapClient</class> at send time
     * and there is no need for developers to call this method in their own implementations
     *
     * Developers should set the callback url in the <class>AqlMTSmsSoapClient</class> rather
     * than call here for every message they create.
     *
     * @param callbackUrl
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callback = new Callback(callbackUrl, id);
    }
}
