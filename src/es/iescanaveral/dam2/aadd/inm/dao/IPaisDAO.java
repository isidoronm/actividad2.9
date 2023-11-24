/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.dao;

import java.util.List;

import es.iescanaveral.dam2.aadd.inm.vo.Pais;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 4 nov 2023
*
*/
public interface IPaisDAO {
	public 	List<Pais> consultarPaisesCapitalComiezaPor(String idContinente, String inicioCapital);
	public int actualizarPais(Pais pais);
	public 	Pais obtenerPaisPorId(int idPais);
	public 	List<Pais> consultarPaisesCapitalComiezaPor_Procedure(String idContinente, String inicioCapital);

}
