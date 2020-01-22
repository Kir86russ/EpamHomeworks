package Homework16_cancurrency.carrier.repo;

import Homework16_cancurrency.carrier.domain.Carrier;
import Homework16_cancurrency.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

  Carrier getByIdFetchingTransportations(long id);

  Carrier[] findByName(String name);

}
