package mx.com.qtx.entidades;

import java.sql.Date;

public class Operacion {
	private long folio;
	private String nombre;
	private Date fecha;
	private double monto;
	private char tipoVta;
	private double comision;
	private boolean erronea;
	private Exception exLanzada;
	private int codigoError;
	
	
	public Operacion() {
		super();
	}
	public long getFolio() {
		return folio;
	}
	public void setFolio(long folio) {
		this.folio = folio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public char getTipoVta() {
		return tipoVta;
	}
	public void setTipoVta(char tipoVta) {
		this.tipoVta = tipoVta;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public boolean isErronea() {
		return erronea;
	}
	public void setErronea(boolean erronea) {
		this.erronea = erronea;
	}
	public Exception getExLanzada() {
		return exLanzada;
	}
	public void setExLanzada(Exception exLanzada) {
		this.exLanzada = exLanzada;
	}
	public int getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(int codigoError) {
		this.codigoError = codigoError;
	}
	public Operacion(long folio, String nombre, Date fecha, double monto, char tipoVta, double comision,
			boolean erronea, Exception exLanzada, int codigoError) {
		super();
		this.folio = folio;
		this.nombre = nombre;
		this.fecha = fecha;
		this.monto = monto;
		this.tipoVta = tipoVta;
		this.comision = comision;
		this.erronea = erronea;
		this.exLanzada = exLanzada;
		this.codigoError = codigoError;
	}
	
}
