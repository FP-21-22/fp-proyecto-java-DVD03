package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author David Vargas Muñiz
 *
 */
public class EstudioClinicoBucles implements EstudioClinico {

	private List<PacienteEstudio> pacienteEstudioLista;
	
	public EstudioClinicoBucles() {
		pacienteEstudioLista = new ArrayList<PacienteEstudio>();
	}
	
	public EstudioClinicoBucles(List<PacienteEstudio> pacienteEstudioLista) {
		this.pacienteEstudioLista = new ArrayList<PacienteEstudio>(pacienteEstudioLista);
	}
	
	@Override
	public Integer numeroPacientes() {
		//
		return pacienteEstudioLista.size();
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		//
		this.pacienteEstudioLista.add(paciente);

	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		//
		this.pacienteEstudioLista.addAll(pacientes);

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		//
		pacienteEstudioLista.remove(paciente);

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		//
		return pacienteEstudioLista.contains(paciente);
	}

	@Override
	public void borraEstudio() {
		//
		this.pacienteEstudioLista.clear();

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
		//
		List<PacienteEstudio> res = new ArrayList<PacienteEstudio>();
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String e:aux) {
			PacienteEstudio paciente = PacienteEstudio.parse(e);
			res.add(paciente);
		}
		return res;
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		//
		Boolean res  = true;
		for(PacienteEstudio paciente: pacienteEstudioLista) {
			if(!paciente.tipoDeResidencia().equals(tipo)) {
				res = false;
				break;
			}else {
				res = true;
			}
		}
		return res;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		//
		Boolean res  = true;
			for(PacienteEstudio paciente: pacienteEstudioLista) {
				if(paciente.tipoDeResidencia().equals(tipo)) {
					res = true;
					break;
				}else {
					res = false;
				}
			}
			return res;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		//
		Integer cont= 0;
		for(PacienteEstudio paciente: this.pacienteEstudioLista) {
			if(paciente.factorDeRiesgo()) {
				cont++;
			}
		}
		return cont;
	}

	//Método auxiliar para obtener la suma de las edades con factor de riesgo
	public Double sumaEdadesRiesgo() {
		Double sumaEdadesRiesgo = 0.0;
			for(PacienteEstudio paciente:pacienteEstudioLista) {
				if(paciente.factorDeRiesgo()) {
					sumaEdadesRiesgo+=paciente.edad();
				}
			}
			return sumaEdadesRiesgo;
	}
	
	
	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		//
		Double media = 0.0;
		for(PacienteEstudio paciente: this.pacienteEstudioLista) {
			if(paciente.factorDeRiesgo()) {
				media = sumaEdadesRiesgo()/numeroPacientesFactorRiesgo();
			}
		}
		return media;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// 
		List<PacienteEstudio> listaFiltrada = new ArrayList<PacienteEstudio>();
		for(PacienteEstudio paciente: this.pacienteEstudioLista) {
			if(paciente.edad().equals(edad)) {
				listaFiltrada.add(paciente);
			}
		}
		return listaFiltrada;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		//
		Map<String, List<PacienteEstudio>> res = new HashMap<String, List<PacienteEstudio>>();
		PacienteEstudio paciente2 = null;
		for(PacienteEstudio paciente:pacienteEstudioLista) {
			if(paciente2 == null || paciente.edad()>paciente2.edad()) {
				paciente2 = paciente;
			}
			String clave = paciente.genero();
			if(!res.containsKey(clave)) {
				List<PacienteEstudio> lista = new ArrayList<PacienteEstudio>();
				lista.add(paciente2);
				res.put(clave, lista);
				break;
			} else {
				res.get(clave).add(paciente2);
			}
		}
		return res;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		//
		Map<String, Long> res = new HashMap<String, Long>();
		for(PacienteEstudio paciente: pacienteEstudioLista) {
			String clave = paciente.genero();
				if(res.containsKey(clave)) {
					res.put(clave, res.get(clave)+1);
				} else {
					res.put(clave, 1L);
				}
		}
		return res;
	}


//	//Métodos auxiliares para sumar edades por género
	public Double sumaEdadesMale() {
		Double sumaEdadesMale = 0.0;
		for(PacienteEstudio paciente:pacienteEstudioLista) {
			if(paciente.genero().equals("Male")) {
				sumaEdadesMale+=paciente.edad();
			}
		}
		return sumaEdadesMale;
		
	}
	
	public Double sumaEdadesFemale() {
		Double sumaEdadesFemale = 0.0;
		for(PacienteEstudio paciente:pacienteEstudioLista) {
			if(paciente.genero().equals("Female")) {
				sumaEdadesFemale+=paciente.edad();
			}
		}
		return sumaEdadesFemale;
		
	}
	
	public Double sumaEdadesOther() {
		Double sumaEdadesOther = 0.0;
		for(PacienteEstudio paciente:pacienteEstudioLista) {
			if(paciente.genero().equals("Other")) {
				sumaEdadesOther+=paciente.edad();
			}
		}
		return sumaEdadesOther;
		
	}
//	
//	//Métodos auxiliares para obtener número de pacientes por género
	public Integer numeroPacientesMale() {
		//
		Integer cont= 0;
		for(PacienteEstudio paciente: this.pacienteEstudioLista) {
			if(paciente.genero().equals("Male")) {
				cont++;
			}
		}
		return cont;
	}
	public Integer numeroPacientesFemale() {
		//
		Integer cont= 0;
		for(PacienteEstudio paciente: this.pacienteEstudioLista) {
			if(paciente.genero().equals("Female")) {
				cont++;
			}
		}
		return cont;
	}
	public Integer numeroPacientesOther() {
		//
		Integer cont= 0;
		for(PacienteEstudio paciente: this.pacienteEstudioLista) {
			if(paciente.genero().equals("Other")) {
				cont++;
			}
		}
		return cont;
	}
	
	

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero(){
		//
		Integer pacientesMale = numeroPacientesMale();
		Integer pacientesFemale = numeroPacientesFemale();
		Integer pacientesOther = numeroPacientesOther();
		Double sumaMale = sumaEdadesMale();
		Double sumaFemale = sumaEdadesFemale();
		Double sumaOther = sumaEdadesOther();
		Map<String, Double> res = new HashMap<String, Double>();
		for(PacienteEstudio paciente:pacienteEstudioLista) {
			String clave = paciente.genero();
			if(res.containsKey(clave)) {
				if(clave.equals("Male")) {
					res.put(clave, (sumaMale/pacientesMale));
				}else if(clave.equals("Female")) {
					res.put(clave, (sumaFemale/(pacientesFemale)));
				}else if(clave.equals("Other")) {
					res.put(clave, sumaOther/(pacientesOther));
				}
				
			} else {
			res.put(clave, 1.0);
		}

		}
		return res;
	
	}
		

}
