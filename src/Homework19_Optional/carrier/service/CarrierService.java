package Homework19_Optional.carrier.service;

import Homework19_Optional.carrier.domain.Carrier;
import Homework19_Optional.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

  Carrier getByIdFetchingTransportations(Long id);

  List<Carrier> findByName(String name);

}
