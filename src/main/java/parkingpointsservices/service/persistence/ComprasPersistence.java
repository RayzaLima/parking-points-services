package parkingpointsservices.service.persistence;
import parkingpointsservices.model.Compras;

import org.springframework.data.repository.CrudRepository;

public interface ComprasPersistence extends CrudRepository<Compras, Integer>{

}
