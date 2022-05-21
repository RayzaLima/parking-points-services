package parkingpointsservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pontos {

    private int id;
    private int pontosCompras;
    private int totalPontos;
    private Date dataAquisicaoPontos;
    private Date dataVencimentoPontos;
    private int creditoPontos;
    private int debitoPontos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getPontosCompras() {
        return pontosCompras;
    }

    public void setPontosCompras(int pontosCompras) {
        this.pontosCompras = pontosCompras;
    }

    public int getTotalPontos() {
        return totalPontos;
    }

    public void setTotalPontos(int totalPontos) {
        this.totalPontos = totalPontos;
    }

    public Date getDataAquisicaoPontos() {
        return dataAquisicaoPontos;
    }

    public void setDataAquisicaoPontos(Date dataAquisicaoPontos) {
        this.dataAquisicaoPontos = dataAquisicaoPontos;
    }

    public Date getDataVencimentoPontos() {
        return dataVencimentoPontos;
    }

    public void setDataVencimentoPontos(Date dataVencimentoPontos) {
        this.dataVencimentoPontos = dataVencimentoPontos;
    }

    public int getCreditoPontos() {
        return creditoPontos;
    }

    public void setCreditoPontos(int creditoPontos) {
        this.creditoPontos = creditoPontos;
    }

    public int getDebitoPontos() {
        return debitoPontos;
    }

    public void setDebitoPontos(int debitoPontos) {
        this.debitoPontos = debitoPontos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(columnDefinition = "TEXT")
    private String texto;

}
