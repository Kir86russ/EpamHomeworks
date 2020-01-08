package Homework13_saxParser.cargo.service;

import Homework13_saxParser.cargo.domain.Cargo;
import Homework13_saxParser.cargo.search.CargoSearchCondition;
import Homework13_saxParser.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService {

    void add(Cargo cargo);

    Cargo getById(Long id);

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> getAll();

    List<Cargo> findByName(String name);

    void update(Cargo cargo);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}