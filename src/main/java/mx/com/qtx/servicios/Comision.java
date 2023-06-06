package mx.com.qtx.servicios;

public class Comision {
	private long folio;
	private double importe;
	public Comision(long folio, double importe) {
		super();
		this.folio = folio;
		this.importe = importe;
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
}
