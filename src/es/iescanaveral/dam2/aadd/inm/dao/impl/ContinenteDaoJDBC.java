/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import es.iescanaveral.dam2.aadd.inm.dao.IContinenteDAO;
import es.iescanaveral.dam2.aadd.inm.utilidades.GestorConexion;
import es.iescanaveral.dam2.aadd.inm.vo.Continente;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 4 nov 2023
*
*/
public class ContinenteDaoJDBC implements IContinenteDAO{
	
	@Override
	public int crearContinente(Continente continente) {
		int resultadoSentencia=0;
		Connection conexion=GestorConexion.getConexion();
		Statement declaracion=null;
		try {
			declaracion = conexion.createStatement();
			String sentenciaSQL= "INSERT INTO T_CONTINENTE " +
						  "VALUES ('" + continente.getCodigo() + "', " +
						  "'" + continente.getNombre() + "')";
			System.out.println(sentenciaSQL);
			resultadoSentencia= declaracion.executeUpdate(sentenciaSQL);
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
	@Override
	public int borrarContinente(String IdContinente) {
		int resultadoSentencia=0;

		Connection conexion=GestorConexion.getConexion();
		Statement declaracion=null;
		try {
			declaracion = conexion.createStatement();
			String sentenciaSQL= "DELETE FROM T_CONTINENTE WHERE cod_continente = '" + IdContinente +"'";
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
