package fp.vacunas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;




/**
 * @author David Vargas Muñiz
 *
 */
public class Vacunaciones {
	
	//Atributos
	private List<Vacunacion> vacunaciones;
	
	//Constructor
	public Vacunaciones(Stream<Vacunacion>st) {
		this.vacunaciones = st.collect(Collectors.toList());
	}
	
	public Vacunaciones(Collection<Vacunacion>vacunaciones) {
		this.vacunaciones = new ArrayList<Vacunacion>(vacunaciones);
	}
	
	public Vacunaciones() {
		vacunaciones = new ArrayList<Vacunacion>();
	}
	
	//Métodos
	public void anyadeVacunacion(Vacunacion v) {
		this.vacunaciones.add(v);
	}
	
	public List<Vacunacion> vacunacionesEntreFechas(LocalDate a, LocalDate b){
		return this.vacunaciones.stream().
				filter(x->a.isBefore(x.fecha()) && x.fecha().isBefore(b)).
				collect(Collectors.toList());
	}
	
	public Boolean existeNumPersonasPautaCompletaPorEncimaDe(String comunidad, Integer valorDado) {
		return this.vacunaciones.stream()
				.anyMatch(x->x.comunidad().equals(comunidad) && x.numeroPersonas()>valorDado);
	}
	
	public LocalDate diaMasVacunacionesEn(String comunidad) {
		Map<LocalDate, Long> mapaAux = this.vacunaciones.stream().
				filter(x->x.comunidad().equals(comunidad)).
				collect(Collectors.groupingBy(
						Vacunacion::fecha, 
						Collectors.counting()
						));
		Comparator<Map.Entry<LocalDate, Long>> cmp = (x,y)->x.getValue().
				compareTo(y.getValue());
		return mapaAux.entrySet().stream().
				max(cmp).
				get().
				getKey();

	}
	
	public Map<LocalDate, List<Vacunacion>> vacunacionesPorFecha(){
		return this.vacunaciones.stream().
				collect(Collectors.groupingBy(Vacunacion::fecha));
	}
	
	public Map<String, Vacunacion> maximoNumTotalVacunasporComunidad(){
		return this.vacunaciones.stream().
				collect(Collectors.groupingBy(Vacunacion::comunidad, 
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Vacunacion::numeroTotal)), 
								x->x.orElse(null))));
	}

}
