package Homework13_saxParser.executor.serviceholder;

import Homework13_saxParser.cargo.repo.impl.CargoArrayRepoImpl;
import Homework13_saxParser.cargo.repo.impl.CargoCollectionRepoImpl;
import Homework13_saxParser.cargo.service.CargoService;
import Homework13_saxParser.cargo.service.CargoServiceImpl;
import Homework13_saxParser.carrier.repo.CarrierRepo;
import Homework13_saxParser.carrier.repo.impl.CarrierArrayRepoImpl;
import Homework13_saxParser.carrier.repo.impl.CarrierCollectionRepoImpl;
import Homework13_saxParser.carrier.service.CarrierService;
import Homework13_saxParser.carrier.service.CarrierServiceImpl;
import Homework13_saxParser.transportation.repo.impl.TransportationArrayRepoImpl;
import Homework13_saxParser.transportation.repo.impl.TransportationCollectionRepoImpl;
import Homework13_saxParser.transportation.service.TransportationService;
import Homework13_saxParser.transportation.service.TransportationServiceImpl;

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
                        new CarrierServiceImpl((CarrierRepo) new CarrierCollectionRepoImpl()),
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