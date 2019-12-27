package Homework11.transportation.repo;

import Homework11.common.business.repo.CommonRepo;
import Homework11.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();

    void update(Transportation transportation);
}