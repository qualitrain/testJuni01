package mx.com.qtx.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.qtx.entidades.Operacion;
import mx.com.qtx.servicios.IGestorPersistencia;

public class GestorPersistenciaMemoria implements IGestorPersistencia {
	
	private Map<Long,Operacion> bdOperaciones;

	public GestorPersistenciaMemoria() {
		this.bdOperaciones = new HashMap<>();
	}
	@Override
	public long getCantidadOperaciones() {
		return this.bdOperaciones.size();
	}

	@Override
	public Operacion getOperacion(long id) {
		return this.bdOperaciones.get(id);
	}

	@Override
	public List<Operacion> getOperacionesDesdeHasta(long folioInicio, long folioFin) {
		List<Operacion> operaciones = new ArrayList<>();
		this.bdOperaciones.values()
		                  .stream()
		                  .filter(opI ->  ( opI.getFolio() >= folioInicio && opI.getFolio() <= folioFin))
		                  .sorted((fI,fF)-> (fI.getFolio() <= fF.getFolio() ? -1 : 1))
		                  .forEach(operI -> operaciones.add(operI));
		                  
		return operaciones;
	}

	@Override
	public void insertarOperacion(Operacion op) {
		this.bdOperaciones.put(op.getFolio(), op);
	}

}
