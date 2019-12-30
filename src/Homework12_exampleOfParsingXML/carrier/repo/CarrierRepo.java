package Homework12_exampleOfParsingXML.carrier.repo;

import Homework12_exampleOfParsingXML.carrier.domain.Carrier;
import Homework12_exampleOfParsingXML.common.business.repo.CommonRepo;

import java.util.List;

public interface CarrierRepo extends CommonRepo {

    void add(Carrier carrier);

    Carrier getById(long id);

    Carrier[] findByName(String name);

    List<Carrier> getAll();

    void update(Carrier carrier);
}