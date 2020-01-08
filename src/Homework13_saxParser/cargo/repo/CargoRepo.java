package Homework13_saxParser.cargo.repo;

import Homework13_saxParser.cargo.domain.Cargo;
import Homework13_saxParser.cargo.search.CargoSearchCondition;
import Homework13_saxParser.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}