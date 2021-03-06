package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.SystemException;

import br.senai.sp.jandira.cliente.Cliente;
import br.senai.sp.jandira.dao.ClienteDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrmAcademia extends JFrame {

	private JPanel painelPrincipal;
	private JPanel painelTitulo = new JPanel();
	private JTable tabelaDados;
	private JPanel painelDados;
	private FrmCliente cliente;
	
	public FrmAcademia(String titulo) {
		
		setTitle(titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 540);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(37, 183, 211));
		painelPrincipal.setForeground(Color.LIGHT_GRAY);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		painelTitulo.setBackground(new Color(37, 183, 211));
		painelTitulo.setBounds(10, 11, 414, 77);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("SMARTFAT");
		lblTitulo.setBackground(new Color(37, 183, 211));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/titulo.png")));
		lblTitulo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 31));
		lblTitulo.setBounds(0, 0, 414, 77);
		painelTitulo.add(lblTitulo);
		
		painelDados = new JPanel();
		painelDados.setBackground(new Color(220, 220, 220));
		painelDados.setBounds(10, 96, 414, 320);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);
		
		//CRIANDO A TABELA
		criarTabela();
		
		/*JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 11, 394, 298);
		painelDados.add(scrollTabela);
		
		tabelaDados = new JTable();
		tabelaDados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Id", "Cliente"
			}
		));*/
		
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(220, 220, 220));
		painelBotoes.setBounds(10, 424, 414, 69);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovoContato = new JButton("");
		btnNovoContato.setToolTipText("Criar um novo cliente");
		
		btnNovoContato.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/add2.png")));
		btnNovoContato.setBounds(10, 11, 76, 47);
		painelBotoes.add(btnNovoContato);
		
		JButton btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar cliente");
		btnEditar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/edit.png")));
		
		btnEditar.setBounds(96, 11, 76, 47);
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Excluir cliente\r\n");
		btnExcluir.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/icancel.png")));
		btnExcluir.setBounds(182, 11, 70, 47);
		painelBotoes.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		
		btnSair.setToolTipText("Fechar aplica\u00E7\u00E3o");
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/sair.png")));
		btnSair.setBounds(339, 11, 65, 47);
		painelBotoes.add(btnSair);
		
		JButton btnUpdate = new JButton("");
		
		btnUpdate.setToolTipText("Atualizar tabela de clientes\r\n");
		btnUpdate.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/update.png")));
		btnUpdate.setSelectedIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/update.png")));
		btnUpdate.setBounds(262, 11, 65, 47);
		painelBotoes.add(btnUpdate);
		
		btnNovoContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCliente cliente = new FrmCliente("ADICIONAR");
				cliente.setTitle("Adicionar");
				cliente.setVisible(true);
				cliente.setResizable(false);
				
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarCliente("EDITAR");
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarCliente("EXCLUIR");
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtualizarTabela();
			}
		});
	}
	
	public void criarTabela(){
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(8,10,400,305);
		painelDados.add(scrollTabela);
		
		tabelaDados = new JTable();
		
		AtualizarTabela();
		
		scrollTabela.setViewportView(tabelaDados);
		tabelaDados.setColumnSelectionAllowed(false);
		
	}
	public void mostrarCliente(String titulo){
		try{
			FrmCliente frmCliente = new FrmCliente(titulo);
			int linha = tabelaDados.getSelectedRow();
			int id = (int) tabelaDados.getValueAt(linha, 0);
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = new Cliente();
			
			cliente = clienteDAO.getCliente(id);
			
			frmCliente.setTxtId(cliente.getId());
			frmCliente.setTxtNome(cliente.getNome());
			frmCliente.setTxtAltura(cliente.getAltura());
			frmCliente.setTxtPeso(cliente.getPeso());
			frmCliente.setComboAtividade(cliente.getNvAtividade());
			frmCliente.setRdSexo(cliente.getSexo());
			frmCliente.setTxtDtNasc(cliente.getDtNasc());
			
			
			
			frmCliente.setTitle(titulo);
			frmCliente.setVisible(true);
			frmCliente.setResizable(false);
			
		}catch(Exception erro){
			System.out.println(erro);
			JOptionPane.showMessageDialog(null, "Por favor selecione um contato para editar", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void AtualizarTabela(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		ClienteDAO dao = new ClienteDAO();
		clientes = dao.getListaCliente();
		
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			public boolean isCellEditable(int row, int col){//TRAVAR A EDI��O DA TABELA
				return false;
			}
		};
			
		String [] nomeColuna = {"ID", "Cliente"};
		modeloTabela.setColumnIdentifiers(nomeColuna);
		
		Object[] linha = new Object[2];
		for(Cliente cliente: clientes){
			linha [0] = cliente.getId();
			linha [1] = cliente.getNome();
			modeloTabela.addRow(linha);
		}
		
		
		tabelaDados.setModel(modeloTabela);
		
		tabelaDados.getTableHeader().setReorderingAllowed(false);//TRAVAR A MOVIMENT��O DAS COLUNAS
		
		tabelaDados.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabelaDados.getColumnModel().getColumn(0).setResizable(false);
		
		tabelaDados.getColumnModel().getColumn(1).setPreferredWidth(350);
		tabelaDados.getColumnModel().getColumn(1).setResizable(false);
	}
}
