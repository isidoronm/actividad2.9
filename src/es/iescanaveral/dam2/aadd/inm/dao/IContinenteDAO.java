/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.dao;

import es.iescanaveral.dam2.aadd.inm.vo.Continente;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 4 nov 2023
 *
 */
public interface IContinenteDAO {
	public int borrarContinente(String IdContinente);

	public int crearContinente(Continente continente);

}
