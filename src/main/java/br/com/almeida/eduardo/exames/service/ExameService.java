package br.com.almeida.eduardo.exames.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.almeida.eduardo.exames.bean.ExameBean;
import br.com.almeida.eduardo.exames.dao.ExameDao;
import br.com.almeida.eduardo.exames.exception.DataMaiorAtualException;
import br.com.almeida.eduardo.exames.exception.NomePacienteDuplicadoException;

public class ExameService {
	
	
	public void inserir(ExameBean exameBean) throws ClassNotFoundException, SQLException{
		if(exameBean == null || exameBean.getNomeExame().equals("")) {
			throw new IllegalAccessError("nome nao pode ser nulo");
		}
		if(exameBean.getDataExame().isEqual(LocalDate.now()) || exameBean.getDataExame().isBefore(LocalDate.now())) {
			throw new DataMaiorAtualException("data nao pode ser anterior a atual ou no mesmo dia");
		}
		
		ExameDao exameDao = new ExameDao();
		boolean nomePacienteDuplicado = exameDao.nomePacienteDuplicado(exameBean.getPaciente().getNomePaciente());
		
		if(nomePacienteDuplicado) {
			throw new NomePacienteDuplicadoException("nome do paciente ja incluido");
		}
		
		exameDao.inserirExame(exameBean);
		
	}
	
	public ExameBean obterExame(long id) throws ClassNotFoundException, SQLException {
		return new ExameDao().obterExame(id);
	}
	
	public void atualizar(ExameBean exame) throws ClassNotFoundException, SQLException {
		if(exame == null || exame.getNomeExame().equals("")) {
			throw new IllegalAccessError("nome nao pode ser nulo");
		}
		if(exame.getDataExame().isEqual(LocalDate.now()) || exame.getDataExame().isBefore(LocalDate.now())) {
			throw new DataMaiorAtualException("data nao pode ser anterior a atual ou no mesmo dia");
		}
		
		ExameDao exameDao = new ExameDao();
		ExameBean aux = exameDao.getExamePeloNomePaciente(exame.getPaciente().getNomePaciente());
		
		if(aux != null && exame.getIdExame() != aux.getIdExame() && exame.getPaciente().getNomePaciente().equals(aux.getPaciente().getNomePaciente())) {
			throw new NomePacienteDuplicadoException("nome do paciente ja incluido");
		}
		new ExameDao().atualizar(exame);
	}

	public List<ExameBean> obterExames() throws ClassNotFoundException, SQLException {
		return new ExameDao().obterExames();
	}

	public void deletar(long id) throws ClassNotFoundException, SQLException {
		new ExameDao().deletar(id);
	}
	


}
