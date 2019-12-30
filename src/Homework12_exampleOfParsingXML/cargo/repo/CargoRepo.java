package Homework12_exampleOfParsingXML.cargo.repo;

import Homework12_exampleOfParsingXML.cargo.domain.Cargo;
import Homework12_exampleOfParsingXML.cargo.search.CargoSearchCondition;
import Homework12_exampleOfParsingXML.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}