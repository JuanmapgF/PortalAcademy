package Modelo;

public class Telefono {
	
	private int codigo;
	private String numero;
	
	public Telefono(int codigo, String numero) {
		this.codigo = codigo;
		this.numero = numero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
