package parkingpointsservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import parkingpointsservices.model.Pontos;
import parkingpointsservices.service.persistence.PontosPersistence;

@Service
public class PontosService {
	
	@Autowired
    private PontosPersistence pontosPersistence;
	
	public Pontos salvar(Pontos pontos) {
        return pontosPersistence.save(pontos);
    }

    public Optional<Pontos> buscarPeloId(int id) {
    	return pontosPersistence.findById(id);
    }

    public Page<Pontos> buscarPontos(Pageable paging) {
        return pontosPersistence.findAll(paging);
    }    

    public void deletar(int id) {
    	pontosPersistence.deleteById(id);
    }
    
    public void atualizar(Pontos pontos, Pontos pontosAtualizado) {
    	pontos.setPontosCompras(pontosAtualizado.getPontosCompras());
    	pontos.setTotalPontos(pontosAtualizado.getTotalPontos());
        pontos.setDataAquisicaoPontos(pontosAtualizado.getDataAquisicaoPontos());
        pontos.setDataVencimentoPontos(pontosAtualizado.getDataVencimentoPontos());
        pontos.setCreditoPontos(pontosAtualizado.getCreditoPontos());
        pontos.setDebitoPontos(pontosAtualizado.getDebitoPontos());
    	pontosPersistence.save(pontos);   
    }
}
