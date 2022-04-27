package fp.clinico;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author David Vargas Muñiz
 *
 */
public interface EstudioClinico{
	 // Propiedades de lista
	 /**
	 * @return número de pacientes
	 */
	Integer numeroPacientes();
	/**
	 * @param paciente, añade paciente a la lista pacienteEstudioLista
	 */
	void incluyePaciente(PacienteEstudio paciente);
	/**
	 * @param pacientes
	 */
	void incluyePacientes(Collection<PacienteEstudio> pacientes);
	/**
	 * @param paciente, elimina paciente de la lista
	 */
	void eliminaPaciente(PacienteEstudio paciente);
	 /**
	 * @param paciente, pasa el parámetro paciente del tipo PacienteEstudio
	 * @return devuelve true si la lista contiene paciente y por el contrario false si no lo contiene
	 */
	Boolean estaPaciente(PacienteEstudio paciente);
	void borraEstudio();
	 //
	 // Método de factoría
	/**
	 * @param nombreFichero
	 * @return devuelve un objeto del tipo EstudioClinico
	 */
	EstudioClinico of(String nombreFichero);
	 /**
	 * @param nombreFichero
	 * @return carga el fichero correspondiente en una lista de objetos del tipo PacienteEstudio
	 */
	List<PacienteEstudio> leeFichero(String nombreFichero);
	 // Tratamientos secuenciales: implementaciónn funcional vs. imperativa
	 //existe, paraTodo
	 /**
	 * @param tipo
	 * @return devuelve true si todos los pacientes son del tipo
	 */
	Boolean todosPacienteSonDelTipo(TipoResidencia tipo);
	 /**
	 * @param tipo
	 * @return devuelve true si existe algún paciente del tipo
	 */
	Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo);
	 //contador, suma, media
	 /**
	 * @return devuelve el número de pacientes con factor de riesgo
	 */
	Integer numeroPacientesFactorRiesgo();
	 /**
	 * @return devuelve la edad media de los pacientes con factor de riesgo de tipo Double
	 */
	Double edadMediaPacientesConFactorRiesgo();
	 //filtrado
	 /**
	 * @param edad
	 * @return devuelve una lista filtrando de tipo PacienteEstudio pacientes por edad
	 */
	List<PacienteEstudio> filtraPacientesPorEdad(Double edad);
	 //devuelve Map que agrupa
	 /**
	 * @param edad
	 * @return devuelve un map agrupando pacientes de edad mayor por genero
	 */
	Map<String,List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad);
	 //devuelve Map que realiza un cálculo
	 /**
	 * @return devuelve un map con el número de pacientes por genero
	 */
	Map<String,Long> numeroPacientesPorGenero();
	 /**
	 * @return devuelve un map con la edad media de los pacientes por género
	 */
	Map<String,Double> edadMediaPacientesPorPorGenero();
	}

