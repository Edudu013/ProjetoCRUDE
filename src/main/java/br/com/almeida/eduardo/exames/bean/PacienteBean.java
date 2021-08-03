package br.com.almeida.eduardo.exames.bean;


public class PacienteBean{

    private String nomePaciente;
    
    public PacienteBean() {
    	
    }
    
	public PacienteBean(String nomePaciente) {
		super();
		this.nomePaciente = nomePaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

}