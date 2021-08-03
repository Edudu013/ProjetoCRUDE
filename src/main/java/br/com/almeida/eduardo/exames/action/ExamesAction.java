package br.com.almeida.eduardo.exames.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.almeida.eduardo.exames.bean.ExameBean;

public class ExamesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ExameBean exame;
	
	
	public String execute(){
		return SUCCESS;
	}
	
	public ExameBean getExame() {
		return exame;
	}

	public void setExame(ExameBean exame) {
		this.exame = exame;
	}

}
