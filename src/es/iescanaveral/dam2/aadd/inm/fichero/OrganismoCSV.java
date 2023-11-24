/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.fichero;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 10 nov 2023
 *
 */
public class OrganismoCSV {
	private String operacion;
	private String codigo;
	private String organismo;
	private int anyo_creacion;
	private String sede;
	private String url;
	private String observacion;
	/**
	 * @return the operacion
	 */
	public String getOperacion() {
		return operacion;
	}
	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the organismo
	 */
	public String getOrganismo() {
		return organismo;
	}
	/**
	 * @param organismo the organismo to set
	 */
	public void setOrganismo(String organismo) {
		this.organismo = organismo;
	}
	/**
	 * @return the sede
	 */
	public String getSede() {
		return sede;
	}
	/**
	 * @param sede the sede to set
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public String toString() {
		return "OrganismoCSV [operacion=" + operacion + ", codigo=" + codigo + ", organismo=" + organismo
				+ ", anyoCreacion=" + anyo_creacion + ", sede=" + sede + ", url=" + url + ", observacion=" + observacion
				+ "]";
	}
	/**
	 * @return the anyo_creacion
	 */
	public int getAnyo_creacion() {
		return anyo_creacion;
	}
	/**
	 * @param anyo_creacion the anyo_creacion to set
	 */
	public void setAnyo_creacion(int anyo_creacion) {
		this.anyo_creacion = anyo_creacion;
	}
}
