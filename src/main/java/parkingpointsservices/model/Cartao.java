package parkingpointsservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cartao {

    private int id;
    private int numeroCartao;
    private Date dataEmissaoCartao;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    // Get's e Set's do cadastro de usuário
    @Column(columnDefinition = "TEXT")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Date getDataEmissaoCartao() {
        return dataEmissaoCartao;
    }

    public void setDataEmissaoCartao(Date dataEmissaoCartao) {
        this.dataEmissaoCartao = dataEmissaoCartao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(columnDefinition = "TEXT")
    private String texto;

}
