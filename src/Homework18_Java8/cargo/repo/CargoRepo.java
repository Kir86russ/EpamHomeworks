package Homework18_Java8.cargo.repo;

import Homework18_Java8.cargo.domain.Cargo;
import Homework18_Java8.cargo.search.CargoSearchCondition;
import Homework18_Java8.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

  Cargo getByIdFetchingTransportations(long id);

  Cargo[] findByName(String name);

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
