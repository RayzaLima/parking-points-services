package parkingpointsservices.service.persistence;
import parkingpointsservices.model.CadastroUsuario;

import org.springframework.data.repository.CrudRepository;


public interface PointsPersistence extends CrudRepository<CadastroUsuario, Integer>{
    
}
