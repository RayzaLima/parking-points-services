package parkingpointsservices.dto;

import java.util.Date;

public class PontosDTO {

    private int pontosCompras;
    private int totalPontos;
    private Date dataAquisicaoPontos;
    private Date dataVencimentoPontos;
    //private int creditoPontos;
    private int debitoPontos;

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

    /* public int getCreditoPontos() {
        return creditoPontos;
    }

    public void setCreditoPontos(int creditoPontos) {
        this.creditoPontos = creditoPontos;
    } */

    public int getDebitoPontos() {
        return debitoPontos;
    }

    public void setDebitoPontos(int debitoPontos) {
        this.debitoPontos = debitoPontos;
    }
}
