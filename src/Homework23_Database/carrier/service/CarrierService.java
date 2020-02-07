package Homework23_Database.carrier.service;

import Homework23_Database.carrier.domain.Carrier;
import Homework23_Database.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CarrierService extends CommonService<Carrier, Long> {

  Optional<Carrier> getByIdFetchingTransportations(Long id);

  List<Carrier> findByName(String name);

}
