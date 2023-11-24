/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.iescanaveral.dam2.aadd.inm.dao.IOrganismoDAO;
import es.iescanaveral.dam2.aadd.inm.utilidades.GestorConexion;
import es.iescanaveral.dam2.aadd.inm.vo.Organismo;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 4 nov 2023
*
*/
public class OrganismoDaoJDBC implements IOrganismoDAO{
	
	@Override
	public Organismo obtenerOrganismoDeID(String idOrganismo) {
		Organismo organismo=null;
		Connection conexion=GestorConexion.getConexion();
		PreparedStatement declaracion=null;
		try {
			String sentenciaSQL= "SELECT * FROM T_ORGANISMO WHERE codigo_organismo=?";
			System.out.println(sentenciaSQL);
			declaracion = conexion.prepareStatement(sentenciaSQL);
			declaracion.setString(1, idOrganismo);
			ResultSet resultado = declaracion.executeQuery();
			// Consulta por ID
			if (resultado.next()){
				organismo=new Organismo();
				String codigoOrganismo=resultado.getString("codigo_organismo");
				String nombre=resultado.getString("nombre");
				int anyoCreacion=resultado.getInt("anyo_creacion");
				String sede=resultado.getString("sede");
				String url=resultado.getString("url");
				// Cargar el objeto organismos
				organismo.setCodigo(codigoOrganismo);
				organismo.setNombre(nombre);
				organismo.setAnyoCreacion(anyoCreacion);
				organismo.setSede(sede);
				organismo.setUrl(url);
			}
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
		return organismo;

	}
	@Override
	public int crearOrganismo(Organismo organismo) {
		int resultadoSentencia=0;
		Connection conexion=GestorConexion.getConexion();
		PreparedStatement declaracion=null;
		try {
			String sentenciaSQL= "INSERT INTO T_ORGANISMO VALUES (?, ?, ?, ?, ?)";
			declaracion = conexion.prepareStatement(sentenciaSQL);
			declaracion.setString(1, organismo.getCodigo());
			declaracion.setString(2, organismo.getNombre());
			declaracion.setInt(3, organismo.getAnyoCreacion());
			declaracion.setString(4, organismo.getSede());
			declaracion.setString(5, organismo.getUrl());
			System.out.println(sentenciaSQL);
			resultadoSentencia= declaracion.executeUpdate();
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
	public int borrarOrganismo(String idOrganismo) {
		int resultadoSentencia=0;

		Connection conexion=GestorConexion.getConexion();
		PreparedStatement declaracion=null;
		try {
			String sentenciaSQL= "DELETE FROM T_ORGANISMO WHERE codigo_organismo = ?";
			System.out.println(sentenciaSQL);
			declaracion = conexion.prepareStatement(sentenciaSQL);
			declaracion.setString(1, idOrganismo);
		
			resultadoSentencia = declaracion.executeUpdate();

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
	public int actualizarOrganismo(Organismo organismo) {
		int resultadoSentencia=0;
		Connection conexion=GestorConexion.getConexion();
		PreparedStatement declaracion=null;
		try {
			String sentenciaSQL= "UPDATE T_ORGANISMO SET nombre=?, anyo_creacion=?, sede=?, url=? WHERE codigo_organismo=?";
			declaracion = conexion.prepareStatement(sentenciaSQL);
			declaracion.setString(1, organismo.getCodigo());
			declaracion.setString(2, organismo.getNombre());
			declaracion.setInt(3, organismo.getAnyoCreacion());
			declaracion.setString(4, organismo.getSede());
			declaracion.setString(5, organismo.getUrl());
			System.out.println(sentenciaSQL);
			resultadoSentencia= declaracion.executeUpdate();
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
