package parkingpointsservices.service.persistence;
import org.springframework.data.repository.CrudRepository;

import parkingpointsservices.model.Usuario;


public interface UsuarioPersistence extends CrudRepository<Usuario, Integer>{
    
}
