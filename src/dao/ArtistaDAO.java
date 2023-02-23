package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Artista;

public class ArtistaDAO {
	private Connection connection;
	
	public ArtistaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Artista a) {
		int inseriu = 0;
		String sql = "INSERT INTO Artista VALUES (?, ?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, a.getCpf());
			stmt.setString(2, a.getNome_artistico());
			stmt.setDate(3, a.getData_nascimento());
			stmt.setString(4, a.getEspecializacao());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int remover(Artista a) {
		int removeu = 0;
		String sql = "DELETE FROM Artista WHERE cpf = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, a.getCpf());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar(Artista a) {
		int alterou = 0;
		String sql = "UPDATE Artista SET nome_artistico = ?, data_nascimento = ?, especializacao = ? WHERE cpf = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, a.getNome_artistico());
			stmt.setDate(2, a.getData_nascimento());
			stmt.setString(3, a.getEspecializacao());
			stmt.setString(4, a.getCpf());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public ArrayList<Artista> getArtistas() {
		String sql = "SELECT * FROM Artista";
		PreparedStatement stmt;
		Artista a;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Artista> artistas = new ArrayList<>();
			while (rs.next()) {
				a = new Artista();
				a.setCpf(rs.getString("cpf"));
				a.setNome_artistico(rs.getString("nome_artistico"));
				a.setData_nascimento(rs.getDate("data_nascimento"));
				a.setEspecializacao(rs.getString("especializacao"));
				artistas.add(a);
			}
			stmt.close();
			rs.close();
			return artistas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Artista getArtista(String cpf) {
		String sql = "SELECT cpf, nome_artistico, data_nascimento, especializacao FROM Artista WHERE cpf = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			Artista a = new Artista();
			while (rs.next()) {
				a = new Artista();
				a.setCpf(rs.getString("cpf"));
				a.setNome_artistico(rs.getString("nome_artistico"));
				a.setData_nascimento(rs.getDate("data_nascimento"));
				a.setEspecializacao(rs.getString("especializacao"));
			}
			stmt.close();
			rs.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> getCpfs() {
		String sql = "SELECT cpf FROM Artista";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<String> cpfs = new ArrayList<>();
			while (rs.next()) {
				cpfs.add(rs.getString("cpf"));
			}
			rs.close();
			stmt.close();
			return cpfs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> getNomes() {
		String sql = "SELECT nome_artistico FROM Artista";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<String> cpfs = new ArrayList<>();
			while (rs.next()) {
				cpfs.add(rs.getString("nome_artistico"));
			}
			rs.close();
			stmt.close();
			return cpfs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int existeArtista(String cpf) {
		int existe = 0;
		String sql = "SELECT count(*) as contador FROM Artista WHERE cpf = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				existe = rs.getInt("contador");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}
	
	public ArrayList<Artista> getArtistaEstilo(String estilo) {
		String sql = "SELECT a.cpf, a.nome_artistico, a.especializacao FROM Artista a INNER JOIN Grava g ON g.cpf_artista = a.cpf WHERE g.estilo = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, estilo);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Artista> artistas = new ArrayList<>();
			while (rs.next()) {
				Artista a = new Artista();
				a.setCpf(rs.getString("cpf"));
				a.setNome_artistico(rs.getString("nome_artistico"));
				a.setEspecializacao(rs.getString("especializacao"));
				artistas.add(a);
			}
			stmt.close();
			rs.close();
			return artistas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
 	}
	
	public int qtdArtistasCadastrados() {
		int qtd = 0;
		String sql = "SELECT count(cpf) as cont FROM Artista";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("cont");
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int qtdArtistasGravados() {
		int qtd = 0;
		String sql = "SELECT count(a.cpf) as cont FROM Artista a INNER JOIN Grava g ON g.cpf_artista = a.cpf";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("cont");
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int qtdArtistasCantores() {
		int qtd = 0;
		String sql = "SELECT count(cpf) as cont FROM Artista WHERE especializacao like 'Cantor' or 'Cantora'";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("cont");
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int qtdArtistasCompositores() {
		int qtd = 0;
		String sql = "SELECT count(cpf) as cont FROM Artista WHERE especializacao like 'Compositor' or 'Compositora'";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("cont");
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
}
