package parkingpointsservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import parkingpointsservices.service.UsuarioLocalService;

@Controller
@RequestMapping(path = "/parkingpoints")
public class ParkingController {

    @Autowired
    private UsuarioLocalService usuarioService;

}
