package Homework12_exampleOfParsingXML.carrier.service;

import Homework12_exampleOfParsingXML.carrier.domain.Carrier;
import Homework12_exampleOfParsingXML.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService {
    void add(Carrier carrier);

    Carrier getById(Long id);

    List<Carrier> findByName(String name);

    List<Carrier> getAll();

    void update(Carrier carrier);

}