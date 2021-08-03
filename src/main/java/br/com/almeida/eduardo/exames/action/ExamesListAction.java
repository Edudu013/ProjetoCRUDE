package br.com.almeida.eduardo.exames.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.almeida.eduardo.exames.bean.ExameBean;
import br.com.almeida.eduardo.exames.service.ExameService;

public class ExamesListAction extends ActionSupport {
	
	private List<ExameBean> obterExames;

	public String execute() {
		try {
			setObterExames(new ExameService().obterExames());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<ExameBean> getObterExames() {
		return obterExames;
	}

	public void setObterExames(List<ExameBean> obterExames) {
		this.obterExames = obterExames;
	}

}
