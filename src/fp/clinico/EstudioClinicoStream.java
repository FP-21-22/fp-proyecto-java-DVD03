package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;




/**
 * @author David Vargas Muñiz
 *
 */
public class EstudioClinicoStream implements EstudioClinico {
	
	private List<PacienteEstudio> pacienteEstudioLista;
//	
	public EstudioClinicoStream() {
		pacienteEstudioLista = new ArrayList<PacienteEstudio>();
	}
	
	public EstudioClinicoStream(Stream<PacienteEstudio>st) {
		this.pacienteEstudioLista = st.collect(Collectors.toList());
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
		this.pacienteEstudioLista.stream().
		filter(x -> pacienteEstudioLista.add(paciente));
	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		//
		this.pacienteEstudioLista.stream().
		filter(x -> pacienteEstudioLista.addAll(pacientes))
		.collect(Collectors.toList());

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		//
		this.pacienteEstudioLista.stream().
		filter(x -> pacienteEstudioLista.remove(paciente));

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		//
		return pacienteEstudioLista.stream().
				anyMatch(pacienteEstudio -> pacienteEstudioLista.contains(paciente));
		
	}

	@Override
	public void borraEstudio() {
		//
		this.pacienteEstudioLista.stream().
		filter(x -> pacienteEstudioLista.removeAll(pacienteEstudioLista));

	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		//
		List<PacienteEstudio> aux = leeFichero(nombreFichero);
		EstudioClinico es = new EstudioClinicoStream(aux);
		return es;
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		//
		List<PacienteEstudio> res = new ArrayList<>();
		try {
			res = Files.lines(Paths.get(nombreFichero)).
					map(PacienteEstudio::parse).
					collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;


	}
	//Parser
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
	//

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		//
		return pacienteEstudioLista.stream().
				allMatch(x->x.tipoDeResidencia().equals(tipo));
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		//
		return pacienteEstudioLista.stream().
				anyMatch(x -> x.tipoDeResidencia().equals(tipo));
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		//
		Long res = this.pacienteEstudioLista.stream().
				filter(x->x.factorDeRiesgo()).
				count();
		return res.intValue();
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		//
		return this.pacienteEstudioLista.stream().
				filter(x->x.factorDeRiesgo()).
				mapToDouble(x->x.edad()).
				average().orElse(0);
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		//
		return this.pacienteEstudioLista.stream()
				.filter(x->x.edad().equals(edad)).
				collect(Collectors.toList());
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		//
		return this.pacienteEstudioLista.stream().
										filter(x->x.edad().compareTo(edad)>0).
										collect(Collectors.groupingBy(PacienteEstudio::genero));
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		//

		return this.pacienteEstudioLista.stream().
				collect(Collectors.groupingBy(
						PacienteEstudio::genero, 
						Collectors.counting()));
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		//
		return this.pacienteEstudioLista.stream().
		collect(Collectors.groupingBy(
				PacienteEstudio::genero, 
				Collectors.averagingDouble(PacienteEstudio::edad)));
	}

}
