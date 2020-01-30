package Homework20_Stream_date_J8.cargo.domain;

import Homework20_Stream_date_J8.common.business.domain.BaseEntity;
import Homework20_Stream_date_J8.transportation.domain.Transportation;

import java.util.List;

public abstract class Cargo extends BaseEntity {

  protected String name;
  protected int weight;
  protected List<Transportation> transportations;
  protected CargoType cargoType;

  public Cargo() {
    cargoType = this.getCargoType();
  }

  public abstract CargoType getCargoType();

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
        "id=" + id +
        ", name='" + name + '\'' +
        ", weight=" + weight +
        ", cargoType=" + cargoType +
        ", transportations=" + transportations +
        '}';
  }
}
