package mx.com.qtx.entidades;

import java.util.Date;

public class OperacionCalculoComision {

	private String emisor;
	private Date fecha;
	private long folio;
	private double importe;
	private String tipoVta;

	public OperacionCalculoComision(){
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getFolio() {
		return folio;
	}

	public void setFolio(long folio) {
		this.folio = folio;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getTipoVta() {
		return tipoVta;
	}

	public void setTipoVta(String tipoVta) {
		this.tipoVta = tipoVta;
	}

	@Override
	public String toString() {
		return "OperacionCalculoComision [emisor=" + emisor + ", fecha=" + fecha + ", folio=" + folio + ", importe="
				+ importe + ", tipoVta=" + tipoVta + ", getEmisor()=" + getEmisor() + ", getFecha()=" + getFecha()
				+ ", getFolio()=" + getFolio() + ", getImporte()=" + getImporte() + ", getTipoVta()=" + getTipoVta()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}