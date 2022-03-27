package fp.farmaceutico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author David Vargas Muñiz
 *
 */
public class FactoriaMedicamentos extends Medicamento{

	
	public FactoriaMedicamentos(String nombreMedicamento, TipoMedicamento tipoDeMedicamento, String codigoEnfermedad,
			String farmaceutica, Double puntuacion, Integer indiceSomatico, LocalDate fechaCatalogo) {
		super(nombreMedicamento, tipoDeMedicamento, codigoEnfermedad, farmaceutica, puntuacion, indiceSomatico, fechaCatalogo);
		// TODO Auto-generated constructor stub
	}

		
	//Método static parse
	public static FactoriaMedicamentos parse(String text) {
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
		FactoriaMedicamentos FM = new FactoriaMedicamentos (nombreMedicamento, tipoDeMedicamento, codigoEnfermedad, farmaceutica, puntuacion, indiceSomatico, fechaCatalogo);
		return FM;
	}

}
