package Homework23_Database.cargo.repo;

import Homework23_Database.cargo.domain.Cargo;
import Homework23_Database.cargo.search.CargoSearchCondition;
import Homework23_Database.common.business.repo.CommonRepo;

import java.util.List;
import java.util.Optional;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

  Optional<Cargo> getByIdFetchingTransportations(long id);

  Cargo[] findByName(String name);

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
