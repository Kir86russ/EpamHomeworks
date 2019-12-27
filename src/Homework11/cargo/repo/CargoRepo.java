package Homework11.cargo.repo;

import Homework11.cargo.domain.Cargo;
import Homework11.cargo.search.CargoSearchCondition;
import Homework11.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}