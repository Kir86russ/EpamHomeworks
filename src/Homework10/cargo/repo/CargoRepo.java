package Homework10.cargo.repo;

import Homework10.cargo.domain.Cargo;
import Homework10.cargo.search.CargoSearchCondition;
import Homework10.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo> {

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}