package pos_java_jdbc.pos_java_jdbc;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import conexaodb.SingleConnection;
import dao.UserPosDao;
import model.Usertoeodoro;



public class TesteDB{
	@Test
	public void initDB() throws SQLException {
		SingleConnection.getConnection();
		UserPosDao n = new UserPosDao();
		Usertoeodoro userteodoro = new Usertoeodoro();
		userteodoro.setId_user(3l);
		userteodoro.setNome("Bartolomeu da Pop 100");
		userteodoro.setEmail("chatgpthacker@gmail.com");
		n.salvar(userteodoro);
	
	}
	@Test
	public void InitListar() {
		UserPosDao user = new UserPosDao();
		try {
			List<Usertoeodoro> list = user.listar();
			for (Usertoeodoro usertoeodoro : list) {
				System.out.println(usertoeodoro.getNome());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void initBuscar() {
		UserPosDao user = new UserPosDao();
		try {
			Usertoeodoro userteo = user.buscar(1l);
			System.out.println(userteo.getNome());
		} catch ( Exception e) {
		  e.printStackTrace();
		}
		
	}

}
