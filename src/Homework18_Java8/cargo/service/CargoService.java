package Homework18_Java8.cargo.service;

import Homework18_Java8.cargo.domain.Cargo;
import Homework18_Java8.cargo.search.CargoSearchCondition;
import Homework18_Java8.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService<Cargo, Long> {

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}
