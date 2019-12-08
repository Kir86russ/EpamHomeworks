package Homework3.DomainModel.carrier;

import java.util.Objects;

public class Carrier {

    private Organization organization;
    private Transport transport;

    public Carrier(Organization organization, Transport transport) {
        this.organization = organization;
        this.transport = transport;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrier carrier = (Carrier) o;
        return Objects.equals(organization, carrier.organization) &&
                transport == carrier.transport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(organization, transport);
    }
}
