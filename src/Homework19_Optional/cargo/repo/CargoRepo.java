package Homework19_Optional.cargo.repo;

import Homework19_Optional.cargo.domain.Cargo;
import Homework19_Optional.cargo.search.CargoSearchCondition;
import Homework19_Optional.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

  Cargo getByIdFetchingTransportations(long id);

  Cargo[] findByName(String name);

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
