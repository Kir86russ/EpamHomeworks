package Homework19_Optional.cargo.service;

import Homework19_Optional.cargo.domain.Cargo;
import Homework19_Optional.cargo.search.CargoSearchCondition;
import Homework19_Optional.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService<Cargo, Long> {

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}
