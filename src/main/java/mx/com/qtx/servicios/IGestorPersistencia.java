package mx.com.qtx.servicios;

import java.util.List;

import mx.com.qtx.entidades.Operacion;

public interface IGestorPersistencia {
	long getCantidadOperaciones();
	Operacion getOperacion(long id);
	void insertarOperacion(Operacion op);
	List<Operacion> getOperacionesDesdeHasta(long folioInicio, long folioFin);
}