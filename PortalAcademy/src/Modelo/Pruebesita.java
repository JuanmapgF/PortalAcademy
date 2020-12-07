package Modelo;

public class Pruebesita {

	public static void main(String[] args) {
		BD bd = BD.getBD();
		bd.Insert("Insert into Usuario (nick,correo,contrasena) values ('Ivan','you','patate')");
	}

}
