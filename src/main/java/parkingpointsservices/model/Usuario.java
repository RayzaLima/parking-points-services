package parkingpointsservices.model;

import javax.persistence.Column;
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
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(nullable = false)
    private String nome;
	
    private String email;
    
    private String senha;
    
    private int cpf;
    
    private int telefone;

    @OneToOne
    @JoinColumn(name = "points_id")
    private Pontos pontos;
}
