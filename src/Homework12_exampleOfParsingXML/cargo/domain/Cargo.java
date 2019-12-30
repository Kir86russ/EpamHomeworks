package Homework12_exampleOfParsingXML.cargo.domain;

import Homework12_exampleOfParsingXML.common.business.domain.BaseEntity;
import Homework12_exampleOfParsingXML.transportation.domain.Transportation;

import java.util.ArrayList;
import java.util.List;

public abstract class Cargo extends BaseEntity {

    protected String name;
    protected int weight;
    protected List<Transportation> transportations = new ArrayList<>();
    protected CargoType cargoType;

    public Cargo() {
        cargoType = this.getCargoType();
    }

    public abstract CargoType getCargoType();

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Transportation> getTransportations() {
        return transportations;
    }

    public void setTransportations(List<Transportation> transportations) {
        this.transportations = transportations;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", transportations=" + transportations +
                ", cargoType=" + cargoType +
                '}';
    }
}