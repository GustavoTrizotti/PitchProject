package bean;

import java.sql.Date;

public class Artista {
	// values
	private String cpf;
	private String nome_artistico;
	private Date data_nascimento;
	private String especializacao;

	// constructors
	public Artista(String cpf, String nome_artistico, Date data_nascimento, String especializacao) {
		super();
		this.cpf = cpf;
		this.nome_artistico = nome_artistico;
		this.data_nascimento = data_nascimento;
		this.especializacao = especializacao;
	}

	public Artista() {
		super();
	}

	// methods
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome_artistico() {
		return nome_artistico;
	}

	public void setNome_artistico(String nome_artistico) {
		this.nome_artistico = nome_artistico;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	@Override
	public String toString() {
		return "Artista [cpf=" + cpf + ", nome_artistico=" + nome_artistico + ", data_nascimento=" + data_nascimento
				+ ", especializacao=" + especializacao + "]";
	}
	
}
