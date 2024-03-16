package admin;

import people.People;

public class Admin extends People{
	private String password;
	private String login;
	
	public Admin(String name, String cpf, String rg, String password, String login) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.name = name;
		this.password = password;
		this.login = login;
	}
	
	

}
