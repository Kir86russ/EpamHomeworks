package Homework12_exampleOfParsingXML.transportation.repo;

import Homework12_exampleOfParsingXML.common.business.repo.CommonRepo;
import Homework12_exampleOfParsingXML.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();

    void update(Transportation transportation);
}