package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class FrmCliente extends JFrame {


	private JPanel painelPrincipal;
	private final JPanel painelTitulo = new JPanel();
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtTmb;
	private JTextField textField;

	
	public FrmCliente(String titulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 612);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(Color.GRAY);
		painelPrincipal.setForeground(Color.LIGHT_GRAY);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		painelTitulo.setBackground(Color.DARK_GRAY);
		painelTitulo.setBounds(0, 0, 418, 88);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblOperacao = new JLabel(titulo);
		lblOperacao.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/titulo.png")));
		lblOperacao.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		lblOperacao.setBounds(82, 11, 260, 66);
		painelTitulo.add(lblOperacao);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(10, 491, 398, 69);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovoContato = new JButton("");
		btnNovoContato.setToolTipText("Salvar as informa\u00E7\u00F5es do cliente");
		btnNovoContato.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/save.png")));
		btnNovoContato.setBounds(10, 11, 83, 47);
		painelBotoes.add(btnNovoContato);
		
		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/sair.png")));
		btnSair.setBounds(322, 11, 65, 47);
		painelBotoes.add(btnSair);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 99, 398, 210);
		painelPrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 21, 46, 14);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(30, 18, 73, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(115, 21, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(150, 18, 241, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 63, 109, 14);
		panel.add(lblDataDeNascimento);
		
		JFormattedTextField txtDtNasc = new JFormattedTextField();
		txtDtNasc.setBounds(129, 60, 73, 20);
		panel.add(txtDtNasc);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(212, 63, 39, 14);
		panel.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(241, 60, 92, 20);
		panel.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 94, 39, 14);
		panel.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(48, 91, 86, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(142, 94, 21, 14);
		panel.add(lblCm);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setBounds(343, 63, 46, 14);
		panel.add(lblKg);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(173, 94, 39, 14);
		panel.add(lblSexo);
		
		JRadioButton rdFeminino = new JRadioButton("Feminino");
		rdFeminino.setBounds(222, 90, 86, 23);
		panel.add(rdFeminino);
		
		JRadioButton rdMasculino = new JRadioButton("Masculino");
		rdMasculino.setBounds(305, 90, 86, 23);
		panel.add(rdMasculino);
		
		JLabel lblNvelDeAtividade = new JLabel("N\u00EDvel de Atividade:");
		lblNvelDeAtividade.setBounds(10, 130, 106, 14);
		panel.add(lblNvelDeAtividade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sedent\u00E1rio", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo", "Muito Ativo"}));
		comboBox.setBounds(113, 127, 275, 20);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Calcular IMC, TMB e FCM");
		btnNewButton.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/if_calc_42174.png")));
		btnNewButton.setBounds(161, 158, 78, 41);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 320, 398, 160);
		painelPrincipal.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setBounds(10, 11, 46, 14);
		panel_1.add(lblImc);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 27, 378, 81);
		panel_1.add(textArea);
		
		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setBounds(10, 123, 33, 14);
		panel_1.add(lblTmb);
		
		txtTmb = new JTextField();
		txtTmb.setBounds(41, 120, 86, 20);
		panel_1.add(txtTmb);
		txtTmb.setColumns(10);
		
		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setBounds(267, 123, 33, 14);
		panel_1.add(lblFcm);
		
		textField = new JTextField();
		textField.setBounds(302, 119, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
	}
}
