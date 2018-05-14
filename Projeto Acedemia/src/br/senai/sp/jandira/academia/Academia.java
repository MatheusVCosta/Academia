package br.senai.sp.jandira.academia;

import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.view.FrmAcademia;

public class Academia {

	public static void main(String[] args) {
		FrmAcademia academia = new FrmAcademia("SmartFat");
		academia.setVisible(true);
		academia.setResizable(false);
		
//		ClienteDAO a = new ClienteDAO();
//		a.getCliente(1);

	}
}