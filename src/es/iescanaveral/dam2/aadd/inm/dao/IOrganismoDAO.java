/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.dao;

import es.iescanaveral.dam2.aadd.inm.vo.Organismo;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 11 nov 2023
*
*/
public interface IOrganismoDAO {
	public Organismo obtenerOrganismoDeID(String idOrganismo);
	public int crearOrganismo(Organismo organismo);
	public int  borrarOrganismo(String idOrganismo);
	public int actualizarOrganismo(Organismo organismo);
}
