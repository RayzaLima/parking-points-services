package parkingpointsservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parkingpointsservices.model.Usuario;
import parkingpointsservices.service.persistence.UsuarioPersistence;

@Service
public class UsuarioService {
	
	@Autowired
    private UsuarioPersistence usuarioPersistence;

    public Usuario salvar(Usuario usuario) {
        return usuarioPersistence.save(usuario);
    }

    public Optional<Usuario> buscarUsuariosPeloId(int id) {
    	return usuarioPersistence.findById(id);
    }
    
    public List<Usuario> buscarTodosUsuarios() {
    	List<Usuario> usuarios = new ArrayList<>();
    	usuarioPersistence.findAll().forEach(usuarios::add);
    	return usuarios;
    }

    public void deletarUsuario(int id) {
    	usuarioPersistence.deleteById(id);
    }

    public void atualizar(Usuario usuario, Usuario usuarioAtualizado) {
    	usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());
        usuario.setCpf(usuarioAtualizado.getCpf());
        usuario.setTelefone(usuarioAtualizado.getTelefone());
        usuarioPersistence.save(usuario);   
    }
}
