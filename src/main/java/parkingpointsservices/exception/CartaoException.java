package parkingpointsservices.exception;

public class CartaoException  extends Exception{
    
	private static final long serialVersionUID = -631196487021712994L;

	public CartaoException(String mensagem) {
        super(mensagem);
    }
}
