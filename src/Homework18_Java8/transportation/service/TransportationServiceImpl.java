package Homework18_Java8.transportation.service;

import Homework18_Java8.transportation.domain.Transportation;
import Homework18_Java8.transportation.repo.TransportationRepo;

import java.util.List;

public class TransportationServiceImpl implements TransportationService {

    private TransportationRepo transportationRepo;

    public TransportationServiceImpl(
            TransportationRepo transportationRepo) {
        this.transportationRepo = transportationRepo;
    }

    @Override
    public boolean deleteById(Long id) {
        return transportationRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        List<Transportation> allTransportations = transportationRepo.getAll();
        allTransportations.forEach(System.out::println);
    }

    @Override
    public void save(Transportation transportation) {
        transportationRepo.save(transportation);
    }

    @Override
    public Transportation findById(Long id) {
        return transportationRepo.findById(id);
    }

    @Override
    public List<Transportation> getAll() {
        return transportationRepo.getAll();
    }

    @Override
    public boolean update(Transportation transportation) {
        if (transportation != null) {
            return transportationRepo.update(transportation);
        }

        return false;
    }

    @Override
    public int countAll() {
        return transportationRepo.countAll();
    }
}
