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

import parkingpointsservices.model.Usuario;
import parkingpointsservices.service.UsuarioService;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {
	
	@Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> adicionar(@RequestBody Usuario usuario) {
    	
    	Usuario response = service.salvar(usuario);
        return new ResponseEntity<Usuario>(response, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
    	
		List<Usuario> usuarios = service.buscarTodosUsuarios();
		
        if (usuarios.isEmpty())
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<>(usuarios, HttpStatus.OK);      
    }
    
    @GetMapping({"/{id}"})
    public ResponseEntity<Usuario> buscarUsuariosPeloId(@PathVariable int id) {
    	
    	Optional<Usuario> usuario = service.buscarUsuariosPeloId(id);
    	
    	if(usuario.isPresent())    		
    		return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
    	else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") int id, @RequestBody Usuario usuarioAtualizado) {
    	
        Optional<Usuario> usuario = service.buscarUsuariosPeloId(id);
        
        if(usuario.isPresent()){
            service.atualizar(usuario.get(), usuarioAtualizado);
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") int id) {
    	
    	Optional<Usuario> usuario = service.buscarUsuariosPeloId(id);
        
    	if(usuario.isPresent()){
    		service.deletarUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
