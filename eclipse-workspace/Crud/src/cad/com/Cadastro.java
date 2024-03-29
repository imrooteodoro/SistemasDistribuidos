package cad.com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import staticd.com.StatusUsuario;
import user.com.User;

public class Cadastro {
	ArrayList<User> users = new ArrayList<User>();
	HashMap<String, List<User>> n = new HashMap<String, List<User>>();
	
	//Instanciando o construtor
	public Cadastro() {
		n.put(StatusUsuario.positivo, new ArrayList<User>());
		n.put(StatusUsuario.negativado, new ArrayList<User>());
		n.put(StatusUsuario.credanalisy, new ArrayList<User>());
	}
	public void caduser(User user) {
		for(int i = 0; i<2; i++) {
		String nome = JOptionPane.showInputDialog("Insira seu nome");
		String cpf = JOptionPane.showInputDialog("Insira seu cpf");
		String rg = JOptionPane.showInputDialog("Insira seu rg");
		String ncad =JOptionPane.showInputDialog("Insira o ncad");
		String salario = JOptionPane.showInputDialog("Insira seu salario");
		user = new User(nome, cpf, rg, ncad, Double.parseDouble(salario));
		users.add(user);
		}
	   }	
	   public static void alerta() {
		   JOptionPane.showMessageDialog(null,"Não foi possível remover");
	   }
		public void exibircadnome() {
			System.out.println("------------------------------");
			for(int i = 0; i<users.size();i++) {
				JOptionPane.showMessageDialog(null, users.get(i).getNome());			}
			System.out.println("-------------------------------");
		}
		public void removercadastropornome() {
			String remover = JOptionPane.showInputDialog("Quem deseja remover?");
			for (int i =0; i<users.size();i++) {
				if(users.get(i).getNome().equalsIgnoreCase(remover)) {
					users.remove(i);
					System.out.printf("%s %s %s", "-----Cadastro atualizado após remoção de ", remover, "---\n");
					exibircadnome();
					break;
				}
			}
			
		}
	} 
