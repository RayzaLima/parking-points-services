package parkingpointsservices.service.persistence;
import parkingpointsservices.model.Compras;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ComprasPersistence extends CrudRepository<Compras, Integer>{

    // serve para limitar quantos arquivos vao aparecer
    Page<Compras> findAll(Pageable pageable);

}
