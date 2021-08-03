package br.com.almeida.eduardo.exames.bean;

import java.time.LocalDate;

public class ExameBean {

    private String nomeExame, observacaoExame;
    private long idExame;
    private LocalDate dataExame;
    private PacienteBean paciente;
    
    public ExameBean() {
	
	}
    
    public ExameBean(String nomeExame, String observacaoExame, long idExame, LocalDate dataExame, PacienteBean paciente) {
		super();
		this.nomeExame = nomeExame;
		this.observacaoExame = observacaoExame;
		this.idExame = idExame;
		this.dataExame = dataExame;
		this.paciente = paciente;
	}
    
	public String getNomeExame() {
        return nomeExame;
    }
    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }
    public String getObservacaoExame() {
        return observacaoExame;
    }
    public void setObservacaoExame(String observacaoExame) {
        this.observacaoExame = observacaoExame;
    }
    public long getIdExame() {
        return idExame;
    }
    public void setIdExame(long idExame) {
        this.idExame = idExame;
    }
    public PacienteBean getPaciente() {
        return paciente;
    }
    public void setPaciente(PacienteBean paciente) {
        this.paciente = paciente;
    }
    public LocalDate getDataExame() {
		return dataExame;
	}
    public void setDataExame(LocalDate dataExame) {
		this.dataExame = dataExame;
	}

}