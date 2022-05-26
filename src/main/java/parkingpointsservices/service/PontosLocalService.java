package parkingpointsservices.service;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import parkingpointsservices.exception.PontosException;
import parkingpointsservices.model.Pontos;
import parkingpointsservices.service.persistence.PontosPersistence;

@Service
public class PontosLocalService {

    // Adicionar pontos
    public Pontos adicionarPontos(Pontos pontos) {
        return pontosPersistence.save(pontos);
    }

    public Page<Pontos> buscarPontos(Pageable paging) {
        return pontosPersistence.findAll(paging);
    }

    // Falta definir tempo p/ exclusão dos pontos
    public void deletarPontos(int id) throws PontosException {
        try {
            pontosPersistence.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new PontosException(String.format("Não existe pontos a serem deletados", id));
        }

        pontosPersistence.deleteById(id);
    }

    // Atualizar contagem de pontos [TOTAL]
    public Pontos atualizarListaPontos(int id, int pontosCompras, int totalPontos, Date dataAquisicaoPontos,
            Date dataVencimentoPontos) throws PontosException {

        try {
            Pontos pontos = pontosPersistence.findById(id).get();

            pontos.setPontosCompras(pontosCompras);
            pontos.setTotalPontos(totalPontos);
            pontos.setDataAquisicaoPontos(dataAquisicaoPontos);
            pontos.setDataVencimentoPontos(dataVencimentoPontos);

            pontosPersistence.save(pontos);

            return pontos;

        } catch (NoSuchElementException e) {
            throw new PontosException(String.format("Não Existe Lista pra Atualização de Pontos", id));
        }
    }

    @Autowired
    private PontosPersistence pontosPersistence;

}
