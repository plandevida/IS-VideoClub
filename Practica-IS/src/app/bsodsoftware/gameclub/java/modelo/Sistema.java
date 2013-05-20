package app.bsodsoftware.gameclub.java.modelo;

public class Sistema {

	private SistemaUsuarios sistemaUsuarios;
	private SistemaJuegos sistemaJuegos;
	private SistemaPrestamos sistemaPrestamos;

	public Sistema() {
		setSistemaUsuarios(new SistemaUsuarios());
		sistemaJuegos = new SistemaJuegos();
		sistemaPrestamos = new SistemaPrestamos();

	}

	public void Prestar(int idjuego, int idcopia, boolean disponible) {

	}

	public void Devolver() {

	}

	public void DarDeAltaUsuario() {
	}

	public void ConsultarTodosPrestamos() {
	}

	public void DarDeAltaJuego() {
	}

	public void ConsultarPrestamo() {
	}

	public void DevolverPrestamo() {
	}

	public SistemaUsuarios getSistemaUsuarios() {
		return sistemaUsuarios;
	}

	public void setSistemaUsuarios(SistemaUsuarios sistemaUsuarios) {
		this.sistemaUsuarios = sistemaUsuarios;
	}

}