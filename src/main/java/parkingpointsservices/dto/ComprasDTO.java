package parkingpointsservices.dto;

import java.util.Date;

public class ComprasDTO {

    private String produtoCompra;
    private Date dataCompraProduto;
    private int notaFiscal;
    private int lojaCompra;
    private Double valorNota;

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

}
