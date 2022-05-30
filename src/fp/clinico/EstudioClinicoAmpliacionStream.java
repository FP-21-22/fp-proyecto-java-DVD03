package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstudioClinicoAmpliacionStream extends EstudioClinicoStream implements EstudioClinicoAmpliacion {
	
	public EstudioClinicoAmpliacionStream() {
		super();
	}
	public EstudioClinicoAmpliacionStream(List<PacienteEstudio> pacienteEstudioLista) {
		super(pacienteEstudioLista);
	}
	public EstudioClinicoAmpliacionStream(Stream<PacienteEstudio>st) {
		super(st);
	}
	
	//Métodos
	@Override
	public Map<TipoResidencia, Integer> agruparNumeroPacientesPorTipoResidencia() {
		//
		return super.pacienteEstudioLista.stream().
				collect(Collectors.groupingBy(
						PacienteEstudio::tipoDeResidencia,
						Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
						));
	}

	@Override
	public Map<TipoResidencia, Double> agruparNivelMedioGlucosaMedioPorTipoResidencia() {
		//
		return super.pacienteEstudioLista.stream().
				collect(Collectors.
						toMap(PacienteEstudio::tipoDeResidencia, 
								PacienteEstudio::nivelMedioGlucosa));
	}

	@Override
	public Map<TipoResidencia, PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia() {
		//
		return super.pacienteEstudioLista.stream().
				collect(Collectors.groupingBy(PacienteEstudio::tipoDeResidencia, 
						Collectors.collectingAndThen(Collectors.
								maxBy(Comparator.comparing(PacienteEstudio::nivelMedioGlucosa)), 
								x->x.orElse(null))));
	}

	@Override
	public Map<String, List<PacienteEstudio>> agrupaPacientesPorGenero() {
		//
		return super.pacienteEstudioLista.stream().
				collect(Collectors.groupingBy(PacienteEstudio::genero));
	}

	@Override
	public Map<String, Set<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjunto() {
		//
		return super.pacienteEstudioLista.stream().
				collect(Collectors.groupingBy(PacienteEstudio::genero, 
						Collectors.toSet()));
	}

	@Override
	public Map<String, SortedSet<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjuntoOrdenado() {
		//
		return super.pacienteEstudioLista.stream().
				sorted(Comparator.comparing(PacienteEstudio::genero)).
				collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.toCollection(TreeSet::new)));
	}

	@Override
	public Map<String, PacienteEstudio> pacienteEdadMaximaPacientesPorGenero() {
		//
		return super.pacienteEstudioLista.stream().
				collect(Collectors.groupingBy(
						PacienteEstudio::genero, 
						Collectors.collectingAndThen(Collectors.maxBy(
								Comparator.comparing(PacienteEstudio::edad)), 
								x->x.orElse(null))));
	}

	@Override
	public Map<String, List<Double>> listaEdadesPorGenero() {
		//
		return super.pacienteEstudioLista.stream().
				collect(Collectors.groupingBy(PacienteEstudio::genero,
						Collectors.mapping(PacienteEstudio::edad, Collectors.toList())));
	}

	@Override
	public Map<String, Double> edadMaximaPacientesPorGenero() {
		//
		return super.pacienteEstudioLista.stream().
				collect(Collectors.groupingBy(
						PacienteEstudio::genero, 
						Collectors.collectingAndThen(Collectors.maxBy(
								Comparator.comparing(PacienteEstudio::edad)), 
								x->x.get().edad())));
	}

	@Override
	public String generoEdadMaximaPacientesPorGenero() {
		//
		return super.pacienteEstudioLista.stream().
				collect(Collectors.groupingBy(PacienteEstudio::genero,
						Collectors.collectingAndThen(Collectors.maxBy(
								Comparator.comparing(PacienteEstudio::edad)), 
								x->x.get()))).toString();
	}


	//Para test
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
	public EstudioClinicoAmpliacion of1(String nombreFichero) {
		//
		List<PacienteEstudio> aux = leeFichero(nombreFichero);
		EstudioClinicoAmpliacion es = new EstudioClinicoAmpliacionStream(aux);
		return es;
	}
	

	
	}