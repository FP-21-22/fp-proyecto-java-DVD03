package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



/**
 * @author David Vargas Muñiz
 *
 */
public class FactoriaMedicamentos2 {
	public static List<Medicamento> leeFichero(String nombreFichero) {
		//
		List<Medicamento> res = new ArrayList<Medicamento>();
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
			Medicamento m = FactoriaMedicamentos2.parse(e);
			res.add(m);
			}
			cont++;
		}
		return res;
	}
	
	public static ListadoMedicamentos leeFicheroStM(String nombreFichero){
		  ListadoMedicamentos res=null;
		  try {
		  List<Medicamento> medicamentoss=Files.lines(Paths.get(nombreFichero))
		  .skip(1)
		  .map(FactoriaMedicamentos2::parse)
		  .collect(Collectors.toList());

		  res=new ListadoMedicamentos(medicamentoss);
		  } catch(IOException e) {
		  System.out.println("Fichero no encontrado: "+nombreFichero);
		  e.printStackTrace();
		  }
		  return res;
	}
	
	public static Medicamento parse(String text) {
		String[] sp = text.split(",");
		if (sp.length != 7) {
			throw new IllegalArgumentException(
				"Cadena con formato no válido");
		}
		String nombreMedicamento = sp[0].trim();
		TipoMedicamento tipoDeMedicamento = TipoMedicamento.valueOf(sp[1].toUpperCase());
		String codigoEnfermedad = sp[2].trim();
		String farmaceutica = sp[3].trim();
		Double puntuacion = Double.parseDouble(sp[4].trim());
		Integer indiceSomatico = Integer.parseInt(sp[5].trim());
		LocalDate fechaCatalogo = LocalDate.parse(sp[6].trim(),DateTimeFormatter.ofPattern("d/M/y"));
		Medicamento FM = new Medicamento (nombreMedicamento, tipoDeMedicamento, codigoEnfermedad, farmaceutica, puntuacion, indiceSomatico, fechaCatalogo);
		return FM;
	}

}
