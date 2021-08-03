package br.com.almeida.eduardo.exames.action;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.opensymphony.xwork2.ActionSupport;

import br.com.almeida.eduardo.exames.bean.ExameBean;
import br.com.almeida.eduardo.exames.exception.DataMaiorAtualException;
import br.com.almeida.eduardo.exames.exception.NomePacienteDuplicadoException;
import br.com.almeida.eduardo.exames.service.ExameService;

public class AtualizarExameAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private boolean nomeExameNulo;
	private boolean dataAtual;
	private boolean nomeDuplicado;
	private boolean erroGeral;
	private boolean sucesso;
	private String dataExame;
	private ExameBean exame;
	
	
	public String execute(){
		try {
			if(getId() > 0) {
				exame = new ExameService().obterExame(getId());
			}
			
		} catch (SQLException e) {
			this.erroGeral = true;
		} catch (ClassNotFoundException e) {
			this.erroGeral = true;
			this.setSucesso(false);
		}
		return SUCCESS;
	}
	
	public String salvar() {
		try {
			if(exame.getIdExame() > 0) {
				if(!dataExame.equals("")) {
					String[] split = dataExame.split("-");
					exame.setDataExame(LocalDate.of(Integer.valueOf(split[0]),Integer.valueOf(split[1]),Integer.valueOf(split[2])));
				}
				new ExameService().atualizar(exame);
			}
			
			this.nomeExameNulo = false;
			this.setDataAtual(false);
			this.nomeDuplicado = false;
			this.erroGeral = false;
			this.setSucesso(true);
			
		} catch (IllegalAccessError e) {
			this.setNomeExameNulo(true);
			this.setSucesso(false);
		} catch (DataMaiorAtualException e) {
			this.setDataAtual(true);
			this.setSucesso(false);
		} catch (NomePacienteDuplicadoException e) {
			this.nomeDuplicado = true;
			this.setSucesso(false);
		}catch (SQLException e) {
			this.erroGeral = true;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			this.erroGeral = true;
			this.setSucesso(false);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public boolean isNomeExameNulo() {
		return nomeExameNulo;
	}

	public void setNomeExameNulo(boolean nomeExameNulo) {
		this.nomeExameNulo = nomeExameNulo;
	}

	public ExameBean getExame() {
		return exame;
	}

	public void setExame(ExameBean exame) {
		this.exame = exame;
	}

	public boolean isDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(boolean dataAtual) {
		this.dataAtual = dataAtual;
	}

	public String getDataExame() {
		return dataExame;
	}

	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}

	public boolean isNomeDuplicado() {
		return nomeDuplicado;
	}

	public void setNomeDuplicado(boolean nomeDuplicado) {
		this.nomeDuplicado = nomeDuplicado;
	}

	public boolean isErroGeral() {
		return erroGeral;
	}

	public void setErroGeral(boolean erroGeral) {
		this.erroGeral = erroGeral;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
