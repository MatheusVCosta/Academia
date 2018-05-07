package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.cliente.Cliente;
import br.senai.sp.jandira.jdbc.Conexao;

public class ClienteDAO {
	private Cliente cliente;
	private ResultSet resultado;
	private PreparedStatement stm;
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public ResultSet getClintes(){
		String conculta ="SELECT * FROM cliente";
		resultado = null;
		stm = null;
		try{
			
		}catch (Exception erro){
			try {
				stm = Conexao.getConexao().prepareStatement(conculta);
				resultado = stm.executeQuery();
				
				Conexao.fecharConexao();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na consulta", "ERRO", JOptionPane.ERROR_MESSAGE);
				System.out.println(e.getMessage());
			}
		}
		return resultado;
	}
	public ArrayList<Cliente> getListaCliente(){
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		String consulta = "SELECT * FROM cliente";
		resultado = null;
		stm = null;
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery();
			
			while(resultado.next()){
				Cliente cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setAltura(resultado.getString("altura"));
				cliente.setPeso(resultado.getString("peso"));
				cliente.setSexo(resultado.getString("sexo"));
				cliente.setDtNasc(resultado.getString("dtNasc"));
				cliente.setNvAtividade(resultado.getString("nvAtividade"));
				
				clientes.add(cliente);//ADICIONANDO A COLEÇÃO CLIENTE NA ARRAYLIST Clientes
 			}
			Conexao.fecharConexao();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na consulta", "ERRO", JOptionPane.ERROR_MESSAGE);
			System.out.println(erro.getMessage());
		}
		return clientes;
		
	}
	public Cliente getCliente(int id){
		Cliente cliente = new Cliente();
		
		
		String consulta = "SELECT * FROM cliente";
		resultado = null;
		stm = null;
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery();
			
			resultado.next();
			
			cliente.setId(resultado.getInt("id"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setAltura(resultado.getString("altura"));
			cliente.setPeso(resultado.getString("peso"));
			cliente.setSexo(resultado.getString("sexo"));
			cliente.setNvAtividade(resultado.getString("nvAtividade"));
			System.out.println(cliente.getNvAtividade());
			
			Conexao.fecharConexao();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na consulta", "ERRO", JOptionPane.ERROR_MESSAGE);
			System.out.println(erro.getMessage());
		}
		
		return cliente;
		
	}

	
}
