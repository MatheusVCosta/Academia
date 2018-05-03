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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAcademia extends JFrame {

	private JPanel painelPrincipal;
	private final JPanel painelTitulo = new JPanel();
	private JTable tabelaDados;

	public FrmAcademia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 542);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(Color.GRAY);
		painelPrincipal.setForeground(Color.LIGHT_GRAY);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		painelTitulo.setBackground(Color.DARK_GRAY);
		painelTitulo.setBounds(0, 0, 434, 88);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Academia");
		lblTitulo.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/titulo.png")));
		lblTitulo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		lblTitulo.setBounds(82, 11, 260, 66);
		painelTitulo.add(lblTitulo);
		
		JPanel painelDados = new JPanel();
		painelDados.setBounds(10, 96, 414, 320);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(0, 0, 414, 320);
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
		));
		tabelaDados.getColumnModel().getColumn(0).setPreferredWidth(33);
		tabelaDados.getColumnModel().getColumn(1).setPreferredWidth(334);
		scrollTabela.setViewportView(tabelaDados);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(10, 424, 414, 69);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovoContato = new JButton("");
		
		btnNovoContato.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/add2.png")));
		btnNovoContato.setBounds(10, 11, 83, 47);
		painelBotoes.add(btnNovoContato);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/edit.png")));
		
		btnEditar.setBounds(103, 11, 83, 47);
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/icancel.png")));
		btnExcluir.setBounds(207, 11, 83, 47);
		painelBotoes.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/sair.png")));
		btnSair.setBounds(339, 11, 65, 47);
		painelBotoes.add(btnSair);
		
		btnNovoContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCliente cliente = new FrmCliente("Adicionar");
				cliente.setVisible(true);
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCliente cliente = new FrmCliente("Editar");
				cliente.setVisible(true);
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCliente cliente = new FrmCliente("Excluir");
				cliente.setVisible(true);
			}
		});
	}
}
