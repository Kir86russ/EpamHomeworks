package Homework18_Java8.carrier.service;

import Homework18_Java8.carrier.domain.Carrier;
import Homework18_Java8.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

  Carrier getByIdFetchingTransportations(Long id);

  List<Carrier> findByName(String name);

}
