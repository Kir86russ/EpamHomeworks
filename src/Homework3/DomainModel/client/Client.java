package Homework3.DomainModel.client;

import Homework3.DomainModel.product.Product;

import java.util.ArrayList;
import java.util.Objects;

public class Client {

    private int id;
    private Product product;
    private Sender sender;
    private Receiver receiver;

    public static ArrayList<Client> clients = new ArrayList<>();


    public static Client getClient(int id) {
        for (int i = 0; i != Client.clients.size(); i++) {
            if (Client.clients.get(i).getId() == id)
                return Client.clients.get(i);
        }
        return null;
    }

    public Client(int id, Product product, Sender sender, Receiver receiver) {
        this.id = id;
        this.product = product;
        this.sender = sender;
        this.receiver = receiver;
        clients.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(product, client.product) &&
                Objects.equals(sender, client.sender) &&
                Objects.equals(receiver, client.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, sender, receiver);
    }

}
