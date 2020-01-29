package Homework19_Optional.application.serviceholder;

import Homework19_Optional.cargo.repo.impl.CargoArrayRepoImpl;
import Homework19_Optional.cargo.repo.impl.CargoCollectionRepoImpl;
import Homework19_Optional.cargo.service.CargoService;
import Homework19_Optional.cargo.service.CargoServiceImpl;
import Homework19_Optional.carrier.repo.impl.CarrierArrayRepoImpl;
import Homework19_Optional.carrier.repo.impl.CarrierCollectionRepoImpl;
import Homework19_Optional.carrier.service.CarrierService;
import Homework19_Optional.carrier.service.CarrierServiceImpl;
import Homework19_Optional.transportation.repo.impl.TransportationArrayRepoImpl;
import Homework19_Optional.transportation.repo.impl.TransportationCollectionRepoImpl;
import Homework19_Optional.transportation.service.TransportationService;
import Homework19_Optional.transportation.service.TransportationServiceImpl;

public final class ServiceHolder {

  private static ServiceHolder instance = null;

  private final CarrierService carrierService;
  private final CargoService cargoService;
  private final TransportationService transportationService;

  private ServiceHolder(StorageType storageType) {
    SimpleServiceHolder initedServiceHolder = getInitedServiceHolder(storageType);
    cargoService = initedServiceHolder.cargoService;
    carrierService = initedServiceHolder.carrierService;
    transportationService = initedServiceHolder.transportationService;
  }

  public static void initServiceHolder(StorageType storageType) {
    ServiceHolder.instance = new ServiceHolder(storageType);
  }

  public static ServiceHolder getInstance() {
    return instance;
  }

  private static class SimpleServiceHolder {

    private final CarrierService carrierService;
    private final CargoService cargoService;
    private final TransportationService transportationService;

    public SimpleServiceHolder(
        CarrierService carrierService,
        CargoService cargoService,
        TransportationService transportationService) {
      this.carrierService = carrierService;
      this.cargoService = cargoService;
      this.transportationService = transportationService;
    }
  }

  private SimpleServiceHolder getInitedServiceHolder(StorageType storageType) {
    switch (storageType) {

      case ARRAY: {
        return new SimpleServiceHolder(
            new CarrierServiceImpl(new CarrierArrayRepoImpl()),
            new CargoServiceImpl(new CargoArrayRepoImpl()),
            new TransportationServiceImpl(new TransportationArrayRepoImpl()));
      }

      default: {
        return new SimpleServiceHolder(
            new CarrierServiceImpl(new CarrierCollectionRepoImpl()),
            new CargoServiceImpl(new CargoCollectionRepoImpl()),
            new TransportationServiceImpl(new TransportationCollectionRepoImpl()));
      }
    }
  }

  public CarrierService getCarrierService() {
    return carrierService;
  }

  public CargoService getCargoService() {
    return cargoService;
  }

  public TransportationService getTransportationService() {
    return transportationService;
  }
}
