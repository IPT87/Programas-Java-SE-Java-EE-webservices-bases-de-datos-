package model;

import java.util.Date;

public class CasoJson {
	private String ccaa_iso;
	private Date fecha;
	private int num_casos;

	public CasoJson(String ccaa_iso, Date fecha, int num_casos) {
		super();
		this.ccaa_iso = ccaa_iso;
		this.fecha = fecha;
		this.num_casos = num_casos;
	}

	public String getCcaa_iso() {
		return ccaa_iso;
	}

	public void setCcaa_iso(String ccaa_iso) {
		this.ccaa_iso = ccaa_iso;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getNum_casos() {
		return num_casos;
	}

	public void setNum_casos(int num_casos) {
		this.num_casos = num_casos;
	}

}
