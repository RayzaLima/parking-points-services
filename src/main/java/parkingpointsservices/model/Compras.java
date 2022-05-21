package parkingpointsservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compras {

    private int id;
    private String produtoCompra;
    private Date dataCompraProduto;
    private int notaFiscal;
    private int lojaCompra;
    private Double valorNota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutoCompra() {
        return produtoCompra;
    }

    public void setProdutoCompra(String produtoCompra) {
        this.produtoCompra = produtoCompra;
    }

    public Date getDataCompraProduto() {
        return dataCompraProduto;
    }

    public void setDataCompraProduto(Date dataCompraProduto) {
        this.dataCompraProduto = dataCompraProduto;
    }

    public int getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(int notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public int getLojaCompra() {
        return lojaCompra;
    }

    public void setLojaCompra(int lojaCompra) {
        this.lojaCompra = lojaCompra;
    }

    public Double getValorNota() {
        return valorNota;
    }

    public void setValorNota(Double valorNota) {
        this.valorNota = valorNota;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(columnDefinition = "TEXT")
    private String texto;

}
