package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

/**
 * @author David Vargas Muñiz
 *
 */
public class Medicamento {
	//Atributos
	private String nombreMedicamento;
	private TipoMedicamento tipoDeMedicamento;
	private String codigoEnfermedad;
	private String farmaceutica;
	private Double puntuacion;
	private Integer indiceSomatico;
	private LocalDate fechaCatalogo;
	
	//Constructores
	/**
	 * @param nombreMedicamento: String
	 * @param tipoDeMedicamento: TipoMedicamento
	 * @param codigoEnfermedad: String
	 * @param farmaceutica: String
	 * @param puntuacion: Double
	 * @param indiceSomatico: Integer
	 * @param fechaCatalogo: LocalDate
	 */
	public Medicamento(String nombreMedicamento, TipoMedicamento tipoDeMedicamento, String codigoEnfermedad, String farmaceutica, 
			Double puntuacion, Integer indiceSomatico, LocalDate fechaCatalogo) {
		//Restricciones
		Checkers.check("La puntación tiene que ser mayor estricta que cero", puntuacion>=0);
		Checkers.check("El índice somático tiene que ser mayor o igual que 1000", indiceSomatico>=1000);
		LocalDate fecha = LocalDate.of(2015, 01, 01);
		Checkers.check("La fecha de catálogo tiene que ser posterior al 01/01/2015", (fechaCatalogo.isAfter(fecha)));
		
		this.nombreMedicamento = nombreMedicamento;
		this.tipoDeMedicamento = tipoDeMedicamento;
		this.codigoEnfermedad = codigoEnfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaCatalogo = fechaCatalogo;
		
	}
	
	//Propiedad derivada
	/**
	 * @param text: String
	 * @return Devuelve tratarEnfermedad a partir de codigoEnfermedad y el parametro
	 */
	public Boolean tratarEnfermedad(String text) {
		Boolean res = null;
		if(codigoEnfermedad==text) {
			res = true;
		}
		return res;
	}
	
	
	//Métodos de las propiedades
	public LocalDate getFechaCatalogo() {
		return fechaCatalogo;
	}

	public void setFechaCatalogo(LocalDate fechaCatalogo) {
		this.fechaCatalogo = fechaCatalogo;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public String getCodigoEnfermedad() {
		return codigoEnfermedad;
	}

	public String getFarmaceutica() {
		return farmaceutica;
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}

	public TipoMedicamento getTipoDeMedicamento() {
		return tipoDeMedicamento;
	}
	
	
	//Métodos adicionales
	//a)Representación como cadena
	@Override
	public String toString() {
		return "Medicamento [nombreMedicamento=" + nombreMedicamento + ", farmaceutica=" + farmaceutica + "]";
	}
	//b)Criterio de igualdad
	@Override
	public int hashCode() {
		return Objects.hash(farmaceutica, nombreMedicamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(farmaceutica, other.farmaceutica)
				&& Objects.equals(nombreMedicamento, other.nombreMedicamento);
	}
	//c)Orden natural
	public int compareTo(Medicamento o) {
		int res = this.getNombreMedicamento().compareTo(o.getNombreMedicamento());
		if(res==0) {
			res = this.getFarmaceutica().compareTo(o.getFarmaceutica());
		}
		return res;
	}
	
	
	
	

}
