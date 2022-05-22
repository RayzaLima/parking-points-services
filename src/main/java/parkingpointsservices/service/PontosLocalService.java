package parkingpointsservices.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parkingpointsservices.exception.PontosException;
import parkingpointsservices.service.persistence.PontosPersistence;

@Service
public class PontosLocalService {

    // Falta definir tempo p/ exclusão dos pontos
    public void deletarPontos(int id) throws PontosException {
        try {
            pontosPersistence.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new PontosException(String.format("Não existe pontos a serem deletados", id));
        }

        pontosPersistence.deleteById(id);
    }

    // Adicionar pontos

    // Atualizar contagem de pontos [TOTAL]

    @Autowired
    private PontosPersistence pontosPersistence;

}
