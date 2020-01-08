package Homework13_saxParser.carrier.service;

import Homework13_saxParser.carrier.domain.Carrier;
import Homework13_saxParser.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService {
    void add(Carrier carrier);

    Carrier getById(Long id);

    List<Carrier> findByName(String name);

    List<Carrier> getAll();

    void update(Carrier carrier);

}