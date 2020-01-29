package Homework19_Optional.storage.initor.fileinitor;


import Homework19_Optional.application.serviceholder.ServiceHolder;
import Homework19_Optional.cargo.domain.Cargo;
import Homework19_Optional.carrier.domain.Carrier;
import Homework19_Optional.storage.initor.StorageInitor;
import Homework19_Optional.transportation.domain.Transportation;

import java.util.*;

public abstract class BaseFileInitor implements StorageInitor {

  protected void setReferencesBetweenEntities(Map<String, Cargo> cargoMap,
                                              Map<String, Carrier> carrierMap, List<ParsedTransportation> parsedTransportations) {

    for (ParsedTransportation parsedTransportation : parsedTransportations) {
      Cargo cargo = cargoMap.get(parsedTransportation.cargoRef);
      Carrier carrier = carrierMap.get(parsedTransportation.carrierRef);
      Transportation transportation = parsedTransportation.transportation;

      if (cargo != null) {
        List<Transportation> transportations =
            cargo.getTransportations() == null ? new ArrayList<>() : cargo.getTransportations();
        transportations.add(transportation);
        transportation.setCargo(cargo);
        cargo.setTransportations(transportations);
      }

      if (carrier != null) {
        List<Transportation> transportations =
            carrier.getTransportations() == null ? new ArrayList<>() : carrier.getTransportations();
        transportations.add(transportation);
        transportation.setCarrier(carrier);
        carrier.setTransportations(transportations);
      }
    }
  }

  static Map<String, Cargo> resMap = new HashMap<>();

  protected void persistCargos(Collection<Cargo> cargos) {

    for (Cargo cargo : cargos) {
      ServiceHolder.getInstance().getCargoService().save(cargo);
    }
  }

  protected void persistCarriers(Collection<Carrier> carriers) {
    for (Carrier carrier : carriers) {
      ServiceHolder.getInstance().getCarrierService().save(carrier);
    }
  }

  protected List<Transportation> getTransportationsFromParsedObject(
      List<ParsedTransportation> transportations) {
    List<Transportation> result = new ArrayList<>();
    for (ParsedTransportation transportation : transportations) {
      result.add(transportation.transportation);
    }

    return result;
  }

  protected void persistTransportations(List<Transportation> transportations) {
    for (Transportation transportation : transportations) {
      ServiceHolder.getInstance().getTransportationService().save(transportation);
    }
  }

  public static class ParsedTransportation {
    private String cargoRef;
    private String carrierRef;
    private Transportation transportation;

    public String getCargoRef() {
      return cargoRef;
    }

    public void setCargoRef(String cargoRef) {
      this.cargoRef = cargoRef;
    }

    public String getCarrierRef() {
      return carrierRef;
    }

    public void setCarrierRef(String carrierRef) {
      this.carrierRef = carrierRef;
    }

    public Transportation getTransportation() {
      return transportation;
    }

    public void setTransportation(
        Transportation transportation) {
      this.transportation = transportation;
    }
  }

}
