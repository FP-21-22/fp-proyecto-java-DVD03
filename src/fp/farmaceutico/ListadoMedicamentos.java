package fp.farmaceutico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.vacunas.Vacunacion;




/**
 * @author David Vargas Muñiz
 *
 */
public class ListadoMedicamentos {
	
	//Atributos
	private List<Medicamento> listadoMedicamentos;
	
	//Constructor
	public ListadoMedicamentos(Stream<Medicamento>st) {
		this.listadoMedicamentos = st.collect(Collectors.toList());
	}
	
	public ListadoMedicamentos(Collection<Medicamento>listadoMedicamentos) {
		this.listadoMedicamentos = new ArrayList<Medicamento>(listadoMedicamentos);
	}
	
	//Métodos
	public Boolean existeMedicamentoSegunTipoAnteriorA(TipoMedicamento tipoDeMedicamento, LocalDate fechaDada) {
		return this.listadoMedicamentos.stream().
				anyMatch(x->x.getTipoDeMedicamento().equals(tipoDeMedicamento) && x.getFechaCatalogo().isAfter(fechaDada));
		
	}
	
	public Set<String> nombreMedicamentosPuntuacionMayorA(Double puntuacionDada){
		return this.listadoMedicamentos.stream().
				filter(x->x.getPuntuacion()>puntuacionDada).
				map(Medicamento::getNombreMedicamento).
				collect(Collectors.toSet());
	}
	
	public String nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento tipoDeMedicamento) {
		return this.listadoMedicamentos.stream().
				collect(Collectors.
						groupingBy(Medicamento::getNombreMedicamento, 
								Collectors.collectingAndThen(Collectors.
										maxBy(Comparator.comparing(Medicamento::getIndiceSomatico)),
										x->x.get()))). 
				toString();
	}
	
	public Map<TipoMedicamento, Double> agrupaTipoMedicamentoSegunPuntuacionMedia(){
		return this.listadoMedicamentos.stream().
				collect(Collectors.
						groupingBy(Medicamento::getTipoDeMedicamento, 
								Collectors.averagingDouble(x->x.getPuntuacion())));
	}
	
	public LocalDate fechaCatalogoMasFrecuente() {
		//Esto es lo mismo que la fechaCatalogo con más medicamentos, pues sería la que en más medicamentos aparece
		//1ª)Construimos un mapa auxiliar: asocia medicamentos y fechaCatalogo
		Map<LocalDate, Long> mapaAux = this.listadoMedicamentos.stream().
				collect(Collectors.groupingBy(
						Medicamento::getFechaCatalogo, 
						Collectors.counting()
						));
		//2ª)Recorriendo ese mapa auxliar calculamos el máximo
		Comparator<Map.Entry<LocalDate, Long>> cmp = (x,y)->x.getValue().
				compareTo(y.getValue());
		return mapaAux.entrySet().stream().
				max(cmp).
				get().
				getKey();
	}

}
