package com.aql.message.mo;

import com.aql.message.AqlException;

/**
 * <p>
 * Provides a contract to receive inbound objects, either <class>StatusUpdates</class>
 * or <class>MOSmsMessage</class> objects. Implementations of this interface should
 * be responsible for updating the status of an <class>MTSmsMessage</class> however
 * that is required to be performed, and receiving <class>MOSmsMessage</class> objects
 * </p>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * </p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * </p><p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * <p>
 * @author johnhunsley
 * Date: 01-Oct-2008
 * Time: 15:14:59
 */
public interface InboundReceiver {

    /**
     * Receive a <class>StatusUpdate</class> object
     *
     * @param statusUpdate
     * @throws com.aql.message.AqlException
     */
    void receive(StatusUpdate statusUpdate) throws AqlException;

    /**
     * Receive an <class>MOSmsMessage</class> object
     * @param moSmsMessage
     * @throws AqlException
     */
    void receive(MOSmsMessage moSmsMessage) throws AqlException;
}
