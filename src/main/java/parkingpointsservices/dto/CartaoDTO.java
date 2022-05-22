package parkingpointsservices.dto;

import java.util.Date;

public class CartaoDTO {

    private int numeroCartao;
    private Date dataEmissaoCartao;

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

}
