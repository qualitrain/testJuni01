package mx.com.qtx.servicios;

import java.util.List;

import mx.com.qtx.entidades.Operacion;
import mx.com.qtx.entidades.Venta;
import mx.com.qtx.persistencia.GestorPersistenciaMemoria;

public class CalculadoraComisiones {
	
	private IGestorPersistencia gestorPersistencia = new GestorPersistenciaMemoria();
	//Solamente debe dar comision a ventas superiores al importe mínimo
	private final double importeMinimo=1000;
	
	//Aplica a ventas normales: tipo 'N'
	private final double porcComisionNormal = 5;
	
	//Aplica a venta extraordinarias: tipo 'X'
	private final double porcComisionExtraordinario = 10;
	
	public double getImporteMinimo() {
		return importeMinimo;
	}

	public double getPorcComisionNormal() {
		return porcComisionNormal;
	}

	public double getPorcComisionExtraordinario() {
		return porcComisionExtraordinario;
	}

	public double calcularComision(double importeVenta, char tipoVenta) {
		if (tipoVenta == 'n') {
			tipoVenta = 'N';
		}
		else
	    if(tipoVenta == 'x') {
	    	tipoVenta = 'X';
	    }
		
		if(importeVenta <= 0)
			return -2;
		if(importeVenta <= this.importeMinimo)
			return 0;
		if(tipoVenta == 'N') {
			return importeVenta * this.porcComisionNormal / 100;
		}
		if(tipoVenta == 'X') {
			return importeVenta * this.porcComisionExtraordinario / 100;
		}
		return -1;
	}

	public double calcularComision(Venta vta) {
		if(vta == null) {
			return -3;
		}
		return this.calcularComision(vta.getImporte(), vta.getTipo());
	}
	

	public Comision calcularComision(double d, char c, String emisor) {
		return null;
	}


	public List<Operacion> getOperacionesDesdeHasta(Long folioInicio, Long folioFin) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
