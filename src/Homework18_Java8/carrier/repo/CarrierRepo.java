package Homework18_Java8.carrier.repo;

import Homework18_Java8.carrier.domain.Carrier;
import Homework18_Java8.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

  Carrier getByIdFetchingTransportations(long id);

  Carrier[] findByName(String name);

}
