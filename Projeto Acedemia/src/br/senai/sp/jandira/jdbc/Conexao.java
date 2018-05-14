package br.senai.sp.jandira.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	private static Connection con;
	public static Connection getConexao(){
		con = null;
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//CAMINHO DO DRIVER DO UcanAccess
			
			//String dbURL = "jdbc:ucanaccess://C:/Users/17259221/Desktop/academia.accdb";//Arquivo SENAI
			String dbURL = "jdbc:ucanaccess://C:/Users/User/Desktop/academia.accdb";//Arquivo CASA
			con = DriverManager.getConnection(dbURL);
			
			
			
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
			System.out.println(erro);
		}
		return con;
	}
	public static void fecharConexao(){
		if(con != null){//se o con for diferente de null ele fecha o banco
			try{//tenta fechar o banco
				con.close();
			}catch(SQLException erro){
				JOptionPane.showMessageDialog(null, "O banco já está fechado!", "ERRO", JOptionPane.ERROR_MESSAGE);
				System.out.println(erro.getMessage());
			}
		}
	}
}
