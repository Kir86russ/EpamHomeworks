package Homework12_exampleOfParsingXML.cargo.service;

import Homework12_exampleOfParsingXML.cargo.domain.Cargo;
import Homework12_exampleOfParsingXML.cargo.search.CargoSearchCondition;
import Homework12_exampleOfParsingXML.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService {

    void add(Cargo cargo);

    Cargo getById(Long id);

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> getAll();

    List<Cargo> findByName(String name);

    void update(Cargo cargo);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}