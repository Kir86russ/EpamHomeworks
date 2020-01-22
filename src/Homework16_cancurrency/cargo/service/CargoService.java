package Homework16_cancurrency.cargo.service;

import Homework16_cancurrency.cargo.domain.Cargo;
import Homework16_cancurrency.cargo.search.CargoSearchCondition;
import Homework16_cancurrency.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService<Cargo, Long> {

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}
