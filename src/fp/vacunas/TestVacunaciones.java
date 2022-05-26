package fp.vacunas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestVacunaciones {

	public static void main(String[] args) {
		//
		Vacunaciones vacunacionesSt = FactoriaVacunaciones.leeFicheroSt("./data/ccaa_vacunas_3.csv");
		
		System.out.println("testVacunacionesEntreFechas");
		testVacunacionesEntreFechas(vacunacionesSt, LocalDate.of(2021, 1, 7), LocalDate.of(2021, 1, 9));
		
		System.out.println("vacunacionesPorFecha");
		testVacunacionesPorFecha(vacunacionesSt);
		
		System.out.println("existeNumPersonasPautaCompletaPorEncimaDe");
		testExisteNumPersonasPautaCompletaPorEncimaDe(vacunacionesSt, "Andalucía", 20);
		
		System.out.println("diaMasVacunacionesEn");
		testDiaMasVacunacionesEn(vacunacionesSt, "Andalucía");
		
		System.out.println(" maximoNumTotalVacunasporComunidad");
		 testMaximoNumTotalVacunasporComunidad(vacunacionesSt);

	}

	private static void testMaximoNumTotalVacunasporComunidad(Vacunaciones vacunacionesSt) {
		//
		  try {
			  System.out.println(vacunacionesSt.maximoNumTotalVacunasporComunidad());
			  } catch (Exception e) {
			  System.err.println("Capturada excepción inesperada: " + e.getMessage());
			  }			
		
	}

	private static void testDiaMasVacunacionesEn(Vacunaciones vacunacionesSt, String comunidad) {
		//
		  try {
			  System.out.println(vacunacionesSt.diaMasVacunacionesEn(comunidad));
			  } catch (Exception e) {
			  System.err.println("Capturada excepción inesperada: " + e.getMessage());
			  }			
		
	}

	private static void testExisteNumPersonasPautaCompletaPorEncimaDe(Vacunaciones vacunacionesSt, String comunidad,
			Integer valorDado) {
		//
		  try {
			  System.out.println(vacunacionesSt.existeNumPersonasPautaCompletaPorEncimaDe(comunidad, valorDado));
			  } catch (Exception e) {
			  System.err.println("Capturada excepción inesperada: " + e.getMessage());
			  }		
		
	}

	private static void testVacunacionesPorFecha(Vacunaciones vacunacionesSt) {
		//
		try {
			System.out.println("Primera y última vacunación de cada fecha");
			Map<LocalDate, List<Vacunacion>> res = new HashMap<>();
			Map<LocalDate, List<Vacunacion>> dicc = vacunacionesSt.vacunacionesPorFecha();
			for(Map.Entry<LocalDate, List<Vacunacion>> pair:dicc.entrySet()) {
				List<Vacunacion> lista = pair.getValue();
				List<Vacunacion> l1= lista.subList(0, 1);
				List<Vacunacion> l2= lista.subList(lista.size()-2, lista.size()-1);
				List<Vacunacion> l3 = new ArrayList<>();
				l3.addAll(l1);
				l3.addAll(l2);
				for(Vacunacion v:l3) {
					LocalDate clave = v.fecha();
					if(!res.containsKey(clave)) {
						List<Vacunacion> lista1 = new ArrayList<Vacunacion>();
						lista1.add(v);
						res.put(clave, lista1);
					} else {
						res.get(clave).add(v);
					}
				}
		}
			System.out.println(res);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
		
	}
		


	private static void testVacunacionesEntreFechas(Vacunaciones vacunacionesSt, LocalDate a, LocalDate b) {
		//
		  try {
			  System.out.println(vacunacionesSt.vacunacionesEntreFechas(a, b));
			  } catch (Exception e) {
			  System.err.println("Capturada excepción inesperada: " + e.getMessage());
			  }
		
	}

}
