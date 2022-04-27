package fp.vacunas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;




/**
 * @author David Vargas Muñiz
 *
 */
public class FactoriaVacunaciones {
	public static List<Vacunacion> leeFichero(String nombreFichero) {
		//
		List<Vacunacion> res = new ArrayList<Vacunacion>();
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cont = 0;
		for(String e:aux) {
			if(cont>0) {
			Vacunacion v = FactoriaVacunaciones.parse(e);
			res.add(v);
			}
			cont++;
		}
		return res;
	}
	
	public static Vacunacion parse(String text) {
		String[] sp = text.split(";");
		if (sp.length != 7) {
			throw new IllegalArgumentException(
				"Cadena con formato no válido");
		}
		LocalDate Fecha_publicación = LocalDate.parse(sp[0].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String CCAA = sp[1].trim();
		Integer Personas_pauta_completa = Integer.parseInt(sp[6].trim());
		Integer Pfizer = Integer.parseInt(sp[2].trim());
		Integer Moderna = Integer.parseInt(sp[3].trim());
		Integer Astrazeneca = Integer.parseInt(sp[4].trim());
		Integer Janssen = Integer.parseInt(sp[5].trim());
		return Vacunacion.of(Fecha_publicación, CCAA, Personas_pauta_completa, Pfizer, Moderna, Astrazeneca, Janssen);
	}

}
