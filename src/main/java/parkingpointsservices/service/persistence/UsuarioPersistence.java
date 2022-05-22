package parkingpointsservices.service.persistence;
import parkingpointsservices.model.Usuario;

import org.springframework.data.repository.CrudRepository;


public interface UsuarioPersistence extends CrudRepository<Usuario, Integer>{
    
}
