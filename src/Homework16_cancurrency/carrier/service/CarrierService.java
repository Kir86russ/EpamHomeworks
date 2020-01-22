package Homework16_cancurrency.carrier.service;

import Homework16_cancurrency.carrier.domain.Carrier;
import Homework16_cancurrency.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

  Carrier getByIdFetchingTransportations(Long id);

  List<Carrier> findByName(String name);

}
