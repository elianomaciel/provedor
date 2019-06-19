package provedor.trabalho;

import java.sql.Date;

public class Financeiro {
	
	private Cliente cliente;
	private Pacote pacote;
	private Date vencimento;
	private double valor;

	public Financeiro(Cliente cliente, Pacote pacote, Date vencimento, double valor) {
		super();
		this.cliente = cliente;
		this.pacote = pacote;
		this.vencimento = vencimento;
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}



}
