package Homework13_saxParser.transportation.repo;

import Homework13_saxParser.common.business.repo.CommonRepo;
import Homework13_saxParser.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();

    void update(Transportation transportation);
}