package bean;

import java.sql.Time;

public class Musica {
	// values
	private int codigo;
	private String nome;
	private Time duracao;
	private int ano;
	private String creditos;
	
	// constructors
	public Musica(int codigo, String nome, Time duracao, int ano, String creditos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.duracao = duracao;
		this.ano = ano;
		this.creditos = creditos;
	}

	public Musica() {
		super();
	}
	
	// methods
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Time getDuracao() {
		return duracao;
	}

	public void setDuracao(Time duracao) {
		this.duracao = duracao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "Musica [codigo=" + codigo + ", nome=" + nome + ", duracao=" + duracao + ", ano=" + ano + ", creditos="
				+ creditos + "]";
	}
}
