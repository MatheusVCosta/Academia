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
import javax.swing.JOptionPane;
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
	private JFormattedTextField txtDtNasc;
	private JComboBox comboAtividade;
	private JRadioButton rdMasculino;
	private JRadioButton rdFeminino;
	private String sexo;
	private JTextField txtIdade;
	
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
			sexo = "F";
		}else if(rdMasculino.isSelected()){
			sexo = "M";
		}
		return sexo;
	}

	public FrmCliente(String titulo) {
		Cliente cliente = new Cliente();
		setBounds(100, 100, 423, 600);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(37,183,211));
		painelPrincipal.setForeground(Color.LIGHT_GRAY);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		painelTitulo.setBackground(new Color(37, 183, 211));
		painelTitulo.setBounds(10, 11, 398, 78);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblOperacao = new JLabel(titulo);
		lblOperacao.setBackground(new Color(37,183,211));
		lblOperacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacao.setForeground(new Color(248, 248, 255));
		lblOperacao.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/titulo.png")));
		lblOperacao.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		lblOperacao.setBounds(0, 0, 398, 78);
		painelTitulo.add(lblOperacao);

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(220, 220, 220));
		painelBotoes.setBounds(10, 481, 398, 69);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);

		JButton btnSalvarContato = new JButton("");
		
		btnSalvarContato.setBackground(new Color(211, 211, 211));
		btnSalvarContato.setToolTipText("Salvar as informa\u00E7\u00F5es do cliente");
		btnSalvarContato.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/save.png")));
		btnSalvarContato.setBounds(10, 11, 83, 47);
		painelBotoes.add(btnSalvarContato);

		JButton btnSair = new JButton("");
	
		btnSair.setHorizontalAlignment(SwingConstants.RIGHT);
		btnSair.setBackground(new Color(211, 211, 211));
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(FrmAcademia.class.getResource("/br/senai/sp/jandira/imagens/sair.png")));
		btnSair.setBounds(322, 11, 65, 47);
		painelBotoes.add(btnSair);

		JPanel painelDados = new JPanel();
		painelDados.setBackground(new Color(220, 220, 220));
		painelDados.setBounds(10, 99, 398, 195);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);

		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblId.setBounds(10, 20, 46, 14);
		painelDados.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(32, 20, 68, 16);
		painelDados.add(txtId);
		txtId.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNome.setBounds(110, 20, 39, 14);
		painelDados.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(154, 18, 234, 20);
		painelDados.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDataDeNascimento.setBounds(10, 52, 122, 14);
		painelDados.add(lblDataDeNascimento);

		MaskFormatter formatoData = null;
		try{
			formatoData = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		txtDtNasc = new JFormattedTextField(formatoData);
		txtDtNasc.setText("");
		txtDtNasc.setBounds(131, 49, 83, 20);
		painelDados.add(txtDtNasc);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblPeso.setBounds(224, 51, 35, 14);
		painelDados.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(259, 49, 80, 20);
		painelDados.add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblAltura.setBounds(10, 80, 39, 14);
		painelDados.add(lblAltura);

		txtAltura = new JTextField();
		txtAltura.setBounds(54, 77, 78, 20);
		painelDados.add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCm.setBounds(134, 80, 21, 14);
		painelDados.add(lblCm);

		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Arial", Font.PLAIN, 11));
		lblKg.setBounds(342, 53, 21, 14);
		painelDados.add(lblKg);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(175, 81, 39, 14);
		painelDados.add(lblSexo);

		rdFeminino = new JRadioButton("Feminino");
		rdFeminino.setFont(new Font("Verdana", Font.PLAIN, 11));
		rdFeminino.setBackground(new Color(220, 220, 220));
		rdFeminino.setBounds(214, 77, 80, 23);
		rdFeminino.setSelected(true);
		painelDados.add(rdFeminino);

		rdMasculino = new JRadioButton("Masculino");
		rdMasculino.setFont(new Font("Verdana", Font.PLAIN, 11));
		rdMasculino.setBackground(new Color(220, 220, 220));
		rdMasculino.setBounds(296, 77, 86, 23);
		painelDados.add(rdMasculino);
		
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rdFeminino);
		grupoSexo.add(rdMasculino);
			
		JLabel lblNvelDeAtividade = new JLabel("N\u00EDvel de Atividade:");
		lblNvelDeAtividade.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNvelDeAtividade.setBounds(10, 114, 122, 14);
		painelDados.add(lblNvelDeAtividade);

		comboAtividade = new JComboBox();
		comboAtividade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboAtividade.setModel(new DefaultComboBoxModel(new String[] { "Sedentário", "Levemente Ativo",
				"Moderadamente Ativo", "Bastante Ativo", "Muito Ativo" }));
		comboAtividade.setBounds(131, 111, 260, 20);
		painelDados.add(comboAtividade);

		JButton btnCalcular = new JButton("");
		
		btnCalcular.setBackground(new Color(211, 211, 211));
		btnCalcular.setToolTipText("Calcular IMC, TMB e FCM");
		btnCalcular
				.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/jandira/imagens/if_calc_42174.png")));
		btnCalcular.setBounds(141, 142, 98, 41);
		painelDados.add(btnCalcular);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblIdade.setBounds(10, 139, 46, 14);
		painelDados.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setEditable(false);
		txtIdade.setBounds(54, 137, 55, 20);
		painelDados.add(txtIdade);
		txtIdade.setColumns(10);

		JPanel painelResult = new JPanel();
		painelResult.setBackground(new Color(220, 220, 220));
		painelResult.setBounds(10, 305, 398, 166);
		painelPrincipal.add(painelResult);
		painelResult.setLayout(null);

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setFont(new Font("Verdana", Font.BOLD, 11));
		lblImc.setBounds(10, 11, 46, 14);
		painelResult.add(lblImc);

		JTextArea txtAreaIMC = new JTextArea();
		txtAreaIMC.setBackground(Color.WHITE);
		txtAreaIMC.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtAreaIMC.setForeground(new Color(255, 0, 0));
		txtAreaIMC.setEditable(false);
		txtAreaIMC.setBounds(10, 36, 378, 63);
		painelResult.add(txtAreaIMC);

		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTmb.setBounds(10, 102, 33, 14);
		painelResult.add(lblTmb);

		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setFont(new Font("Verdana", Font.BOLD, 11));
		lblFcm.setBounds(10, 123, 33, 14);
		painelResult.add(lblFcm);
		
		JLabel lblMostrarIMC = new JLabel("...");
		lblMostrarIMC.setForeground(new Color(255, 0, 0));
		lblMostrarIMC.setBounds(42, 11, 96, 14);
		painelResult.add(lblMostrarIMC);
		
		JLabel lblMostrarTmb = new JLabel("...");
		lblMostrarTmb.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblMostrarTmb.setForeground(new Color(255, 0, 0));
		lblMostrarTmb.setBounds(42, 102, 75, 14);
		painelResult.add(lblMostrarTmb);
		
		JLabel lblMostrarFcm = new JLabel("...");
		lblMostrarFcm.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblMostrarFcm.setForeground(new Color(255, 0, 0));
		lblMostrarFcm.setBounds(42, 123, 91, 14);
		painelResult.add(lblMostrarFcm);
	
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
					
					cliente.setDtNasc(dataAccess);
					clienteDAO.setCliente(cliente);
					cliente.setNome(txtNome.getText());
					cliente.setAltura(txtAltura.getText());
					cliente.setPeso(txtPeso.getText());
					cliente.setSexo(getRdSexo());
					cliente.setNvAtividade(comboAtividade.getSelectedItem().toString());
				
					
					if(lblOperacao.getText().equals("ADICIONAR")){
						clienteDAO.GravarContato();
						limparTabela();
					}else if(lblOperacao.getText().equals("EDITAR")){
						clienteDAO.atualizar(txtId.getText());
						FrmCliente.this.dispose();
					}else if(lblOperacao.getText().equals("EXCLUIR")){
						clienteDAO.excluir(txtId.getText());
						FrmCliente.this.dispose();
					}
					
					
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!");
				}
				
				
			}
		});
		
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCliente.this.dispose();
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				double idade = calcularIdade();
				
				txtIdade.setText(String.valueOf(idade).substring(0,2));
				cliente.setSexo(getRdSexo());
				cliente.setNvAtividade(comboAtividade.getSelectedItem().toString());
				//IMC
				lblMostrarIMC.setText(String.valueOf(cliente.IMC(Double.parseDouble(txtPeso.getText()), Double.parseDouble(txtAltura.getText())/100)).substring(0, 5).replace(".", ","));
				txtAreaIMC.setText(cliente.MostrarImc());
				
				//TMB
				lblMostrarTmb.setText(String.valueOf(cliente.TMB(Double.parseDouble(txtPeso.getText()), Double.parseDouble(txtAltura.getText()), idade)).substring(0, 4));
				
				//FCM
				lblMostrarFcm.setText(String.valueOf(cliente.FMC(idade, Double.parseDouble(txtPeso.getText()))).substring(0,3));
			
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!");
					
				}
			}
		});
	}
	
	
	public int calcularIdade(){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		int idade = 0;
		
		int anoAtual = Integer.parseInt((df.format(data).substring(6,10)));
		int mesAtual = Integer.parseInt((df.format(data).substring(3,5)));
		int diaAtual = Integer.parseInt((df.format(data).substring(0,2)));
		
		int txtAno = Integer.parseInt (txtDtNasc.getText().substring(6,10));
		int txtMes = Integer.parseInt (txtDtNasc.getText().substring(3,5));
		int txtDia = Integer.parseInt (txtDtNasc.getText().substring(0,2));
		
		if(mesAtual < txtMes){
			idade = anoAtual - txtAno - 1;
		}
		else if(mesAtual == txtMes){
			if(diaAtual < txtDia){
				idade = anoAtual - txtAno - 1;
			}
		}else{
			idade = anoAtual - txtAno;
		}
			
		return idade;
		
	}
	public void limparTabela(){
		txtAltura.setText("");
		txtNome.setText("");
		txtPeso.setText("");
		txtDtNasc.setText("");
		comboAtividade.setSelectedIndex(0);
		
		txtNome.grabFocus();
		
	}
}
