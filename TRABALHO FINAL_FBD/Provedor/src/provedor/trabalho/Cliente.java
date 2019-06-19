package provedor.trabalho;

public class Cliente {
	private int id_cliente;
	private int cpf;
	private String nome;
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private int cep;
	private String telefone;
	
	public Cliente(int id_cliente,int cpf, String nome, String rua,int numero, String bairro, String cidade,int cep, String telefone) {
		super();
		this.id_cliente = id_cliente;
		this.cpf = cpf;
		this.nome = nome;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.telefone = telefone;
	}
	
	public Cliente(int cpf, String nome, String rua,int numero, String bairro, String cidade,int cep, String telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int string) {
		this.cep = string;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id_cliente + ", cpf=" + cpf + ", nome=" + nome + ", rua=" + rua+ ",  numero=" + numero + ", "
				+ " bairro=" + bairro + ",  cidade=" + cidade + ",  cep=" + cep +", telefone=" + telefone +"]";
	}

}
