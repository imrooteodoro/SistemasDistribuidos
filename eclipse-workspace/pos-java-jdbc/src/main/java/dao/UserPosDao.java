package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaodb.SingleConnection;
import model.Usertoeodoro;

public class UserPosDao {
	private Connection connection;
	
	public UserPosDao() {
		connection = SingleConnection.getConnection();
		
	}
	public void criatabela(Usertoeodoro teouser) {
		try {
			String sql = ("create table jogador(id_user bigint not null,\n"
					+ "nome char varying (255),\n"
					+ "email char varying (255),\n"
					+ "constraint user_pk primary key(id));");
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.execute(sql);
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void salvar(Usertoeodoro teouser){
		
		try {
			String sql = ("insert into aluno(id_user, nome, email) values(?, ?, ?)");
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, teouser.getId_user());
			insert.setString(2,teouser.getNome());
			insert.setString(3, teouser.getEmail());
			insert.execute();
			connection.commit();
			} catch (Exception e) {
				try {
					connection.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
					
				}
			e.printStackTrace();
		}
		
	}
	public List<Usertoeodoro> listar() throws Exception{
		String sql = "select *from aluno ";
		List<Usertoeodoro> list  = new ArrayList<Usertoeodoro>();
		
			PreparedStatement statment= connection.prepareStatement(sql); 
			ResultSet resultado = statment.executeQuery();
			while(rtype filter text2esultado.next()) {
				Usertoeodoro teouser = new Usertoeodoro();
				teouser.setId_user(resultado.getLong("id_user"));
				teouser.setNome(resultado.getString("nome"));
				teouser.setEmail(resultado.getString("email"));
				list.add(teouser);
			}
			return list;
		
	}
	public Usertoeodoro buscar(Long id) throws Exception{
		String sql = "select * from aluno where id_user =" + id ;
		 Usertoeodoro retorno  = new Usertoeodoro();
		
			PreparedStatement statment= connection.prepareStatement(sql); 
			ResultSet resultado = statment.executeQuery();
			while(resultado.next()) {
				Usertoeodoro teouser = new Usertoeodoro();
				retorno.setId_user(resultado.getLong("id_user"));
				retorno.setNome(resultado.getString("nome"));
				retorno.setEmail(resultado.getString("email"));
				
			}
			return retorno;
		
	}
	

}
