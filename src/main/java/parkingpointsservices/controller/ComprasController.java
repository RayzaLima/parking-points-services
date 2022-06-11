package parkingpointsservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import parkingpointsservices.model.Compras;
import parkingpointsservices.service.ComprasService;

@Controller
@RequestMapping(path = "/compras")
public class ComprasController {
	
	@Autowired
	private ComprasService service;
	
	@PostMapping
	public ResponseEntity<Compras> adicionarCompras(@RequestBody Compras compras) {
		
		Compras response = service.salvarCompras(compras);
		return new ResponseEntity<Compras>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Compras>> buscarTodasCompras() {
		
		List<Compras> compras = service.buscarTodasCompras();
		
		if (compras.isEmpty())
			return new ResponseEntity<>(compras, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(compras, HttpStatus.OK);

	}

	@GetMapping({"/{id}"})
	public ResponseEntity<Compras> buscarComprasPeloId(@PathVariable int id) {

		Optional<Compras> compras = service.buscarComprasPeloId(id);

		if (compras.isPresent()) {
			return new ResponseEntity<>(compras.get(), HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable("id") int id, @RequestBody Compras comprasAtualizadas) {

		Optional<Compras> compras = service.buscarComprasPeloId(id);
		
		if (compras.isPresent()) {
			service.atualizar(compras.get(), comprasAtualizadas);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") int id) {

		Optional<Compras> compras = service.buscarComprasPeloId(id);

		if (compras.isPresent()) {
			service.deletarCompras(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
