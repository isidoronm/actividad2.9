/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.fichero;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 10 nov 2023
 *
 */
public class DelegacionXML {
	private String operacion;
	private String tipo;
	private OrganismoXML organismoXML;
	private PaisXML paisXML;
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the organismoXML
	 */
	public OrganismoXML getOrganismoXML() {
		return organismoXML;
	}
	/**
	 * @param organismoXML the organismoXML to set
	 */
	public void setOrganismoXML(OrganismoXML organismoXML) {
		this.organismoXML = organismoXML;
	}
	/**
	 * @return the paisXML
	 */
	public PaisXML getPaisXML() {
		return paisXML;
	}
	/**
	 * @param paisXML the paisXML to set
	 */
	public void setPaisXML(PaisXML paisXML) {
		this.paisXML = paisXML;
	}
}
