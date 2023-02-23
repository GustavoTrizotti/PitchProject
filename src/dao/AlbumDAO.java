package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Album;

public class AlbumDAO {
	private Connection connection;
	
	public AlbumDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Album a) {
		int inseriu = 0;
		PreparedStatement stmt;
		String sql = "INSERT INTO Album (codigo_produto, nome, ano, distribuidora, gravadora, lote) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, a.getCodigo_produto());
			stmt.setString(2, a.getNome());
			stmt.setInt(3, a.getAno());
			stmt.setString(4, a.getDistribuidora());
			stmt.setString(5, a.getGravadora());
			stmt.setInt(6, a.getLote());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int remover(Album a) {
		int removeu = 0;
		String sql = "DELETE FROM Album WHERE codigo_produto = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, a.getCodigo_produto());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar(Album a) {
		int alterou = 0;
		PreparedStatement stmt;
		String sql = "UPDATE Album SET nome=?, ano=?, distribuidora=?, gravadora=?, lote=? WHERE codigo_produto = ?";
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, a.getNome());
			stmt.setInt(2, a.getAno());
			stmt.setString(3, a.getDistribuidora());
			stmt.setString(4, a.getGravadora());
			stmt.setInt(5, a.getLote());
			stmt.setInt(6, a.getCodigo_produto());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public ArrayList<Album> getAlbuns() {
		String sql = "SELECT * FROM Album";
		PreparedStatement stmt;
		Album a;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Album> albuns = new ArrayList<>();
			while (rs.next()) {
				a = new Album();
				a.setCodigo_produto(rs.getInt("codigo_produto"));
				a.setNome(rs.getString("nome"));
				a.setAno(rs.getInt("ano"));
				a.setDistribuidora(rs.getString("distribuidora"));
				a.setGravadora(rs.getString("gravadora"));
				a.setLote(rs.getInt("lote"));
				albuns.add(a);
			}
			rs.close();
			stmt.close();
			return albuns;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Integer> getCodigos() {
		String sql = "SELECT codigo_produto FROM Album";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Integer> codigos = new ArrayList<>();
			while (rs.next()) {
				codigos.add(rs.getInt("codigo_produto"));
			}
			rs.close();
			stmt.close();
			return codigos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Album getAlbum(int codigo) {
		String sql = "SELECT codigo_produto, nome, ano, distribuidora, gravadora, lote FROM Album WHERE codigo_produto = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			Album a = new Album();
			while (rs.next()) {
				a.setCodigo_produto(rs.getInt("codigo_produto"));
				a.setNome(rs.getString("nome"));
				a.setAno(rs.getInt("ano"));
				a.setDistribuidora(rs.getString("distribuidora"));
				a.setGravadora(rs.getString("gravadora"));
				a.setLote(rs.getInt("lote"));
			}
			rs.close();
			stmt.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int existeAlbum(int codigo) {
		int existe = 0;
		String sql = "SELECT count(*) as contador FROM Album WHERE codigo_produto = ?";
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
	
	public Album getAlbumRecente() {
		String sql = "SELECT * FROM Album WHERE ano = (SELECT max(ano) FROM Album)";
		PreparedStatement stmt;
		Album a = new Album();
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				a.setCodigo_produto(rs.getInt("codigo_produto"));
				a.setNome(rs.getString("nome"));
				a.setAno(rs.getInt("ano"));
				a.setDistribuidora(rs.getString("distribuidora"));
				a.setGravadora(rs.getString("gravadora"));
				a.setLote(rs.getInt("lote"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public Album getAlbumAntigo() {
		String sql = "SELECT * FROM Album WHERE ano = (SELECT min(ano) FROM Album)";
		PreparedStatement stmt;
		Album a = new Album();
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				a.setCodigo_produto(rs.getInt("codigo_produto"));
				a.setNome(rs.getString("nome"));
				a.setAno(rs.getInt("ano"));
				a.setDistribuidora(rs.getString("distribuidora"));
				a.setGravadora(rs.getString("gravadora"));
				a.setLote(rs.getInt("lote"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public int getQtdDistribuidoras() {
		int qtd = 0;
		String sql = "SELECT count(distribuidora) as cont FROM Album";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("cont");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int getQtdGravadoras() {
		int qtd = 0;
		String sql = "SELECT count(gravadora) as cont FROM Album";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("cont");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int getQtdAlbunsCadastrados() {
		int qtd = 0;
		String sql = "SELECT count(codigo_produto) as cont FROM Album";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("cont");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int getQtdAlbunsGravados() {
		int qtd = 0;
		String sql = "SELECT count(a.codigo_produto) as cont FROM Album a INNER JOIN Grava g ON g.codigo_produto = a.codigo_produto";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				qtd = rs.getInt("cont");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public ArrayList<Album> selectAlbumEstilo(String estilo) {
		String sql = ("SELECT a.codigo_produto, a.nome, a.ano FROM Album a INNER JOIN Grava g ON a.codigo_produto=g.codigo_produto WHERE g.estilo = ?");
		PreparedStatement stmt;
		Album a;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, estilo);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Album> albuns = new ArrayList<>();
			while (rs.next()) {
				a = new Album();
				a.setCodigo_produto(rs.getInt("codigo_produto"));
				a.setNome(rs.getString("nome"));
				a.setAno(rs.getInt("ano"));
				albuns.add(a);
			}
			rs.close();
			stmt.close();
			return albuns;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
