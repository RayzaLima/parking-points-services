package parkingpointsservices.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class Pontos {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
    private int pontosCompras;
    
    private int totalPontos;
    
    private Date dataAquisicaoPontos;
    
    private Date dataVencimentoPontos;
    
    private int creditoPontos;
    
    private int debitoPontos;
}
