package Modelo;

public class fock {

	public static void main(String[] args) {
		BD miBD = BD.getBD();
		Object[] tupla = miBD.Select("SELECT * FROM Curso WHERE idCurso = " + 1).get(0);
		miBD.finalize();
			System.out.println(Boolean.parseBoolean(tupla[7].toString()));
		
	}

}
