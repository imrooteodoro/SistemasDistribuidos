package user.com;

public class User  extends Pessoa{
	private String ncad;
	private double salario;
	
	 
	public User(String nome,String cpf, String rg, String ncad, double salario) {
		super();
		this.ncad = ncad;
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public String getNcad() {
		return ncad;
	}
	public void setNcad(String ncad) {
		this.ncad = ncad;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	

}
