package parkingpointsservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parkingpointsservices.model.Compras;
import parkingpointsservices.service.persistence.ComprasPersistence;

@Service
public class ComprasService {
	
	@Autowired
	private ComprasPersistence comprasPersistence;
	
	public Compras salvarCompras(Compras compras) {
		return comprasPersistence.save(compras);
	}
	
	public Optional<Compras> buscarPeloId(int id) {
		return comprasPersistence.findById(id);
	}
	
	public List<Compras> buscarTodasCompras() {
		List<Compras> compras = new ArrayList<>();
		comprasPersistence.findAll().forEach(compras::add);
		return compras;
	}
	
	public void deletarCompras(int id) {
		comprasPersistence.deleteById(id);
	}
	
//	Verificar se método vai continuar (atualizar compras???)
	public void atualizar(Compras compras, Compras comprasAtualizadas) {
		compras.setProdutoCompra(comprasAtualizadas.getProdutoCompra());
		compras.setDataCompraProduto(comprasAtualizadas.getDataCompraProduto());
		compras.setNotaFiscal(comprasAtualizadas.getNotaFiscal());
		compras.setLojaCompra(comprasAtualizadas.getLojaCompra());
		compras.setValorNota(comprasAtualizadas.getValorNota());
		comprasPersistence.save(compras);
	}

}
