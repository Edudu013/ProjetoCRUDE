package br.com.almeida.eduardo.exames.exception;

public class DataMaiorAtualException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataMaiorAtualException(String message) {
        super(message);
    }

}
