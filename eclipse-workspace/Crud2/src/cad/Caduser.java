package cad;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import user.User;

public class Caduser {
	private ArrayList<User> users;
	
	public Caduser() {
		// TODO Auto-generated constructor stub
		this.users = new ArrayList<User>();
	}
	public void caduser() {
		for(int i = 0; i<2;i++) {
			String name = JOptionPane.showInputDialog("Insira o nome do usuário");
			String cpf = JOptionPane.showInputDialog("Insira o cpf do usuário");
			String rg = JOptionPane.showInputDialog("Insira o rg do usuário");
			String id = JOptionPane.showInputDialog("Insira o id do usuário");
			String func = JOptionPane.showInputDialog("Insira a função do usuário");
			users.add(new User(name, cpf, rg, id, func));
		}

		}
	public void listusername() {
		System.out.println("---------- Lista de usuários ------ ");
		for(int i = 0; i<users.size(); i++) {
			System.out.println(users.get(i).get_name());
		}
		System.out.println("--------------------------------------");
	}
	public void removeuser() {
		String removeuser = JOptionPane.showInputDialog("Quem desea remover do cadastro?");
		for(int i = 0; i< users.size();i++) {
			if(users.get(i).get_name().equalsIgnoreCase(removeuser)) {
				users.remove(i);
				System.out.println("Após a remoção resta:");
				listusername();
				
		}
			else{
				
				JOptionPane.showMessageDialog(null, "Não foi possível remover o cadastro");
			}
	}
	
	}
}
