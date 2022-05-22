package parkingpointsservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import parkingpointsservices.dto.UsuarioDTO;
import parkingpointsservices.exception.UsuarioException;
import parkingpointsservices.model.Usuario;
import parkingpointsservices.service.UsuarioLocalService;

@Controller
@RequestMapping(path = "/parkingpoints")
public class UsuarioController {

    @PostMapping(path = "/usuario")
    public @ResponseBody Usuario adicionarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());

        return usuarioLocalService.criarUsuario(usuario);
    }

    @DeleteMapping(path = "/usuario/{id}")
    public @ResponseBody String deletarUsuario(@PathVariable("id") String id) {
        try {
            usuarioLocalService.deletarUsuario(Integer.parseInt(id));
            return "Usuário Deletado com Sucesso";
        } catch (UsuarioException e) {
            return e.getMessage();
        }
    }

    @Autowired
    private UsuarioLocalService usuarioLocalService;

}
