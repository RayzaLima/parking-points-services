package parkingpointsservices.service.persistence;
import parkingpointsservices.model.Pontos;

import org.springframework.data.repository.CrudRepository;

public interface PontosPersistence extends CrudRepository<Pontos, Integer>{
    
}
