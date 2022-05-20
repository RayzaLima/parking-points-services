package parkingpointsservices.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parkingpointsservices.exception.UsuarioInexistenteException;
import parkingpointsservices.model.CadastroUsuario;
import parkingpointsservices.service.persistence.PointsPersistence;

@Service
public class ParkingPointsLocalService {

    public CadastroUsuario criarUsuario(CadastroUsuario cadastroUsuario) {
        return pointsPersistence.save(cadastroUsuario);
    }

    public CadastroUsuario buscarUsuarioPeloId(int id) throws UsuarioInexistenteException {

        try {
            CadastroUsuario cadastroUsuario = pointsPersistence.findById(id).get();
            return cadastroUsuario;
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

    public CadastroUsuario atualizarUsuario(int id, String nome, String email, String senha, int cpf, int telefone)
            throws UsuarioInexistenteException {

        try {
            CadastroUsuario cadastroUsuario = pointsPersistence.findById(id).get();

            cadastroUsuario.setNome(nome);
            cadastroUsuario.setEmail(email);
            cadastroUsuario.setSenha(senha);
            cadastroUsuario.setCpf(cpf);
            cadastroUsuario.setTelefone(telefone);

            pointsPersistence.save(cadastroUsuario);
            return cadastroUsuario;
        } catch (NoSuchElementException e) {
            throw new UsuarioInexistenteException(String.format("Atualização não pode ser Executada, Usuário não encontrado", id));
        }
    }

    @Autowired
    private PointsPersistence pointsPersistence;

}
