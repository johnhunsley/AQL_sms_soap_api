package com.aql.message.mt;

import junit.framework.TestCase;
import com.aql.message.mt.Callback;
import com.aql.message.mt.sms.MTSmsMessage;

/**
 * <p>This program is free software: you can redistribute it and/or modify
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
 * Time: 16:08:40
 */
public class MTMessageTest extends TestCase {

    /**
     * Ensure the id is appended to the call back url as a parameter value
     */
    public void testSetCallBackUrl() {
        String url = "http://mydomain.com?x=y";
        final long id = 666;
        MTSmsMessage message = new  MTSmsMessage();
        message.setId(id);
        message.setCallbackUrl(url);
        assertTrue(message.getCallback().getCallbackUrl().equals(
                url+"&"+ Callback.MESSAGE_CALLBACK_PARAM+"="+Long.toString(id)));
    }
}
