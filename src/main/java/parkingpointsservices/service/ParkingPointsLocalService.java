package parkingpointsservices.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parkingpointsservices.exception.UsuarioInexistenteException;
import parkingpointsservices.model.Usuario;
import parkingpointsservices.service.persistence.PointsPersistence;

@Service
public class ParkingPointsLocalService {

    public Usuario criarUsuario(Usuario usuario) {
        return pointsPersistence.save(usuario);
    }

    public Usuario buscarUsuarioPeloId(int id) throws UsuarioInexistenteException {

        try {
            Usuario usuario = pointsPersistence.findById(id).get();
            return usuario;
        } catch (NoSuchElementException e) {
            throw new UsuarioInexistenteException(String.format("Usuário Inexistente na Base", id));
        }
    }

    public void deletarUsuario(int id) throws UsuarioInexistenteException {
        try {
            pointsPersistence.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new UsuarioInexistenteException(String.format("Usuário Inexistente na Base", id));
        }

        pointsPersistence.deleteById(id);
    }

    public Usuario atualizarUsuario(int id, String nome, String email, String senha, int cpf, int telefone)
            throws UsuarioInexistenteException {

        try {
            Usuario usuario = pointsPersistence.findById(id).get();

            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setCpf(cpf);
            usuario.setTelefone(telefone);

            pointsPersistence.save(usuario);
            return usuario;
        } catch (NoSuchElementException e) {
            throw new UsuarioInexistenteException(
                    String.format("Atualização não pode ser Executada, Usuário não encontrado", id));
        }
    }

    @Autowired
    private PointsPersistence pointsPersistence;

}
