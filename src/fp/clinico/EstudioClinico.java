package fp.clinico;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author David Vargas Mu�iz
 *
 */
public interface EstudioClinico{
	 // Propiedades de lista
	 /**
	 * @return n�mero de pacientes
	 */
	Integer numeroPacientes();
	/**
	 * @param paciente, a�ade paciente a la lista pacienteEstudioLista
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
	 * @param paciente, pasa el par�metro paciente del tipo PacienteEstudio
	 * @return devuelve true si la lista contiene paciente y por el contrario false si no lo contiene
	 */
	Boolean estaPaciente(PacienteEstudio paciente);
	void borraEstudio();
	 //
	 // M�todo de factor�a
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
	 // Tratamientos secuenciales: implementaci�nn funcional vs. imperativa
	 //existe, paraTodo
	 /**
	 * @param tipo
	 * @return devuelve true si todos los pacientes son del tipo
	 */
	Boolean todosPacienteSonDelTipo(TipoResidencia tipo);
	 /**
	 * @param tipo
	 * @return devuelve true si existe alg�n paciente del tipo
	 */
	Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo);
	 //contador, suma, media
	 /**
	 * @return devuelve el n�mero de pacientes con factor de riesgo
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
	 //devuelve Map que realiza un c�lculo
	 /**
	 * @return devuelve un map con el n�mero de pacientes por genero
	 */
	Map<String,Long> numeroPacientesPorGenero();
	 /**
	 * @return devuelve un map con la edad media de los pacientes por g�nero
	 */
	Map<String,Double> edadMediaPacientesPorPorGenero();
	}

