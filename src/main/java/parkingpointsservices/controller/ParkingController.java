package parkingpointsservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import parkingpointsservices.model.Usuario;
import parkingpointsservices.service.UsuarioLocalService;

@Controller
@RequestMapping(path = "/parkingpoints")
public class ParkingController {

    @PostMapping(path = "/usuario")
    public @ResponseBody Usuario adicionarUsuario(@ResponseBody) {
        Usuario usuario = new Usuario();

        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setTelefone(telefone);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        return usuarioService.criarUsuario(usuario);
    }

    @Autowired
    private UsuarioLocalService usuarioService;

    public ParkingController(UsuarioLocalService usuarioService) {
        this.usuarioService = usuarioService;
    }

}
