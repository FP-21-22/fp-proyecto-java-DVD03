package fp.vacunas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

/**
 * @author David Vargas Muñiz
 *
 */
public record Vacunacion(LocalDate fecha, String comunidad, Integer numeroPersonas, Integer pfizer, Integer moderna, Integer astrazeneca, 
		Integer janssen) {
	
	/**
	 * @param fecha: LocalDate
	 * @param comunidad: String
	 * @param numeroPersonas: Integer
	 * @param pfizer: Integer
	 * @param moderna: Integer
	 * @param astrazeneca: Integer
	 * @param janssen: Integer
	 * @return Objeto de tipo Vacunacion
	 */
	public static Vacunacion of(LocalDate fecha, String comunidad, Integer numeroPersonas, Integer pfizer, Integer moderna, Integer astrazeneca, 
			Integer janssen) {
		//RESTRICCIONES
		LocalDate f2 = LocalDate.of(2021, 01, 01);
		Checkers.check("La fecha debe ser posterior al 01/01/2021", !fecha.isBefore(f2) );
		//
		Vacunacion v = new Vacunacion (fecha, comunidad, numeroPersonas, pfizer, moderna, astrazeneca, janssen);
		return v;
	}
	
	//Propiedad derivada
	/**
	 * @return Devuelve el numeroTotal
	 */
	public Integer numeroTotal() {
		Integer res = pfizer+moderna+astrazeneca+janssen;
		return res;
	}
	
	//Orden natural
	public int compareTo(Vacunacion o) {
		int res = this.comunidad().compareTo(comunidad()); //por comunidad
		if(res==0) {  //y en caso de igualdad
			res = this.fecha().compareTo(fecha());  //por fecha
		}
		return res;
	}
	
	//Método static parse
	public static Vacunacion parse(String text) {
		String[] sp = text.split(";");
		if (sp.length != 7) {
			throw new IllegalArgumentException(
				"Cadena con formato no válido");
		}
		LocalDate fecha = LocalDate.parse(sp[0].trim(),DateTimeFormatter.ofPattern("d/M/y"));
		String comunidad = sp[1].trim();
		Integer numeroPersonas = Integer.parseInt(sp[2].trim());
		Integer pfizer = Integer.parseInt(sp[3].trim());
		Integer moderna = Integer.parseInt(sp[4].trim());
		Integer astrazeneca = Integer.parseInt(sp[5].trim());
		Integer janssen = Integer.parseInt(sp[6].trim());
		return Vacunacion.of(fecha, comunidad, numeroPersonas, pfizer, moderna, astrazeneca, janssen);
	}
	
	//Método main
	public static void main(String[] args) {
		Vacunacion v = Vacunacion.parse("04/01/2021;Andalucía;140295;0;0;0;0");
		System.out.println(v);
	}

}
