package parkingpointsservices.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import parkingpointsservices.dto.PontosDTO;
import parkingpointsservices.helper.PontosHelper;
import parkingpointsservices.model.Pontos;
import parkingpointsservices.service.PontosLocalService;

@Controller
@RequestMapping(path = "/parkingpoints")
@CrossOrigin(origins = "http://localhost:3000")
public class PontosController {
    
    @PostMapping(path = "/pontos")
    public @ResponseBody Pontos adicionarPontos(@RequestBody PontosDTO pontosDTO) {
        Pontos pontos = new Pontos();

        pontos.setPontosCompras(pontosDTO.getPontosCompras());
        pontos.setTotalPontos(pontosDTO.getTotalPontos());
        pontos.setDataAquisicaoPontos(PontosHelper.converterStringParaData(pontosDTO.getDataAquisicaoPontos()));
        pontos.setDataVencimentoPontos(PontosHelper.converterStringParaData(pontosDTO.getDataVencimentoPontos()));
        pontos.setDebitoPontos(pontosDTO.getDebitoPontos());

        return pontoslocalService.adicionarPontos(pontos);
    }

    @GetMapping(path = "/pontos")
    public @ResponseBody Page<Pontos> buscarPontos(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable paging = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));

        return pontoslocalService.buscarPontos(paging);
    }

    #Autowired
    private PontosLocalService pontoslocalService;
}
