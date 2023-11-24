/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.fichero;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 10 nov 2023
 *
 */
public class DireccionJSON {
	@JsonProperty ("street")
	private String calle;
	
	@JsonProperty ("city")
	private String ciudad;

	@JsonProperty ("zipcode")
	private String codigoPostal;
	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}
	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@Override
	public String toString() {
		return "DireccionJSON [calle=" + calle + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + "]\n";
	}	
}
