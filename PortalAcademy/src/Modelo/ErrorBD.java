package Modelo;

@SuppressWarnings("serial")
public class ErrorBD extends RuntimeException  
{

	public ErrorBD() {
		super();
	}

	public ErrorBD(String msg) {
		super(msg);
	}
}
