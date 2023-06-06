package mx.com.qtx.entidades;

import java.util.Date;

public class Venta {
	private long numVta;
	private Date fecha;
	private char tipo;
	private double importe;
	
	public Venta() {
		super();
	}

	public Venta(long numVta, Date fecha, char tipo, double importe) {
		super();
		this.numVta = numVta;
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
	}

	public long getNumVta() {
		return numVta;
	}

	public void setNumVta(long numVta) {
		this.numVta = numVta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Venta [numVta=" + numVta + ", fecha=" + fecha + ", tipo=" + tipo + ", importe=" + importe + "]";
	}

}
