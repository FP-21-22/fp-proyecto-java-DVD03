package fp.clinico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author David Vargas Muñiz
 *
 */
public class EstudioClinicoStream implements EstudioClinico {
	
	private List<PacienteEstudio> pacienteEstudioLista;
	
	public EstudioClinicoStream() {
		pacienteEstudioLista = new ArrayList<PacienteEstudio>();
	}
	
	public EstudioClinicoStream(List<PacienteEstudio> pacienteEstudioLista) {
		this.pacienteEstudioLista = new ArrayList<PacienteEstudio>(pacienteEstudioLista);
	}
	

	@Override
	public Integer numeroPacientes() {
		//
		long numeroPacientes = pacienteEstudioLista.stream().count();
		int numeroPacientesInt = (int)numeroPacientes;  //para parsear long a int
		return numeroPacientesInt;
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		//
		this.pacienteEstudioLista.stream().filter(x -> pacienteEstudioLista.add(paciente));
	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		//
		this.pacienteEstudioLista.stream().filter(x -> pacienteEstudioLista.addAll(pacientes)).collect(Collectors.toList());

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		//
		this.pacienteEstudioLista.stream().filter(x -> pacienteEstudioLista.remove(paciente));

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		//
		Boolean estaPaciente = pacienteEstudioLista.stream().anyMatch(pacienteEstudio -> pacienteEstudioLista.contains(paciente));
		return estaPaciente;
	}

	@Override
	public void borraEstudio() {
		//
		this.pacienteEstudioLista.stream().filter(x -> pacienteEstudioLista.removeAll(pacienteEstudioLista));

	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		//
		List<PacienteEstudio> aux = leeFichero(nombreFichero);
		EstudioClinico es = new EstudioClinicoBucles(aux);
		return es;
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		// TODO Auto-generated method stub, siguiente entrega
		return null;
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

}
