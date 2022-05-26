package fp.farmaceutico;

import java.time.LocalDate;

public class TestListadoMedicamentos {

	public static void main(String[] args) {
		//
		ListadoMedicamentos listadoMedicamentosSt = FactoriaMedicamentos2.leeFicheroStM("./data/medicamentos.csv");
		
		System.out.println("existeMedicamentoSegunTipoAnteriorA");
		testExisteMedicamentoSegunTipoAnteriorA(listadoMedicamentosSt, TipoMedicamento.ANATOMICO, LocalDate.of(2019, 12, 6));
		
		System.out.println("nombreMedicamentosPuntuacionMayorA");
		testNombreMedicamentosPuntuacionMayorA(listadoMedicamentosSt, 90.0);
		
		System.out.println("nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento");
		testNombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(listadoMedicamentosSt, TipoMedicamento.ANATOMICO);
		
		System.out.println("agrupaTipoMedicamentoSegunPuntuacionMedia");
		testAgrupaTipoMedicamentoSegunPuntuacionMedia(listadoMedicamentosSt);
		
		System.out.println("fechaCatalogoMasFrecuente");
		testFechaCatalogoMasFrecuente(listadoMedicamentosSt);

	}

	private static void testFechaCatalogoMasFrecuente(ListadoMedicamentos listadoMedicamentosSt) {
		//
		  try {
			  System.out.println(listadoMedicamentosSt.fechaCatalogoMasFrecuente());
			  } catch (Exception e) {
			  System.err.println("Capturada excepción inesperada: " + e.getMessage());
			  }			
		
	}

	private static void testAgrupaTipoMedicamentoSegunPuntuacionMedia(ListadoMedicamentos listadoMedicamentosSt) {
		//
		  try {
			  System.out.println(listadoMedicamentosSt.agrupaTipoMedicamentoSegunPuntuacionMedia());
			  } catch (Exception e) {
			  System.err.println("Capturada excepción inesperada: " + e.getMessage());
			  }			
		
	}

	private static void testNombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(
			ListadoMedicamentos listadoMedicamentosSt, TipoMedicamento tipoDeMedicamento) {
		//
		  try {
			  System.out.println(listadoMedicamentosSt.nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(tipoDeMedicamento));
			  } catch (Exception e) {
			  System.err.println("Capturada excepción inesperada: " + e.getMessage());
			  }	
		
	}

	private static void testNombreMedicamentosPuntuacionMayorA(ListadoMedicamentos listadoMedicamentosSt, Double puntuacionDada) {
		//
		  try {
			  System.out.println(listadoMedicamentosSt.nombreMedicamentosPuntuacionMayorA(puntuacionDada));
			  } catch (Exception e) {
			  System.err.println("Capturada excepción inesperada: " + e.getMessage());
			  }			
		
	}

	private static void testExisteMedicamentoSegunTipoAnteriorA(ListadoMedicamentos listadoMedicamentosSt,
			TipoMedicamento tipoDeMedicamento, LocalDate fechaDada) {
		//
		  try {
			  System.out.println(listadoMedicamentosSt.existeMedicamentoSegunTipoAnteriorA(tipoDeMedicamento, fechaDada));
			  } catch (Exception e) {
			  System.err.println("Capturada excepción inesperada: " + e.getMessage());
			  }	
		
	}

}
