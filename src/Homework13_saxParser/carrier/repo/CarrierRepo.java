package Homework13_saxParser.carrier.repo;

import Homework13_saxParser.carrier.domain.Carrier;
import Homework13_saxParser.common.business.repo.CommonRepo;

import java.util.List;

public interface CarrierRepo extends CommonRepo {

    void add(Carrier carrier);

    Carrier getById(long id);

    Carrier[] findByName(String name);

    List<Carrier> getAll();

    void update(Carrier carrier);
}