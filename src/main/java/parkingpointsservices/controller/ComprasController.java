package parkingpointsservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;

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
	public ResponseEntity<Page<Compras>> buscarTodasCompras(
		@RequestParam(value = "page", defaultValue = "0") String page,
		@RequestParam(value = "size", defaultValue = "10") String size) {
		
		Pageable paging = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
		return new ResponseEntity<>(service.buscarTodasCompras(paging), HttpStatus.OK);

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
