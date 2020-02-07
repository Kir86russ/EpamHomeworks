package Homework23_Database.carrier.repo;

import Homework23_Database.carrier.domain.Carrier;
import Homework23_Database.common.business.repo.CommonRepo;

import java.util.Optional;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

  Optional<Carrier> getByIdFetchingTransportations(long id);

  Carrier[] findByName(String name);

}
