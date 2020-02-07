package Homework23_Database.cargo.service;

import Homework23_Database.cargo.domain.Cargo;
import Homework23_Database.cargo.search.CargoSearchCondition;
import Homework23_Database.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CargoService extends CommonService<Cargo, Long> {

    Optional<Cargo> getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}
