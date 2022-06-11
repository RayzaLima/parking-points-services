package parkingpointsservices.service.persistence;

import org.springframework.data.repository.CrudRepository;

import parkingpointsservices.model.Cartao;

public interface CartaoPersistence extends CrudRepository<Cartao, Integer> {

}
