package parkingpointsservices.service.persistence;
import parkingpointsservices.model.Usuario;

import org.springframework.data.repository.CrudRepository;


public interface PointsPersistence extends CrudRepository<Usuario, Integer>{
    
}
