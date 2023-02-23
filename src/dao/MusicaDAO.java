package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Musica;

public class MusicaDAO {
	private Connection connection;
	
	public MusicaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Musica m) {
		int inseriu = 0;
		String sql = "INSERT INTO Musica VALUES (?, ?, ?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, m.getCodigo());
			stmt.setString(2, m.getNome());
			stmt.setTime(3, m.getDuracao());
			stmt.setInt(4, m.getAno());
			stmt.setString(5, m.getCreditos());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int remover(Musica m) {
		int removeu = 0;
		String sql = "DELETE FROM Musica WHERE codigo = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, m.getCodigo());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar(Musica m) {
		int alterou = 0;
		String sql = "UPDATE Musica SET nome = ?, duracao = ?, ano = ?, creditos = ? WHERE codigo = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, m.getNome());
			stmt.setTime(2, m.getDuracao());
			stmt.setInt(3, m.getAno());
			stmt.setString(4, m.getCreditos());
			stmt.setInt(5, m.getCodigo());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public ArrayList<Musica> getMusicas() {
		String sql = "SELECT * FROM Musica";
		PreparedStatement stmt;
		Musica m;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Musica> musicas = new ArrayList<>();
			while (rs.next()) {
				m = new Musica();
				m.setCodigo(rs.getInt("codigo"));
				m.setNome(rs.getString("nome"));
				m.setDuracao(rs.getTime("duracao"));
				m.setAno(rs.getInt("ano"));
				m.setCreditos(rs.getString("nome"));
				musicas.add(m);
			}
			stmt.close();
			rs.close();
			return musicas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Integer> getCodigos() {
		String sql = "SELECT codigo FROM Musica";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Integer> codigos = new ArrayList<>();
			while (rs.next()) {
				codigos.add(rs.getInt("codigo"));
			}
			rs.close();
			stmt.close();
			return codigos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Musica getMusica(int codigo) {
		String sql = "SELECT codigo, nome, duracao, ano, creditos FROM Musica WHERE codigo = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			Musica m = new Musica();
			while (rs.next()) {
				m.setCodigo(rs.getInt("codigo"));
				m.setNome(rs.getString("nome"));
				m.setDuracao(rs.getTime("duracao"));
				m.setAno(rs.getInt("ano"));
				m.setCreditos(rs.getString("creditos"));
			}
			rs.close();
			stmt.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int existeMusica (int codigo) {
		int existe = 0;
		String sql = "SELECT count(*) as contador FROM Musica WHERE codigo = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, codigo);
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
	
	public ArrayList<Musica> selectMusicaEstilo(String estilo) {
		String sql = ("SELECT m.codigo, m.nome, m.duracao, m.ano, m.creditos FROM Musica m INNER JOIN Grava g ON m.codigo=g.codigo_musica WHERE g.estilo = ?");
		PreparedStatement stmt;
		Musica m;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, estilo);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Musica> musicas = new ArrayList<>();
			while (rs.next()) {
				m = new Musica();
				m.setCodigo(rs.getInt("codigo"));
				m.setNome(rs.getString("nome"));
				m.setDuracao(rs.getTime("duracao"));
				m.setAno(rs.getInt("ano"));
				m.setCreditos(rs.getString("creditos"));
				musicas.add(m);
			}
			rs.close();
			stmt.close();
			return musicas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Musica getMusicaMaiorDuracao() {
		String sql = "SELECT * FROM Musica WHERE duracao = (SELECT max(duracao) FROM Musica)";
		PreparedStatement stmt;
		Musica m = new Musica();
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				m.setCodigo(rs.getInt("codigo"));
				m.setNome(rs.getString("nome"));
				m.setDuracao(rs.getTime("duracao"));
				m.setAno(rs.getInt("ano"));
				m.setCreditos(rs.getString("creditos"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Musica getMusicaMenorDuracao() {
		String sql = "SELECT * FROM Musica WHERE duracao = (SELECT min(duracao) FROM Musica)";
		PreparedStatement stmt;
		Musica m = new Musica();
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				m.setCodigo(rs.getInt("codigo"));
				m.setNome(rs.getString("nome"));
				m.setDuracao(rs.getTime("duracao"));
				m.setAno(rs.getInt("ano"));
				m.setCreditos(rs.getString("creditos"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Musica getMusicaRecente() {
		String sql = "SELECT * FROM Musica WHERE ano = (SELECT max(ano) FROM Musica)";
		PreparedStatement stmt;
		Musica m = new Musica();
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				m.setCodigo(rs.getInt("codigo"));
				m.setNome(rs.getString("nome"));
				m.setDuracao(rs.getTime("duracao"));
				m.setAno(rs.getInt("ano"));
				m.setCreditos(rs.getString("creditos"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Musica getMusicaAntiga() {
		String sql = "SELECT * FROM Musica WHERE ano = (SELECT min(ano) FROM Musica)";
		PreparedStatement stmt;
		Musica m = new Musica();
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				m.setCodigo(rs.getInt("codigo"));
				m.setNome(rs.getString("nome"));
				m.setDuracao(rs.getTime("duracao"));
				m.setAno(rs.getInt("ano"));
				m.setCreditos(rs.getString("creditos"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public int getQtdMusicasCadastradas() {
		int qtd = 0;
		String sql = "SELECT count(codigo) as contador FROM Musica;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("contador");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int getQtdMusicasGravadas() {
		int qtd = 0;
		String sql = "SELECT count(m.codigo) as contador FROM Musica m INNER JOIN Grava g ON m.codigo = g.codigo_musica;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("contador");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
}

