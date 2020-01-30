package Homework20_Stream_date_J8.carrier.service;

import Homework20_Stream_date_J8.carrier.domain.Carrier;
import Homework20_Stream_date_J8.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CarrierService extends CommonService<Carrier, Long> {

  Optional<Carrier> getByIdFetchingTransportations(Long id);

  List<Carrier> findByName(String name);

}
