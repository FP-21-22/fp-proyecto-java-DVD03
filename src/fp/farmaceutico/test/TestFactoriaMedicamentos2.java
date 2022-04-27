package fp.farmaceutico.test;

import java.util.List;

import fp.farmaceutico.FactoriaMedicamentos2;
import fp.farmaceutico.Medicamento;

/**
 * @author David Vargas Muñiz
 *
 */
public class TestFactoriaMedicamentos2 {

	public static void main(String[] args) {
		//
		String ruta = "./data/medicamentos.csv";
		List<Medicamento> lista = FactoriaMedicamentos2.leeFichero(ruta);
		for(Medicamento e:lista) {
			System.out.println(e);
		}
		}

	}


