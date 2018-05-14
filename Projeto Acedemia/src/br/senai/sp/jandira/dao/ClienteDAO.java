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
	
	public ArrayList<Cliente> getListaCliente(){//Criação do método getListaCliente
		
		ArrayList<Cliente> clientes = new ArrayList<>();//criando o objeto cliente
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
		
		//**** DEFININDO O FORMATO DA DATA PARA O FORMATO BRASILEIRO
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
		
		String sql = "INSERT INTO cliente (nome, altura, peso, dtNasc, sexo, nvAtividade) VALUES (?, ?, ?, ?, ? ,?)";
		stm = null;
		
		try{
			stm = Conexao.getConexao().prepareStatement(sql);
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
			JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!");
			System.out.println(erro.getMessage());
		}
		
	}
	
	public void atualizar(String id){
		String sql = ("UPDATE cliente set nome = ?, altura = ?, peso = ?, dtNasc = ?, sexo = ?, nvAtividade = ? WHERE id = ?");
		int Id = Integer.parseInt(id);
		try{
			stm = Conexao.getConexao().prepareStatement(sql);
			
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getAltura());
			stm.setString(3, cliente.getPeso());
			stm.setString(4, cliente.getDtNasc());
			stm.setString(5, cliente.getSexo());
			stm.setString(6, cliente.getNvAtividade());
			stm.setInt(7, Id);
			
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Cliente editado com sucesso", "Cliente Editado", JOptionPane.INFORMATION_MESSAGE );
			Conexao.fecharConexao();
		}
		catch(Exception erro){
			System.out.println(erro.getMessage());
		}
	}
	
	public void excluir (String id){
		String sql = "DELETE FROM cliente WHERE id = ?";
		int Id = Integer.parseInt(id);
		try{
			
			stm = Conexao.getConexao().prepareStatement(sql);
			
			stm.setInt(1, Id);
			
			int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esse cliente?", "Aviso", JOptionPane.YES_NO_OPTION);
			
			if(result == 0){
				JOptionPane.showMessageDialog(null, "O contato foi excluído com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				stm.execute();
			}else{
				JOptionPane.showMessageDialog(null, "O contato não excluído", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
			
			Conexao.fecharConexao();
		}
		catch(Exception erro){
			System.out.println(erro.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
