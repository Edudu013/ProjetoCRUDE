package br.com.almeida.eduardo.exames.exception;

public class NomePacienteDuplicadoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NomePacienteDuplicadoException(String message) {
        super(message);
    }

}
