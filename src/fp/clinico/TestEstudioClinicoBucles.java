package fp.clinico;


/**
 * @author David Vargas Muñiz
 *
 */
public class TestEstudioClinicoBucles {

	public static void main(String[] args) {
		//
		EstudioClinico est = new EstudioClinicoBucles();
		
		est.of("./data/estudio_clinico.csv");
		
		
		System.out.println("--- numeroPacientesTest ---");
		System.out.println(est.of("./data/estudio_clinico.csv").numeroPacientes());
		
		System.out.println("--- todosPacienteSonDelTipoTest ---");
		System.out.println(est.of("./data/estudio_clinico.csv").todosPacienteSonDelTipo(TipoResidencia.URBANA));
		
		System.out.println("--- existeAlgunPacienteDelTipo ---");
		System.out.println(est.of("./data/estudio_clinico.csv").existeAlgunPacienteDelTipo(TipoResidencia.RURAL));
		
		System.out.println("--- numeroPacientesFactorRiesgo ---");
		System.out.println(est.of("./data/estudio_clinico.csv").numeroPacientesFactorRiesgo());
		
		System.out.println("--- edadMediaPacientesConFactorRiesgo ---");
		System.out.println(est.of("./data/estudio_clinico.csv").edadMediaPacientesConFactorRiesgo());
		
		System.out.println("--- filtraPacientesPorEdad ---");
		System.out.println(est.of("./data/estudio_clinico.csv").filtraPacientesPorEdad(41.0));
		
		System.out.println("--- agruparPacientesEdadMayorQuePorGenero ---");
		System.out.println(est.of("./data/estudio_clinico.csv").agruparPacientesEdadMayorQuePorGenero(30.0));
		
		System.out.println("--- numeroPacientesPorGenero ---");
		System.out.println(est.of("./data/estudio_clinico.csv").numeroPacientesPorGenero());
		
		System.out.println("--- edadMediaPacientesPorPorGenero ---");
		System.out.println(est.of("./data/estudio_clinico.csv").edadMediaPacientesPorPorGenero());
		


	}

		
	}
	



