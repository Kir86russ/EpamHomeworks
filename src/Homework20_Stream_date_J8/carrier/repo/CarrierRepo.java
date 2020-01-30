package Homework20_Stream_date_J8.carrier.repo;

import Homework20_Stream_date_J8.carrier.domain.Carrier;
import Homework20_Stream_date_J8.common.business.repo.CommonRepo;

import java.util.Optional;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

  Optional<Carrier> getByIdFetchingTransportations(long id);

  Carrier[] findByName(String name);

}
