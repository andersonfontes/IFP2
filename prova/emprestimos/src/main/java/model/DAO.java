package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DAO {
	/** modulo de conexao **/
	// PARAMETROS DE CONEXAO

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbemprestimo?useTimezone=true&ServerTimezone=UTC";
	private String user = "root";
	private String password = "123456";

	// METODO DE CONEXAO
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/** CRUD CREATE (CLASSE DAO) **/
	public void inserirEmprestimo(JavaBeans registro) {
		String create = "insert into emprestimo( codigo , data , observacao , usuario, tipoUsuario ) values(?,?,?,?,?)";
		try {
			Connection con = conectar();

			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir parametros (?) pelo contaeudo das variaveis JavaBEans
			pst.setString(1, registro.getCodigo()); 
			pst.setString(2, registro.getData());
			pst.setString(3, registro.getObservacao());
			pst.setString(3, registro.getUsuario());
			pst.setString(3, registro.getTipoUsuario());

			// executar a query
			pst.executeUpdate();

			// Encerrar a conexao com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ (CLASSE DAO) **/
	
	public ArrayList<JavaBeans> listarEmprestimos() {

		// Criando objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> emprestimos = new ArrayList<>();

		String read = "select * from emprestimo order by data";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			
			// o laço abaixo sera executado enquanto houver emprestimos
			while (rs.next()) { 
				// variaveis de apoio que recebem os dados do banco
				String codigo = rs.getString(1);
				String data = rs.getString(2);
				String observacao = rs.getString(3);
				String usuario = rs.getString(4);
				String tipoUsuario = rs.getString(5);
				// populando o ArrayList
				emprestimos.add(new JavaBeans(codigo, data, observacao, usuario, tipoUsuario));
			}
			con.close();
			return emprestimos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD SELECT (CLASSE DAO) **/
	public void selecionarEmprestimo(JavaBeans registro) {
		Connection con = conectar();
		String read2 = "select * from emprestimos where codigo=?";
		try {
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, registro.getCodigo());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				registro.setCodigo(rs.getString(1));
				registro.setData(rs.getString(2));
				registro.setObservacao(rs.getString(3));
				registro.setUsuario(rs.getString(4));
				registro.setTipoUsuario(rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD UPDATE (CLASSE DAO) **/
	public void alterarEmprestimo(JavaBeans registro) {
		String create = "update emprestimo  set data=?, observacao=?,usuario=?, tipoUsuario, where codigo=?;";

		try {
			Connection con = conectar();

			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir parametros (?) pelo contaeudo das variaveis JavaBeans

			pst.setString(1, registro.getData());
			pst.setString(2, registro.getObservacao());
			pst.setString(3, registro.getUsuario());
			pst.setString(4, registro.getTipoUsuario());
			pst.setString(5, registro.getCodigo());

			// executar a query
			pst.executeUpdate();
//
//			// Encerrar a conexao com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD DELETE (CLASSE DAO) **/
	public void apagarEmprestimo(JavaBeans registro) {
		String delete = "delete from emprestimos where codigo=?;";

		try {
			Connection con = conectar();

			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(delete);

			// Substituir parametros (?) pelo contaeudo das variaveis JavaBeans
			pst.setString(1, registro.getCodigo());

			// executar a query
			pst.executeUpdate();

			// Encerrar a conexao com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	
	
	// teste conexao
	public void testeConexao()
	{
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}




}
