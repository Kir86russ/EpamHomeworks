package Homework3.DomainModel.shipping;

import Homework3.DomainModel.carrier.Carrier;
import Homework3.DomainModel.client.Client;

import java.util.Objects;

public class Shipping {

    private Carrier carrier;
    private Client client;
    private InfoShipping info;

    public Shipping(Carrier carrier, Client client, InfoShipping info) {
        this.carrier = carrier;
        this.client = Client.getClient(); // desired client id
        this.info = info;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public InfoShipping getInfo() {
        return info;
    }

    public void setInfo(InfoShipping info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipping shipping = (Shipping) o;
        return Objects.equals(carrier, shipping.carrier) &&
                Objects.equals(client, shipping.client) &&
                Objects.equals(info, shipping.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carrier, client, info);
    }
}
