package Homework3.DomainModel.client;

import java.util.Objects;

public class Receiver {
    private String name;
    private int phone_number;
    private String address;

    public Receiver(String name, int phone_number, String address) {
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receiver receiver = (Receiver) o;
        return phone_number == receiver.phone_number &&
                Objects.equals(name, receiver.name) &&
                Objects.equals(address, receiver.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone_number, address);
    }
}
