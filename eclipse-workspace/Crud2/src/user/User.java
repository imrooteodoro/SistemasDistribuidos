package user;

import people.People;

public class User extends People{
	private String id_user;
	private String func_user;
	
	
	public User(String name, String rg, String cpf, String id_user, String func_user) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.rg = rg;
		this.id_user = id_user;
		this.func_user = func_user;
	}
	
	public String get_name() {
		return name;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getFunc_user() {
		return func_user;
	}

	public void setFunc_user(String func_user) {
		this.func_user = func_user;
	}
	

}
