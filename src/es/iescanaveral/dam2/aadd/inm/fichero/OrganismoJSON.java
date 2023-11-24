/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.fichero;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 10 nov 2023
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganismoJSON {
	@JsonProperty ("operation")
	private String operacion;

	@JsonProperty ("code")
	private String codigo;
	
	@JsonProperty ("org")
	private String organismo;
	
	@JsonProperty ("year")
	private int anyo_creacion;
	
	@JsonProperty ("url")
	private String url;
	
	@JsonProperty ("address")
	private DireccionJSON direccion;
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
	 * @return the direccion
	 */
	public DireccionJSON getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(DireccionJSON direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "OrganismoJSON [operacion=" + operacion + ", codigo=" + codigo + ", organismo=" + organismo
				+ ", anyo_creacion=" + anyo_creacion + ", url=" + url + ", direccion=" + direccion + "]\n";
	}
}
