package Homework19_Optional.carrier.repo;

import Homework19_Optional.carrier.domain.Carrier;
import Homework19_Optional.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

  Carrier getByIdFetchingTransportations(long id);

  Carrier[] findByName(String name);

}
