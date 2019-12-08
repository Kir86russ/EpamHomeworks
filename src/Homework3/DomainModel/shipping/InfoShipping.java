package Homework3.DomainModel.shipping;

import java.sql.Timestamp;
import java.util.Objects;

public class InfoShipping {

    private Timestamp departure_date;
    private Timestamp date_of_receiving;
    private boolean sent;
    private boolean received;
    private boolean payed;

    public InfoShipping(Timestamp departure_date, Timestamp date_of_receiving, boolean sent, boolean received, boolean payed) {
        this.departure_date = departure_date;
        this.date_of_receiving = date_of_receiving;
        this.sent = sent;
        this.received = received;
        this.payed = payed;
    }

    public Timestamp getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Timestamp departure_date) {
        this.departure_date = departure_date;
    }

    public Timestamp getDate_of_receiving() {
        return date_of_receiving;
    }

    public void setDate_of_receiving(Timestamp date_of_receiving) {
        this.date_of_receiving = date_of_receiving;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoShipping that = (InfoShipping) o;
        return sent == that.sent &&
                received == that.received &&
                payed == that.payed &&
                Objects.equals(departure_date, that.departure_date) &&
                Objects.equals(date_of_receiving, that.date_of_receiving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure_date, date_of_receiving, sent, received, payed);
    }
}
