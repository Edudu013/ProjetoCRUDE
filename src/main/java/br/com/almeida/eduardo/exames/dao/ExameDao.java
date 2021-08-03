package br.com.almeida.eduardo.exames.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.almeida.eduardo.exames.bean.ExameBean;
import br.com.almeida.eduardo.exames.bean.PacienteBean;

public class ExameDao {
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connectionUrl = "jdbc:mysql://localhost:3306/bancoteste";
		String dbUser = "root";
		String dbPwd = "";
		
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}
	
	
	public void inserirExame(ExameBean exameBean) throws SQLException, ClassNotFoundException {
		Connection conexao = getConnection();
		PreparedStatement stmt =  conexao.prepareStatement("insert into exames(nome_exame, data_exame, nome_paciente, descricao) values (?, ?, ?, ?)");
		stmt.setString(1, exameBean.getNomeExame());
		stmt.setString(2, exameBean.getDataExame().toString());
		stmt.setString(3, exameBean.getPaciente().getNomePaciente());
		stmt.setString(4, exameBean.getObservacaoExame());
		stmt.executeUpdate();
	}
	
	public List<ExameBean> obterExames() throws ClassNotFoundException, SQLException {
		Connection conexao = getConnection();
		PreparedStatement stmt =  conexao.prepareStatement("select id, nome_exame, data_exame, nome_paciente, descricao from exames order by nome_exame, nome_paciente asc");
		ResultSet rs = stmt.executeQuery();
		List<ExameBean> exameBeanList =  new ArrayList<>();
		ExameBean exame = null;
		PacienteBean paciente = null;
		while(rs.next()) {
			exame = new ExameBean();
			exame.setIdExame(rs.getLong("id"));
			exame.setNomeExame(rs.getString("nome_exame"));
			
			paciente = new PacienteBean();
			paciente.setNomePaciente(rs.getString("nome_paciente"));
			exame.setPaciente(paciente);
			
			String[] string = rs.getString("data_exame").split("-");
			exame.setDataExame(LocalDate.of(Integer.valueOf(string[0]), Integer.valueOf(string[1]) , Integer.valueOf(string[2])));
			
			exame.setObservacaoExame(rs.getString("descricao"));
			
			exameBeanList.add(exame);
		}
		return exameBeanList;
	}


	public boolean nomePacienteDuplicado(String nomePaciente) throws ClassNotFoundException, SQLException {
		Connection conexao = getConnection();
		PreparedStatement stmt =  conexao.prepareStatement("select nome_paciente from exames where nome_paciente = ?");
		stmt.setString(1, nomePaciente);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		
		return false;
	}


	public ExameBean obterExame(long id) throws ClassNotFoundException, SQLException {
		Connection conexao = getConnection();
		PreparedStatement stmt =  conexao.prepareStatement("select id, nome_exame, data_exame, nome_paciente, descricao from exames where id = ?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		ExameBean exame = null;
		PacienteBean paciente = null;
		
		if(rs.next()) {
			exame = new ExameBean();
			exame.setIdExame(rs.getLong("id"));
			exame.setNomeExame(rs.getString("nome_exame"));
			
			paciente = new PacienteBean();
			paciente.setNomePaciente(rs.getString("nome_paciente"));
			exame.setPaciente(paciente);
			
			String[] string = rs.getString("data_exame").split("-");
			exame.setDataExame(LocalDate.of(Integer.valueOf(string[0]), Integer.valueOf(string[1]) , Integer.valueOf(string[2])));
			
			exame.setObservacaoExame(rs.getString("descricao"));
		}
		return exame;
	}


	public void atualizar(ExameBean exameBean) throws SQLException, ClassNotFoundException {
		Connection conexao = getConnection();
		PreparedStatement stmt =  conexao.prepareStatement("update exames set nome_exame = ?, data_exame = ?, nome_paciente = ?, descricao = ? where id = ? ");
		stmt.setString(1, exameBean.getNomeExame());
		stmt.setString(2, exameBean.getDataExame().toString());
		stmt.setString(3, exameBean.getPaciente().getNomePaciente());
		stmt.setString(4, exameBean.getObservacaoExame());
		stmt.setLong(5, exameBean.getIdExame());
		stmt.executeUpdate();
	}
	
	public void excluir(ExameBean exameBean) throws SQLException, ClassNotFoundException {
		Connection conexao = getConnection();
		PreparedStatement stmt =  conexao.prepareStatement("Delete from exames where id = ? ");
		stmt.setLong(1, exameBean.getIdExame());
		stmt.executeUpdate();
	}


	public ExameBean getExamePeloNomePaciente(String nome) throws ClassNotFoundException, SQLException {
		Connection conexao = getConnection();
		PreparedStatement stmt =  conexao.prepareStatement("select id, nome_exame, nome_paciente from exames where nome_paciente = ?");
		stmt.setString(1, nome);
		ResultSet rs = stmt.executeQuery();
		ExameBean exame = null;
		PacienteBean paciente = null;
		
		if(rs.next()) {
			exame = new ExameBean();
			exame.setIdExame(rs.getLong("id"));
			
			paciente = new PacienteBean();
			paciente.setNomePaciente(rs.getString("nome_paciente"));
			exame.setPaciente(paciente);
			
		}
		
		return exame;
	}


	public void deletar(long id) throws SQLException, ClassNotFoundException {
		Connection conexao = getConnection();
		PreparedStatement stmt =  conexao.prepareStatement("delete from exames where id = ? ");
		stmt.setLong(1, id);
		stmt.executeUpdate();
	}

}
