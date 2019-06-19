package provedor.trabalho;

public class Pacote {
	
	private int id_pacote;
	private String tipo;
	private String plano;
	
	public Pacote(int id_pacote,String tipo, String plano) {
		super();
		this.id_pacote = id_pacote;
		this.tipo = tipo;
		this.plano = plano;
}

	public Pacote(String tipo, String plano) {
		super();
		this.tipo = tipo;
		this.plano = plano;
}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public int getId_pacote() {
		return id_pacote;
	}

	public void setId_pacote(int id_pacote) {
		this.id_pacote = id_pacote;
	}
	
	@Override
	public String toString() {
		return "Pacote [id_pacote=" + id_pacote + ", tipo=" + tipo + ", plano=" + plano + "]";
	}


}