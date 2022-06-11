package parkingpointsservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parkingpointsservices.model.Cartao;
import parkingpointsservices.service.persistence.CartaoPersistence;

@Service
public class CartaoService {

    @Autowired
    private CartaoPersistence cartaoPersistence;

    public Cartao salvarCartao(Cartao cartao) {
        return cartaoPersistence.save(cartao);
    }

    public Optional<Cartao> buscarCartaoPeloId(int id) {
        return cartaoPersistence.findById(id);
    }

    public List<Cartao> buscarTodosCartoes() {
        List<Cartao> cartao = new ArrayList<>();
        cartaoPersistence.findAll().forEach(cartao::add);
        return cartao;
    }

    public void deletarCartao(int id) {
        cartaoPersistence.deleteById(id);
    }

    public void atualizar(Cartao cartao, Cartao cartaoAtualizado) {
        cartao.setNumeroCartao(cartaoAtualizado.getNumeroCartao());
        cartao.setDataEmissaoCartao(cartaoAtualizado.getDataEmissaoCartao());
        cartaoPersistence.save(cartao);
    }
    
}
