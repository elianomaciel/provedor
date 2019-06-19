package provedor.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import provedor.jdbc.Conexao;
import provedor.trabalho.Cliente;

public class ClienteDAO {
	private Connection conexao ;

	public boolean adicionarCliente(Cliente cliente) {
		String sql = "Insert into Cliente (cpf,nome,rua,numero,bairro,cidade,cep,telefone) values (?,?,?,?,?,?,?,?)";
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try {
			//Necessário para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//Set values
			stmt.setInt(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getRua());
			stmt.setInt(4, cliente.getNumero());
			stmt.setString(5, cliente.getBairro());
			stmt.setString(6, cliente.getCidade());
			stmt.setInt(7, cliente.getCep());
			stmt.setString(8,cliente.getTelefone());
						
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
	public boolean deleteCliente (int id) {
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		
		new Conexao();
		this.conexao = Conexao.getConnection();

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//setar valor
			stmt.setInt(1, id);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Cliente deletado com sucesso");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Cliente não pode ser deletado"
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
		return false;
	}
	
	public ArrayList<Cliente> getListaCliente() {
		String sql = "SELECT * FROM cliente;";
		ArrayList<Cliente> listacliente = new ArrayList<Cliente>();
		
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id_cliente = rs.getInt("id_cliente");
				int cpf = rs.getInt("cpf");
				String nome = rs.getString("nome");
				String rua = rs.getString("rua");
				int numero = rs.getInt("numero");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				int cep = rs.getInt("cep");
				String telefone = rs.getString("telefone");
				Cliente cliente = new Cliente(id_cliente,cpf,nome,rua,numero,bairro,cidade,cep,telefone);
				
				listacliente.add(cliente);
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
		return listacliente;
	}
	
public boolean updateCliente(int id, Cliente clienteUpd){
		
		String sql = "UPDATE cliente SET cpf = ?, nome = ?, rua = ?, numero= ?, bairro = ?,cidade = ?, cep = ?, telefone = ? WHERE id_cliente = ?";
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//atualizar valores no banco
			stmt.setInt(1, clienteUpd.getCpf());
			stmt.setString(2, clienteUpd.getNome());
			stmt.setString(3, clienteUpd.getRua());
			stmt.setInt(4, clienteUpd.getNumero());
			stmt.setString(5, clienteUpd.getBairro());
			stmt.setString(6, clienteUpd.getCidade());
			stmt.setInt(7, clienteUpd.getCep());
			stmt.setString(8,clienteUpd.getTelefone());
			stmt.setInt(9, id);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Cliente atualizado com sucesso");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Cliente não pode ser atualizado"
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
	

	public Cliente getClienteById(int id) {
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
		new Conexao();
		this.conexao = Conexao.getConnection();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			Cliente cliente = new Cliente(id, rs.getInt("cpf"), rs.getString("nome"), rs.getString("rua"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cidade"), rs.getInt("cep"), rs.getString("telefone") );
			
			stmt.close();
			
			return cliente;
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
	}
	
	
	
	
	
}
