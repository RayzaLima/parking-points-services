package parkingpointsservices.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class Compras {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
    private String produtoCompra;
    
    private Date dataCompraProduto;
    
    private int notaFiscal;
    
    private int lojaCompra;
    
    private Double valorNota;
    
    @OneToOne
    @JoinColumn(name = "points_id")
    private Pontos pontos;
    
}
