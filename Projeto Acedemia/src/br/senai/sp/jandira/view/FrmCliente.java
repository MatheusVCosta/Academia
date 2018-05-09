package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.xml.crypto.Data;

import br.senai.sp.jandira.cliente.Cliente;
import br.senai.sp.jandira.dao.ClienteDAO;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class FrmCliente extends JFrame {
	private JPanel painelPrincipal;
	private JPanel painelTitulo = new JPanel();
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtTmb;
	private JTextField txtFMC;
	private JFormattedTextField txtDtNasc;
	private JComboBox comboAtividade;
	private JRadioButton rdMasculino;
	private JRadioButton rdFeminino;
	
	public void setTxtDtNasc(String data){
		this.txtDtNasc.setText(data);
	}
	
	public void setPainelPrincipal(JPanel painelPrincipal) {
		this.painelPrincipal = painelPrincipal;
	}

	public void setTxtId(int id) {
		this.txtId.setText(String.valueOf(id));;
	}

	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}

	public void setTxtPeso(String peso) {
		this.txtPeso.setText(peso);
	}

	public void setTxtAltura(String altura) {
		this.txtAltura.setText(altura);
	}
	public void setComboAtividade(String nivel){
		this.comboAtividade.setToolTipText(nivel);
		
		if(nivel.equals("Sedentário")){
			comboAtividade.setSelectedIndex(0);
			
		}else if(nivel.equals("Levemente Ativo")){
			comboAtividade.setSelectedIndex(1);
			
		}else if(nivel.equals("Moderamente Ativo")){
			comboAtividade.setSelectedIndex(2);
			
		}else if(nivel.equals("Bastante Ativo")){
			comboAtividade.setSelectedIndex(3);
			
		}else{
			comboAtividade.setSelectedIndex(4);
		}
	}
	
	public void setRdSexo(String sexo){
		if(sexo.equals("F")){
			rdFeminino.setSelected(true);
		}else if(sexo.equals("M")){
			rdMasculino.setSelected(true);
		}
	}
	public String getRdSexo(){
		String sexo = "";
		if(rdFeminino.isSelected()){
			sexo="F";
		}else if(rdMasculino.isSelected()){
			sexo = "M";
		}
		return sexo;
	}

	public FrmCliente(String titulo) {
		
		setBounds(100, 100, 423, 600);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(0, 191, 255));
		painelPrincipal.setForeground(Color.LIGHT_GRAY);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		painelTitulo.setBackground(new Color(0, 191, 255));
		painelTitulo.setBounds(10, 11, 398, 78);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblOperacao = new JLabel(titulo);
		lblOperacao.setBackground(new Color(0, 191, 255));
		lblOperacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacao.setForeground(new Color(248, 248, 255));
		lblOperacao.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/titulo.png")));
		lblOperacao.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		lblOperacao.setBounds(0, 0, 398, 78);
		painelTitulo.add(lblOperacao);

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(220, 220, 220));
		painelBotoes.setBounds(10, 491, 398, 69);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);

		JButton btnSalvarContato = new JButton("");
		
		btnSalvarContato.setBackground(new Color(211, 211, 211));
		btnSalvarContato.setToolTipText("Salvar as informa\u00E7\u00F5es do cliente");
		btnSalvarContato.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/save.png")));
		btnSalvarContato.setBounds(10, 11, 83, 47);
		painelBotoes.add(btnSalvarContato);

		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(211, 211, 211));
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/sair.png")));
		btnSair.setBounds(322, 11, 65, 47);
		painelBotoes.add(btnSair);

		JPanel painelDados = new JPanel();
		painelDados.setBackground(new Color(220, 220, 220));
		painelDados.setBounds(10, 99, 398, 210);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 21, 46, 14);
		painelDados.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(30, 18, 73, 20);
		painelDados.add(txtId);
		txtId.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(115, 21, 39, 14);
		painelDados.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(164, 18, 227, 20);
		painelDados.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 52, 122, 14);
		painelDados.add(lblDataDeNascimento);

		MaskFormatter formatoData = null;
		try{
			formatoData = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JFormattedTextField txtDtNasc = new JFormattedTextField(formatoData);
		txtDtNasc.setText("");
		txtDtNasc.setBounds(129, 49, 65, 20);
		painelDados.add(txtDtNasc);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(204, 52, 35, 14);
		painelDados.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(240, 49, 92, 20);
		painelDados.add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 80, 39, 14);
		painelDados.add(lblAltura);

		txtAltura = new JTextField();
		txtAltura.setBounds(54, 77, 78, 20);
		painelDados.add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(142, 80, 21, 14);
		painelDados.add(lblCm);

		JLabel lblKg = new JLabel("kg");
		lblKg.setBounds(342, 52, 21, 14);
		painelDados.add(lblKg);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(169, 80, 39, 14);
		painelDados.add(lblSexo);

		rdFeminino = new JRadioButton("Feminino");
		rdFeminino.setBackground(new Color(220, 220, 220));
		rdFeminino.setBounds(214, 76, 86, 23);
		painelDados.add(rdFeminino);

		rdMasculino = new JRadioButton("Masculino");
		rdMasculino.setBackground(new Color(220, 220, 220));
		rdMasculino.setBounds(305, 76, 86, 23);
		painelDados.add(rdMasculino);
		
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rdFeminino);
		grupoSexo.add(rdMasculino);
			
		JLabel lblNvelDeAtividade = new JLabel("N\u00EDvel de Atividade:");
		lblNvelDeAtividade.setBounds(10, 130, 104, 14);
		painelDados.add(lblNvelDeAtividade);

		comboAtividade = new JComboBox();
		comboAtividade.setModel(new DefaultComboBoxModel(new String[] { "Sedentário", "Levemente Ativo",
				"Moderadamente Ativo", "Bastante Ativo", "Muito Ativo" }));
		comboAtividade.setBounds(115, 127, 273, 20);
		painelDados.add(comboAtividade);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setToolTipText("Calcular IMC, TMB e FCM");
		btnNewButton
				.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/if_calc_42174.png")));
		btnNewButton.setBounds(161, 158, 78, 41);
		painelDados.add(btnNewButton);

		JPanel painelResult = new JPanel();
		painelResult.setBackground(new Color(220, 220, 220));
		painelResult.setBounds(10, 320, 398, 160);
		painelPrincipal.add(painelResult);
		painelResult.setLayout(null);

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setBounds(10, 11, 46, 14);
		painelResult.add(lblImc);

		JTextArea txtAreaIMC = new JTextArea();
		txtAreaIMC.setBounds(10, 27, 378, 81);
		painelResult.add(txtAreaIMC);

		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setBounds(10, 123, 33, 14);
		painelResult.add(lblTmb);

		txtTmb = new JTextField();
		txtTmb.setBounds(41, 120, 86, 20);
		painelResult.add(txtTmb);
		txtTmb.setColumns(10);

		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setBounds(267, 123, 33, 14);
		painelResult.add(lblFcm);

		txtFMC = new JTextField();
		txtFMC.setBounds(302, 119, 86, 20);
		painelResult.add(txtFMC);
		txtFMC.setColumns(10);
	
		btnSalvarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();
				
				SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat toDataBase = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.000000");
				
				Date data = null;
				String dataAccess = "";
				
				try{
					data = toDate.parse(txtDtNasc.getText());
					dataAccess = toDataBase.format(data);
					ClienteDAO clienteDAO = new ClienteDAO();
					
					clienteDAO.setCliente(cliente);
					cliente.setNome(txtNome.getText());
					cliente.setAltura(txtAltura.getText());
					cliente.setPeso(txtPeso.getText());
					cliente.setDtNasc(dataAccess);
					cliente.setSexo(getRdSexo());
					cliente.setNvAtividade(comboAtividade.getSelectedItem().toString());
					
					if(lblOperacao.getText().equals("ADICIONAR")){
						clienteDAO.GravarContato();
					}else if(lblOperacao.getText().equals("EDITAR")){
						
					}else if(lblOperacao.getText().equals("EXCLUIR")){
						
					}
					
				}catch(Exception erro){
					erro.printStackTrace();
				}
				
				
			}
		});
	}
}
