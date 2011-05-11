package com.aql.message.mo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * <p>
 * A Mobile Originating, (MO), message sent from a phone to aql.
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
 * </p><p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * </p><p>
 * @author johnhunsley
 * Date: 01-Oct-2008
 * Time: 13:29:39
 */
public class MOSmsMessage {
    private String text;
    private int transactionId;
    private String from;
    private Timestamp deliveryTime;
    private String to;

    /**
     *
     */
    public MOSmsMessage() {}

    /**
     *
     * @param text
     * @param transactionId
     * @param from
     * @param deliveryTime
     * @param to
     */
    public MOSmsMessage(String text, String transactionId, String from, String deliveryTime, String to) {
        this.text = text;
        setTransactionId(transactionId);
        this.from = from;
        setDeliveryTime(deliveryTime);
        this.to = to;
    }

    /**
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return transactionId
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     *
     * @param transactionId
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     *
     * @param transactionId
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = Integer.parseInt(transactionId);
    }

    /**
     *
     * @return from
     */
    public String getFrom() {
        return from;
    }

    /**
     *
     * @param from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     *
     * @return deliveryTime
     */
    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }

    /**
     *
     * @param deliveryTime
     */
    public void setDeliveryTime(Timestamp deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * Set the delivery time of the message adjusting hours for the given time zone adjustment value.
     *
     * @param timeZoneAdjustmentStr
     * @param time
     */
    public void setDeliveryTime(String timeZoneAdjustmentStr, String time) {

        if(time == null || time.length() < 1)  this.deliveryTime = new Timestamp(System.currentTimeMillis());

        else {
            
            try {
                int timeZoneAdjustment = Integer.parseInt(timeZoneAdjustmentStr);
                DateFormat df = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
                Date date = df.parse(time);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                if(timeZoneAdjustment > 0) cal.add(Calendar.HOUR, timeZoneAdjustment);

                this.deliveryTime = new Timestamp(cal.getTimeInMillis());

            } catch(Exception e) {
                this.deliveryTime = new Timestamp(System.currentTimeMillis());
            }
        }
    }

    /**
     * Set the delivery time of the message with 0 time zone adjustment value.
     *
     * @param time
     */
    public void setDeliveryTime(String time) {
        setDeliveryTime("0", time);
    }

    /**
     *
     * @return to
     */
    public String getTo() {
        return to;
    }

    /**
     *
     * @param to
     */
    public void setTo(String to) {
        this.to = to;
    }
}
