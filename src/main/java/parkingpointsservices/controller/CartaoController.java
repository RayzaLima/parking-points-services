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

import parkingpointsservices.model.Cartao;
import parkingpointsservices.service.CartaoService;

@Controller
@RequestMapping(path = "/cartao")
public class CartaoController {
    
    @Autowired
    private CartaoService service;

    @PostMapping
    public ResponseEntity<Cartao> adicionarCartao(@RequestBody Cartao cartao) {
        
        Cartao response = service.salvarCartao(cartao);
        return new ResponseEntity<Cartao>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> buscarTodosCartoes() {
        
        List<Cartao> cartao = service.buscarTodosCartoes();

        if (cartao.isEmpty()) 
            return new ResponseEntity<>(cartao, HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(cartao, HttpStatus.OK);

    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Cartao> buscarCartaoPeloId(@PathVariable int id) {

        Optional<Cartao> cartao = service.buscarCartaoPeloId(id);

        if (cartao.isPresent()) {
            return new ResponseEntity<>(cartao.get(), HttpStatus.OK);
        } 
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") int id, @RequestBody Cartao cartaoAtualizadoCartao) {

        Optional<Cartao> cartao = service.buscarCartaoPeloId(id);
		
		if (cartao.isPresent()) {
			service.atualizar(cartao.get(), cartaoAtualizadoCartao);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") int id) {

        Optional<Cartao> cartao = service.buscarCartaoPeloId(id);

        if (cartao.isPresent()) {
            service.deletarCartao(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

}
