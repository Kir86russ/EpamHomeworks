package Homework13_saxParser.transportation.service;

import Homework13_saxParser.common.business.service.CommonService;
import Homework13_saxParser.transportation.domain.Transportation;

import java.util.List;

public interface TransportationService extends CommonService {
    void add(Transportation transportation);

    Transportation getById(Long id);

    List<Transportation> getAll();

    void update(Transportation transportation);

}