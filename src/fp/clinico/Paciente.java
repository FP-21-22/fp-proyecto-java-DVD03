package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

/**
 * @author David Vargas Muñiz
 *
 */
public record Paciente(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, Persona persona, 
		String codigoDeIngreso, LocalDateTime fechaHoraIngreso) {
	/**
	 * @param persona: String
	 * @param codigoDeIngreso: String
	 * @param fechaHoraIngreso: LocalDateTime
	 * @return Objeto tipo Paciente
	 */
	public static Paciente of(Persona persona, 
			String codigoDeIngreso, LocalDateTime fechaHoraIngreso) {
			//RESTRICCIONES
			LocalDateTime now = LocalDateTime.now();
			Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual", fechaHoraIngreso.compareTo(now)<=0);
			//
			Paciente p = new Paciente(null, null, null, null, persona, codigoDeIngreso, fechaHoraIngreso);
			return p;
	}

	/**
	 * @param nombre: String
	 * @param apellidos: String
	 * @param dni: String
	 * @param fechaNacimiento: LocalDate
	 * @param codigoDeIngreso: String
	 * @param fechaHoraIngreso: LocalDateTime
	 * @return Objeto tipo Paciente
	 */
	public static Paciente of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, 
			String codigoDeIngreso, LocalDateTime fechaHoraIngreso) {
		//RESTRICCIONES
		LocalDateTime now = LocalDateTime.now();
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual", fechaHoraIngreso.compareTo(now)<=0);
		//
		Paciente p2 = new Paciente(nombre, apellidos, dni, fechaNacimiento, null, codigoDeIngreso, fechaHoraIngreso);
		return p2;
	}

	
	//Propiedades derivadas
	/**
	 * @return Obtiene de la fechaHoraIngreso la fechaIngreso
	 */
	public DateTimeFormatter fechaIngreso() {
		 DateTimeFormatter fechaHoraIngreso = DateTimeFormatter.ofPattern("d/M/y");
		return fechaHoraIngreso;
	}
	/**
	 * @return Obtiene de la fechaHoraIngreso la horaIngreso
	 */
	public DateTimeFormatter horaIngreso() {
		DateTimeFormatter fechaHoraIngreso = DateTimeFormatter.ofPattern("HH:mm");
		return fechaHoraIngreso;
	}

	
	
}
