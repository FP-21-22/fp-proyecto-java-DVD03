package fp.clinico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import fp.utiles.Checkers;


/**
 * @author David Vargas Muñiz
 *
 */
public record Persona(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
	/**
	 * @param nombre: String
	 * @param apellidos: String
	 * @param dni: String
	 * @param fechaNacimiento: LocalDate
	 * @return
	 */
	public static Persona of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
		//RESTRICCIONES
		LocalDate now = LocalDate.now();
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual", fechaNacimiento.compareTo(now)<0);
		Checkers.check("El dni debe ser una cadena con ocho dígitos y seguidos de una letra", dni.length()==9 && sonDigitos(dni) || Character.isAlphabetic(dni.charAt(8)));
		//
		Persona p = new Persona(nombre, apellidos, dni, fechaNacimiento);
		return p;
	}
	
	private static Boolean sonDigitos(String dni) {
		Boolean res = true;
		for(int i=0;i<dni.length();i++) {
			res = Character.isDigit(dni.charAt(i));
			if(!res) {
				break;
			}
		}
		return res;
	}

	
	//Método static parse
	public static Persona parse(String text) {
		String[] sp = text.split(",");
		if (sp.length != 4) {
			throw new IllegalArgumentException(
				"Cadena con formato no válido");
		}
		String nombre = sp[0].trim();
		String apellidos = sp[1].trim();
		String dni = sp[2].trim();
		LocalDate fechaNacimiento = LocalDate.parse(sp[3].trim(), 
			DateTimeFormatter.ofPattern("d/M/y"));
		return Persona.of(nombre,apellidos,dni,fechaNacimiento);
	}
	
	//Propiedades derivadas
	/**
	 * @return Obtiene la edad a partir de la fecha actual(hoy) y la de nacimiento(fechaNacimiento)
	 */
	public Integer edad() {
		LocalDate hoy = LocalDate.now();
		Integer res = this.fechaNacimiento.until(hoy).getYears();
		return res;				
	}
	//

	//Orden natural
	public int compareTo(Persona o) {
		int res = this.dni().compareTo(dni());
		return res;
		}
	
	//Método main
	public static void main(String[] args) {
		Persona p = Persona.parse("Juan, García Rodríguez, 12755078Z, 20/03/1965");
		System.out.println(p);
	}
	
	}
