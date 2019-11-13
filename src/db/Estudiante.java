package db;

public class Estudiante {
	private int id;
	private String nombre;
	private String carrera;
	private String genero;
	private float peso;
	private float estatura;
	private int edad;
	
	public Estudiante(int id, String nombre, String carrera, String genero, float peso, float estatura, int edad){
		super();
		this.id = id;
		this.nombre = nombre;
		this.carrera = carrera;
		this.genero = genero;
		this.peso = peso;
		this.estatura = estatura;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}
