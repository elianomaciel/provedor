package provedor.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import provedor.jdbc.Conexao;
import provedor.trabalho.Pacote;

	public class PacoteDAO {
		private Connection conexao;
	
	public PacoteDAO(){
	
	}
	public boolean adicionarPacote(Pacote pacote) {
		String sql = "Insert into Pacote (tipo, plano) values (?,?)";
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try {
			//Necessário para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//Set values
			stmt.setString(1, pacote.getTipo());
			stmt.setString(2, pacote.getPlano());
			
			int affectedRows = stmt.executeUpdate();
			stmt.close();
			
			if(affectedRows > 0) {
				return true;
			}
				return false;
		
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally{
		try {
			this.conexao.close();
		}catch(SQLException e) {
				e.printStackTrace();
			}
		}
				return false;
		
	}

//Deletando Pacotes
	public boolean deletePacote (int id) {
		String sql = "DELETE FROM pacote WHERE id_pacote = ?";
	
		new Conexao();
			this.conexao = Conexao.getConnection();

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
		//setar valor
			stmt.setInt(1, id);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Pacote deletado com sucesso");
				return true;
		}
			JOptionPane.showMessageDialog(null, "Pacote não pode ser deletado"
											+ " ou inexistente");
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}finally {
		try {
				this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
				return false;}
	
// Listando Pacotes
	
	public ArrayList<Pacote> getListaPacote() {
		String sql = "SELECT * FROM pacote;";
		ArrayList<Pacote> listapacote = new ArrayList<Pacote>();
		
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id_pacote = rs.getInt("id_pacote");
				String tipo = rs.getString("tipo");
				String plano = rs.getString("plano");
				
				Pacote pacote = new Pacote(id_pacote, tipo, plano);
				
				listapacote.add(pacote);
			}
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			try {
				this.conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listapacote;
	}
	
public boolean updatePacote(int id, Pacote pacoteUpd){
		
		String sql = "UPDATE pacote SET tipo = ?, plano = ? WHERE id_pacote = ?";
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//atualizar valores no banco
			stmt.setString(1, pacoteUpd.getTipo());
			stmt.setString(2, pacoteUpd.getPlano());
			stmt.setInt(3, id);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Pacote atualizado com sucesso");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Pacote não pode ser atualizado"
					+ " ou inexistente");
			return false;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}finally{
			try{
				this.conexao.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
}
	public Pacote getPacoteById(int id) {
		String sql = "SELECT * FROM pacote WHERE id_pacote = ?";
		
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			Pacote pacote = new Pacote(id, rs.getString("tipo"), rs.getString("plano"));
			
			stmt.close();
			
			return pacote;
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "NADA ENCONTRADO");
		return null;
	}}
	
	