package Homework20_Stream_date_J8.cargo.service;

import Homework20_Stream_date_J8.cargo.domain.Cargo;
import Homework20_Stream_date_J8.cargo.search.CargoSearchCondition;
import Homework20_Stream_date_J8.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CargoService extends CommonService<Cargo, Long> {

    Optional<Cargo> getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}
