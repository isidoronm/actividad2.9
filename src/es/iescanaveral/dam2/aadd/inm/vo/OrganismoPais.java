/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.vo;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 24 nov 2023
*
*/
public class OrganismoPais {
	private Organismo organismo;
	private Pais pais;
	/**
	 * @return the organismo
	 */
	public Organismo getOrganismo() {
		return organismo;
	}
	/**
	 * @param organismo the organismo to set
	 */
	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}
	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "OrganismoPais [organismo=" + organismo + ", pais=" + pais + "]";
	}	
}
