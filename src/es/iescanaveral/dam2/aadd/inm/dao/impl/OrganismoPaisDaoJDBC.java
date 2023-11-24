/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import es.iescanaveral.dam2.aadd.inm.dao.IOrganismoPaisDAO;
import es.iescanaveral.dam2.aadd.inm.exception.MapaMundiException;
import es.iescanaveral.dam2.aadd.inm.utilidades.GestorConexion;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 4 nov 2023
*
*/
public class OrganismoPaisDaoJDBC implements IOrganismoPaisDAO{

	@Override
	public int crearTablaOrganismoPais() throws MapaMundiException {
		int resultadoSentencia=0;
		Connection conexion=GestorConexion.getConexion();
		Statement declaracion=null;
		try {
			declaracion = conexion.createStatement();
			String sentenciaSQL= "CREATE TABLE IF NOT EXISTS T_ORGANISMO_PAIS( " +
					 "codigo_organismo char(3) NOT NULL," +
					 "cod_pais int NOT NULL," +
					 "PRIMARY KEY (codigo_organismo, cod_pais)," +
					 "CONSTRAINT FK_ORGANISMOPAIS_ORGANISMO" +
					 "  FOREIGN KEY (codigo_organismo) REFERENCES T_ORGANISMO(codigo_organismo)," +
					 "CONSTRAINT FK_ORGANISMOPAIS_PAIS" +
					 "  FOREIGN KEY (cod_pais) REFERENCES T_PAIS(cod_pais) );";

			System.out.println(sentenciaSQL);
		
			resultadoSentencia = declaracion.executeUpdate(sentenciaSQL);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conexion!=null) {
				try {
					declaracion.close();
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultadoSentencia;
	}
	
}
