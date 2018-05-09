package br.senai.sp.jandira.dao;

import java.security.GeneralSecurityException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		String consulta = "SELECT * FROM cliente WHERE id = ?";
		resultado = null;
		stm = null;
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, id);
			resultado = stm.executeQuery();
			
			resultado.next();
			
			cliente.setId(resultado.getInt("id"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setAltura(resultado.getString("altura"));
			cliente.setPeso(resultado.getString("peso"));
			cliente.setSexo(resultado.getString("sexo"));
			cliente.setNvAtividade(resultado.getString("nvAtividade"));
			cliente.setDtNasc((df.format(resultado.getDate("dtNasc"))));
			
			Conexao.fecharConexao();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na consulta", "ERRO", JOptionPane.ERROR_MESSAGE);
			System.out.println(erro.getMessage());
		}
		
		return cliente;
		
	}

	public void GravarContato(){
		
		String consulta = "INSERT INTO cliente (nome, altura, peso, dtNasc, sexo, nvAtividade) VALUES (?, ?, ?, ?, ? ,?)";
		stm = null;
		
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getAltura());
			stm.setString(3, cliente.getPeso());
			stm.setString(4, cliente.getDtNasc());
			stm.setString(5, cliente.getSexo());
			stm.setString(6, cliente.getNvAtividade());
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Contato gravado com sucesso");
			
			Conexao.fecharConexao();
			
		}catch(Exception erro){
			System.out.println(erro.getMessage());
		}
		
	}
}
