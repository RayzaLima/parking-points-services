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

import parkingpointsservices.model.Pontos;
import parkingpointsservices.service.PontosService;

@Controller
@RequestMapping(path = "/pontos")
public class PontosController {
	
	@Autowired
    private PontosService service;
    
    @PostMapping
    public ResponseEntity<Pontos> adicionar(@RequestBody Pontos pontos) {
    	Pontos response = service.salvar(pontos);
        return new ResponseEntity<Pontos>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Pontos>> buscar(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable paging = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        return new ResponseEntity<>(service.buscarPontos(paging), HttpStatus.OK); 
    }
    
    @GetMapping({"/{id}"})
    public ResponseEntity<Pontos> buscarPeloId(@PathVariable int id) {
    	
    	Optional<Pontos> pontos = service.buscarPeloId(id);
    	
    	if(pontos.isPresent())    		
    		return new ResponseEntity<>(pontos.get(), HttpStatus.OK);
    	else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") int id, @RequestBody Pontos pontosAtualizado) {
    	
        Optional<Pontos> pontos = service.buscarPeloId(id);
        
        if(pontos.isPresent()){
            service.atualizar(pontos.get(), pontosAtualizado);
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") int id) {
    	
    	Optional<Pontos> pontos = service.buscarPeloId(id);
        
    	if(pontos.isPresent()){
    		service.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
