package provedor.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import provedor.trabalho.Cliente;
import provedor.trabalho.Financeiro;
import provedor.trabalho.Pacote;
import provedor.jdbc.Conexao;



public class FinanceiroDAO {
	private Connection conexao ;


	public FinanceiroDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean Adicionar ( Financeiro fin, Cliente cliente, Pacote pacote ) {
		String sql = "INSERT INTO Financeiro(id_cliente, id_pacote, vencimento, valor) VALUES (?, ?, ?, ?)";
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, cliente.getId_cliente());
			stmt.setInt(2, pacote.getId_pacote());
			stmt.setDate(3, fin.getVencimento());
			stmt.setDouble(4, fin.getValor());
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows > 0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Financeiro> getListaFinanceiro(){
		String sql = "SELECT * FROM financeiro";
		ArrayList<Financeiro> listafinanceiro = new ArrayList<Financeiro>();
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {

				int id_cliente = Integer.parseInt(rs.getString("id_cliente"));
				ClienteDAO clientedao = new ClienteDAO();
				Cliente cliente = clientedao.getClienteById(id_cliente);
				
				int id_pacote = Integer.parseInt(rs.getString("id_pacote"));
				PacoteDAO pacotedao = new PacoteDAO();
				Pacote pacote = pacotedao.getPacoteById(id_pacote);
				Date vencimento = rs.getDate("vencimento");
				double valor = rs.getDouble("valor");
				Financeiro financeiro = new Financeiro(cliente,pacote,vencimento,valor);
				
				listafinanceiro.add(financeiro);
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return listafinanceiro;
	}
	

}
