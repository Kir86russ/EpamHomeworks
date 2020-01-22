package Homework16_cancurrency.cargo.repo;

import Homework16_cancurrency.cargo.domain.Cargo;
import Homework16_cancurrency.cargo.search.CargoSearchCondition;
import Homework16_cancurrency.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

  Cargo getByIdFetchingTransportations(long id);

  Cargo[] findByName(String name);

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
