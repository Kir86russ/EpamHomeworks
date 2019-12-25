package Homework10.cargo.service;

import Homework10.cargo.domain.Cargo;
import Homework10.cargo.search.CargoSearchCondition;
import Homework10.common.business.service.CommonService;

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