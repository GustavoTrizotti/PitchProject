package bean;

import java.sql.Date;

public class Grava {
	// values
	private Date data_gravacao;
	private String cpf_artista;
	private int codigo_produto;
	private int codigo_musica;
	private String estilo;
	
	// constructors
	public Grava(Date data_gravacao, String cpf_artista, int codigo_produto, int codigo_musica, String estilo) {
		super();
		this.data_gravacao = data_gravacao;
		this.cpf_artista = cpf_artista;
		this.codigo_produto = codigo_produto;
		this.codigo_musica = codigo_musica;
		this.estilo = estilo;
	}

	public Grava() {
		super();
	}

	// methods
	public Date getData_gravacao() {
		return data_gravacao;
	}

	public void setData_gravacao(Date data_gravacao) {
		this.data_gravacao = data_gravacao;
	}

	public String getCpf_artista() {
		return cpf_artista;
	}

	public void setCpf_artista(String cpf_artista) {
		this.cpf_artista = cpf_artista;
	}

	public int getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(int codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public int getCodigo_musica() {
		return codigo_musica;
	}

	public void setCodigo_musica(int codigo_musica) {
		this.codigo_musica = codigo_musica;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return "Grava [data_gravacao=" + data_gravacao + ", cpf_artista=" + cpf_artista + ", codigo_produto="
				+ codigo_produto + ", codigo_musica=" + codigo_musica + ", estilo=" + estilo + "]";
	}
}
