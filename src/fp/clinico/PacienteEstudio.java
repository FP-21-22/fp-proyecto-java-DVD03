package fp.clinico;

import fp.utiles.Checkers;

/**
 * @author David Vargas Muñiz
 *
 */
public record PacienteEstudio(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadDelCorazon, 
		TipoResidencia tipoDeResidencia, Double nivelMedioGlucosa) {
	
	/**
	 * @param id: String
	 * @param genero: String
	 * @param edad: Double
	 * @param hipertension: Boolean
	 * @param enfermedadDelCorazon: Boolean
	 * @param tipoDeResidencia: TipoResidencia
	 * @param nivelMedioGlucosa: Double
	 * @return Objeto tipo PacienteEstudio
	 */
	public static PacienteEstudio of(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadDelCorazon, 
			TipoResidencia tipoDeResidencia, Double nivelMedioGlucosa) {
	//RESTRICCIONES
	Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130", edad>=0 && edad<=130);
	Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero", nivelMedioGlucosa>=0.0);
	//
	PacienteEstudio pa = new PacienteEstudio (id, genero, edad, hipertension, enfermedadDelCorazon, tipoDeResidencia, nivelMedioGlucosa);
	return pa;
	}
	
	//Propiedades derivadas
	/**
	 * @return Obtiene factorDeRiesgo a partir de edad e hipertension
	 */
	public Boolean factorDeRiesgo() {
//		Boolean factorDeRiesgo = null;
//		if(edad>40 && hipertension==true) {
//			factorDeRiesgo = true;
//		}
//		return factorDeRiesgo;
		return edad>40.0 && hipertension==true;
	}
	
	//Representación como cadena
	public String toString() {
		return "id: "+id+", edad: "+edad;
	}
	
	//Criterio de orden
	public int compareTo(PacienteEstudio o) {
		int res = this.edad().compareTo(this.edad());
		if(res==0) {
			res = this.id().compareTo(id());
		}
		return res;
	}
	
	//Método static parse
	public static PacienteEstudio parse(String text) {
		String[] sp = text.split(";");
		if (sp.length != 7) {
			throw new IllegalArgumentException(
				"Cadena con formato no válido");
		}
		String id = sp[0].trim();
		String genero = sp[1].trim();
		Double edad = Double.parseDouble(sp[2].trim());
		Boolean hipertension = Boolean.parseBoolean(sp[3].trim());
		Boolean enfermedadDelCorazon = Boolean.parseBoolean(sp[4].trim());
		TipoResidencia tipoDeResidencia = TipoResidencia.valueOf(sp[5].trim().toUpperCase());
		Double nivelMedioGlucosa = Double.parseDouble(sp[6].trim());
		return PacienteEstudio.of(id, genero, edad, hipertension, enfermedadDelCorazon, tipoDeResidencia, nivelMedioGlucosa);
		
	}
	
	//Método main
	public static void main(String[] args) {
		PacienteEstudio pa = PacienteEstudio.parse("6306;Male;80.0;false;false;URBANA;83.84");
		System.out.println(pa);
		
	}
}
