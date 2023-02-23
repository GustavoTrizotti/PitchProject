package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import bean.Grava;

public class GravaDAO {
	Connection connection;
	
	public GravaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	// Note: maybe the code doesn't compile cause there's a difference between the java's 'Date' and MySQL 'Date' type;
	// in this case, I'm using the java's 'Date' type in the parameter;
	
	// Note 2: change manually the data types from java's to MySQL in DAO;
	
	public int gravar(Grava g) {
		int gravou = 0;
		String sql = "INSERT INTO Grava (data_gravacao, cpf_artista, codigo_produto, codigo_musica, estilo) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDate(1, g.getData_gravacao());
			stmt.setString(2, g.getCpf_artista());
			stmt.setInt(3, g.getCodigo_produto());
			stmt.setInt(4, g.getCodigo_musica());
			stmt.setString(5, g.getEstilo());
			gravou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gravou;
	}
	
	public int remover(Grava g) {
		int removeu = 0;
		String sql = "DELETE FROM Grava WHERE codigo_musica = ? and codigo_produto = ? and cpf_artista = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, g.getCodigo_musica());
			stmt.setInt(2, g.getCodigo_produto());
			stmt.setString(3, g.getCpf_artista());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int removerMusica(int codigoM) {
		int removeu = 0;
		String sql = "DELETE FROM Grava WHERE codigo_musica = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, codigoM);
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int removerAlbum(int codigoA) {
		int removeu = 0;
		String sql = "DELETE FROM Grava WHERE codigo_produto = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, codigoA);
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int removerArtista(String cpf) {
		int removeu = 0;
		String sql = "DELETE FROM Grava WHERE cpf_artista = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar(Grava g) {
		int alterou = 0;
		String sql = "UPDATE Grava SET estilo = ? WHERE codigo_musica = ? and codigo_produto = ? and cpf_artista = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, g.getEstilo());
			stmt.setInt(2, g.getCodigo_musica());
			stmt.setInt(3, g.getCodigo_produto());
			stmt.setString(4, g.getCpf_artista());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public ArrayList<Grava> getGravacao() {
		String sql = "SELECT * FROM Grava";
		PreparedStatement stmt;
		Grava g;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Grava> gravacoes = new ArrayList<>();
			while (rs.next()) {
				g = new Grava();
				g.setCodigo_musica(rs.getInt("codigo_musica"));
				g.setCodigo_produto(rs.getInt("codigo_produto"));
				g.setCpf_artista(rs.getString("cpf_artista"));
				g.setData_gravacao(rs.getDate("data_gravacao"));
				g.setEstilo(rs.getString("estilo"));
				gravacoes.add(g);
			}
			stmt.close();
			rs.close();
			return gravacoes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Date> getDataGravacao() {
		String sql = "SELECT data_gravacao FROM Grava";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Date> datas = new ArrayList<>();
			while (rs.next()) {
				
				datas.add(rs.getDate("data_gravacao"));
			}
			stmt.close();
			rs.close();
			return datas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Grava getGrava(String cpf, int codigoA, int codigoM) {	
		String sql = "SELECT * FROM Grava WHERE cpf_artista = ? and codigo_produto = ? and codigo_musica = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.setInt(2, codigoA);
			stmt.setInt(3, codigoM);
			ResultSet rs = stmt.executeQuery();
			Grava g = new Grava();
			while (rs.next()) {
				g.setCodigo_musica(codigoM);
				g.setCodigo_produto(codigoA);
				g.setCpf_artista(cpf);
				g.setData_gravacao(rs.getDate("data_gravacao"));
				g.setEstilo(rs.getString("estilo"));
			}
			stmt.close();
			rs.close();
			return g;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Grava getGravaData(Date data) {
		String sql = "SELECT * FROM Grava WHERE data_gravacao = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDate(1, data);
			ResultSet rs = stmt.executeQuery();
			Grava g = new Grava();
			while (rs.next()) {
				g.setCodigo_musica(rs.getInt("codigo_musica"));
				g.setCodigo_produto(rs.getInt("codigo_produto"));
				g.setCpf_artista(rs.getString("cpf_artista"));
				g.setData_gravacao(data);
				g.setEstilo(rs.getString("estilo"));
			}
			stmt.close();
			rs.close();
			return g;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
 	}
	
	public int existeGrava(String cpf, int codigoA, int codigoM) {
		int existe = 0;
		String sql = "SELECT count(*) as contador FROM Grava WHERE cpf_artista = ? and codigo_produto = ? and codigo_musica = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.setInt(2, codigoA);
			stmt.setInt(3, codigoM);
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
	
	public Time getDuracaoGrava(Date data) {
		Time duracao = null;
		String sql = "SELECT m.duracao as duracao_total FROM Grava g INNER JOIN Musica m ON g.codigo_musica = m.codigo WHERE g.data_gravacao = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDate(1, data);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				duracao = rs.getTime("duracao_total");
			}
			stmt.close();
			rs.close();
			return duracao;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Grava getGravacaoRecente() {
		String sql = "SELECT * FROM Grava WHERE data_gravacao = (SELECT max(data_gravacao) FROM Grava)";
		PreparedStatement stmt;
		Grava g = null;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				g = new Grava();
				g.setCodigo_musica(rs.getInt("codigo_musica"));
				g.setCodigo_produto(rs.getInt("codigo_produto"));
				g.setCpf_artista(rs.getString("cpf_artista"));
				g.setData_gravacao(rs.getDate("data_gravacao"));
				g.setEstilo(rs.getString("estilo"));
			}
			stmt.close();
			rs.close();
			return g;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Grava getGravacaoAntiga() {
		String sql = "SELECT * FROM Grava WHERE data_gravacao = (SELECT min(data_gravacao) FROM Grava)";
		PreparedStatement stmt;
		Grava g = null;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				g = new Grava();
				g.setCodigo_musica(rs.getInt("codigo_musica"));
				g.setCodigo_produto(rs.getInt("codigo_produto"));
				g.setCpf_artista(rs.getString("cpf_artista"));
				g.setData_gravacao(rs.getDate("data_gravacao"));
				g.setEstilo(rs.getString("estilo"));
			}
			stmt.close();
			rs.close();
			return g;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int qtdGravacoes() {
		int qtd = 0;
		String sql = "SELECT count(*) as contador FROM Grava";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("contador");
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	} 
	
	public Grava getGravaMaiorDuracao() {
		String sql = "SELECT * FROM Grava g INNER JOIN Musica m ON g.codigo_musica = m.codigo WHERE m.duracao = (SELECT max(duracao) FROM Musica)";
		PreparedStatement stmt;
		Grava g = null;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				g = new Grava();
				g.setCodigo_musica(rs.getInt("codigo_musica"));
				g.setCodigo_produto(rs.getInt("codigo_produto"));
				g.setCpf_artista(rs.getString("cpf_artista"));
				g.setData_gravacao(rs.getDate("data_gravacao"));
				g.setEstilo(rs.getString("estilo"));
			}
			stmt.close();
			rs.close();
			return g;
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return null;
	}
	
	public Grava getGravaMenorDuracao() {
		String sql = "SELECT * FROM Grava g INNER JOIN Musica m ON g.codigo_musica = m.codigo WHERE m.duracao = (SELECT min(duracao) FROM Musica)";
		PreparedStatement stmt;
		Grava g = null;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				g = new Grava();
				g.setCodigo_musica(rs.getInt("codigo_musica"));
				g.setCodigo_produto(rs.getInt("codigo_produto"));
				g.setCpf_artista(rs.getString("cpf_artista"));
				g.setData_gravacao(rs.getDate("data_gravacao"));
				g.setEstilo(rs.getString("estilo"));
			}
			stmt.close();
			rs.close();
			return g;
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return null;
	}
}

