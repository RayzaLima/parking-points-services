package parkingpointsservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import parkingpointsservices.model.Compras;
import parkingpointsservices.model.Pontos;
import parkingpointsservices.service.persistence.ComprasPersistence;

@Service
public class ComprasService {
	
	@Autowired
	private ComprasPersistence comprasPersistence;
	
	public Compras salvarCompras(Compras compras) {
		return comprasPersistence.save(compras);
	}
	
	public Optional<Compras> buscarComprasPeloId(int id) {
		return comprasPersistence.findById(id);
	}
	
	public Page<Compras> buscarTodasCompras(Pageable paging) {
		return comprasPersistence.findAll(paging);
	}
	
	public void deletarCompras(int id) {
		comprasPersistence.deleteById(id);
	}
	
	public void atualizar(Compras compras, Compras comprasAtualizadas) {
		compras.setProdutoCompra(comprasAtualizadas.getProdutoCompra());
		compras.setDataCompraProduto(comprasAtualizadas.getDataCompraProduto());
		compras.setNotaFiscal(comprasAtualizadas.getNotaFiscal());
		compras.setLojaCompra(comprasAtualizadas.getLojaCompra());
		compras.setValorNota(comprasAtualizadas.getValorNota());
		comprasPersistence.save(compras);
	}

	public Double salvarPontos(Compras compras) {
        Double pontosAdquiridos = (compras.getValorNota() / 10);
		return pontosAdquiridos;
    }

	public void salvarPontos2(Compras compras, Compras pontosGanhos) {
		compras.setValorNota((pontosGanhos.getValorNota() / 10));
		comprasPersistence.save(compras);
	}

}
