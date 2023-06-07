package mx.com.qtx.servicios;

import java.util.List;

import mx.com.qtx.entidades.OperacionCalculoComision;

public interface IGestorPersistencia {
	long getCantidadOperaciones();
	OperacionCalculoComision getOperacion(long id);
	List<OperacionCalculoComision> getOperacionesDesdeHasta();
	void insertarOperacion(OperacionCalculoComision op);
}