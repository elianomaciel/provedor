package provedor.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5434/Provedor2","postgres","alunoufc");
			System.out.println("Conectado com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - Conexão"+e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro - Driver"+e.getMessage());
		}
		return con;
		
				}

}
