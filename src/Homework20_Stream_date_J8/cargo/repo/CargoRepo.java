package Homework20_Stream_date_J8.cargo.repo;

import Homework20_Stream_date_J8.cargo.domain.Cargo;
import Homework20_Stream_date_J8.cargo.search.CargoSearchCondition;
import Homework20_Stream_date_J8.common.business.repo.CommonRepo;

import java.util.List;
import java.util.Optional;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

  Optional<Cargo> getByIdFetchingTransportations(long id);

  Cargo[] findByName(String name);

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
