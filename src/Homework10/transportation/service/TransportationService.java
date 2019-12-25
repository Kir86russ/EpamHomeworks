package Homework10.transportation.service;

import Homework10.common.business.service.CommonService;
import Homework10.transportation.domain.Transportation;

import java.util.List;

public interface TransportationService extends CommonService {
    void add(Transportation transportation);

    Transportation getById(Long id);

    List<Transportation> getAll();

    void update(Transportation transportation);

}