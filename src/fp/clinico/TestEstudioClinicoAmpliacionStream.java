package fp.clinico;


public abstract class TestEstudioClinicoAmpliacionStream {

	public static void main(String[] args) {
		//
		EstudioClinicoAmpliacionStream est = new EstudioClinicoAmpliacionStream();
		est.of1("./data/estudio_clinico.csv");
		
		System.out.println("--- agruparNumeroPacientesPorTipoResidenciaTest ---");
		System.out.println(est.of1("./data/estudio_clinico.csv").agruparNumeroPacientesPorTipoResidencia());
		
//		System.out.println("--- agruparNivelMedioGlucosaMedioPorTipoResidenciaTest ---");
//		System.out.println(est.of1("./data/estudio_clinico.csv").agruparNivelMedioGlucosaMedioPorTipoResidencia());
		
		System.out.println("--- agruparNivelMedioGlucosaMaximoPorTipoResidenciaTest ---");
		System.out.println(est.of1("./data/estudio_clinico.csv").agruparNivelMedioGlucosaMaximoPorTipoResidencia());
		
//		System.out.println("--- agrupaPacientesPorGeneroTest ---");
//		System.out.println(est.of1("./data/estudio_clinico.csv").agrupaPacientesPorGenero());
//		
//		System.out.println("--- agrupaPacientesPorPorGeneroEnConjuntoTest ---");
//		System.out.println(est.of1("./data/estudio_clinico.csv").agrupaPacientesPorPorGeneroEnConjunto());
//		
//		System.out.println("--- agrupaPacientesPorPorGeneroEnConjuntoOrdenadoTest ---");
//		System.out.println(est.of1("./data/estudio_clinico.csv").agrupaPacientesPorPorGeneroEnConjuntoOrdenado());
//		
		System.out.println("--- pacienteEdadMaximaPacientesPorGeneroTest ---");
		System.out.println(est.of1("./data/estudio_clinico.csv").pacienteEdadMaximaPacientesPorGenero());
//		
//		System.out.println("--- listaEdadesPorGeneroTest ---");
//		System.out.println(est.of1("./data/estudio_clinico.csv").listaEdadesPorGenero());
//		
		System.out.println("--- edadMaximaPacientesPorGeneroTest ---");
		System.out.println(est.of1("./data/estudio_clinico.csv").edadMaximaPacientesPorGenero());
//		
		System.out.println("--- generoEdadMaximaPacientesPorGeneroTest ---");
		System.out.println(est.of1("./data/estudio_clinico.csv").generoEdadMaximaPacientesPorGenero());
		
	}
		

}
