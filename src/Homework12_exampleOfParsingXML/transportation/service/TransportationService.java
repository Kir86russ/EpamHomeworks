package Homework12_exampleOfParsingXML.transportation.service;

import Homework12_exampleOfParsingXML.common.business.service.CommonService;
import Homework12_exampleOfParsingXML.transportation.domain.Transportation;

import java.util.List;

public interface TransportationService extends CommonService {
    void add(Transportation transportation);

    Transportation getById(Long id);

    List<Transportation> getAll();

    void update(Transportation transportation);

}