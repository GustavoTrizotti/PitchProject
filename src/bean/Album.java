package bean;

public class Album {
	// values
	private int codigo_produto;
	private String nome;
	private int ano;
	private String distribuidora;
	private String gravadora;
	private int lote;

	// constructors
	public Album(int codigo_produto, String nome, int ano, String distribuidora, String gravadora, int lote) {
		super();
		this.codigo_produto = codigo_produto;
		this.nome = nome;
		this.ano = ano;
		this.distribuidora = distribuidora;
		this.gravadora = gravadora;
		this.lote = lote;
	}

	public Album() {
		super();
	}

	// methods
	public int getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(int codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	public String getGravadora() {
		return gravadora;
	}

	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	@Override
	public String toString() {
		return "Album [codigo_produto=" + codigo_produto + ", nome=" + nome + ", ano=" + ano
				+ ", distribuidora=" + distribuidora + ", gravadora=" + gravadora + ", lote=" + lote + "]";
	}
}
