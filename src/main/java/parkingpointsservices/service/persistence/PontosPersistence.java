package parkingpointsservices.service.persistence;
import parkingpointsservices.model.Pontos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PontosPersistence extends CrudRepository<Pontos, Integer>{
    
    // serve para limitar quantos arquivos vao aparecer
    Page<Pontos> findAll(Pageable pageable);
}
