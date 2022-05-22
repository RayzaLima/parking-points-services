package parkingpointsservices.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parkingpointsservices.exception.UsuarioException;
import parkingpointsservices.model.Usuario;
import parkingpointsservices.service.persistence.UsuarioPersistence;

@Service
public class UsuarioLocalService {

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioPersistence.save(usuario);
    }

    public Usuario buscarUsuarioPeloId(int id) throws UsuarioException {

        try {
            Usuario usuario = usuarioPersistence.findById(id).get();
            return usuario;
        } catch (NoSuchElementException e) {
            throw new UsuarioException(String.format("Usuário Inexistente na Base", id));
        }
    }

    public void deletarUsuario(int id) throws UsuarioException {
        try {
            usuarioPersistence.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new UsuarioException(String.format("Usuário Inexistente na Base", id));
        }

        usuarioPersistence.deleteById(id);
    }

    public Usuario atualizarUsuario(int id, String nome, String email, String senha, int cpf, int telefone)
            throws UsuarioException {

        try {
            Usuario usuario = usuarioPersistence.findById(id).get();

            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setCpf(cpf);
            usuario.setTelefone(telefone);

            usuarioPersistence.save(usuario);
            return usuario;
        } catch (NoSuchElementException e) {
            throw new UsuarioException(
                    String.format("Atualização não pode ser Executada, Usuário não encontrado", id));
        }
    }

    @Autowired
    private UsuarioPersistence usuarioPersistence;

}
