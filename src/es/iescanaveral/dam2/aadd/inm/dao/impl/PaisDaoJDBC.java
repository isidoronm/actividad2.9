/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.iescanaveral.dam2.aadd.inm.dao.IPaisDAO;
import es.iescanaveral.dam2.aadd.inm.utilidades.GestorConexion;
import es.iescanaveral.dam2.aadd.inm.vo.Continente;
import es.iescanaveral.dam2.aadd.inm.vo.Pais;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 4 nov 2023
*
*/
public class PaisDaoJDBC implements IPaisDAO {

	@Override
	public List<Pais> consultarPaisesCapitalComiezaPor(String idContinente,  String inicioCapital) {
		List<Pais> listaPaises = null;
		
		Connection conexion=GestorConexion.getConexion();
		Statement declaracion=null;
		try {
			declaracion = conexion.createStatement();
			String sentenciaSQL= "SELECT * from T_CONTINENTE tc , T_PAIS tp " +
						  "WHERE tc.cod_continente =tp.cod_continente " + 
						  " and tc.cod_continente ='" + idContinente + "' " +
						  "and tp.capital LIKE '" + inicioCapital + "%'";
			System.out.println(sentenciaSQL);
			ResultSet resultados = declaracion.executeQuery(sentenciaSQL);
			listaPaises=new ArrayList<Pais>();
			while (resultados.next()) {
				int codigoPais= resultados.getInt("cod_pais");
				String nombrePais=resultados.getString("nombre_pais");
				String capitalPais=resultados.getString("capital");
				String codigoContinente = resultados.getString("cod_continente");
				String nombreContinente = resultados.getString("nombre_continente");
				
				Pais pais = new Pais();
				pais.setCodigoPais(codigoPais);
				pais.setNombrePais(nombrePais);
				pais.setCapital(capitalPais);
				
				Continente continente = new Continente();
				continente.setCodigo(codigoContinente);
				continente.setNombre(nombreContinente);
				pais.setContinente(continente);
				
				listaPaises.add(pais);		
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
		
		return listaPaises;
	}

	@Override
	public int actualizarPais(Pais pais) {
		int resultadoSentencia=0;
		Connection conexion=GestorConexion.getConexion();
		Statement declaracion=null;
		try {
			declaracion = conexion.createStatement();
			String sentenciaSQL= "UPDATE T_PAIS " +
						  "SET capital='"+ pais.getCapital() + "'" +
						  " WHERE cod_pais =" + pais.getCodigoPais() ;
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

	@Override
	public Pais obtenerPaisPorId(int idPais) {
		Pais pais =null;

		Connection conexion=GestorConexion.getConexion();
		Statement declaracion=null;
		try {
			declaracion = conexion.createStatement();
			String sentenciaSQL= "SELECT * from T_CONTINENTE tc , T_PAIS tp " +
						  "WHERE tc.cod_continente =tp.cod_continente " + 
						  " and tp.cod_pais =" + idPais ;
			System.out.println(sentenciaSQL);
			ResultSet resultados = declaracion.executeQuery(sentenciaSQL);

			// Consulta por clave primaria. Solo devuelve un resultado.
			if (resultados.next()) {
				int codigoPais= resultados.getInt("cod_pais");
				String nombrePais=resultados.getString("nombre_pais");
				String capitalPais=resultados.getString("capital");
				String codigoContinente = resultados.getString("cod_continente");
				String nombreContinente = resultados.getString("nombre_continente");
				
				pais = new Pais();
				pais.setCodigoPais(codigoPais);
				pais.setNombrePais(nombrePais);
				pais.setCapital(capitalPais);
				
				Continente continente = new Continente();
				continente.setCodigo(codigoContinente);
				continente.setNombre(nombreContinente);
				pais.setContinente(continente);				
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
		
		return pais;
	}

	@Override
	public List<Pais> consultarPaisesCapitalComiezaPor_Procedure(String idContinente, String inicioCapital) {
		List<Pais> listaPaises = null;

		Connection conexion=GestorConexion.getConexion();
		CallableStatement declaracion=null;
		try {
			String sentenciaSQL= "{call obtener_paises_capital_comienza_por(?,?)}";
			// Se prepara el Statement
			declaracion = conexion.prepareCall(sentenciaSQL);

			// Asignación del primer parámetro de entrada
			declaracion.setString(1,idContinente);

			// Asignación del segundo parámetro de entrada
			declaracion.setString(2,inicioCapital);

			// Se hace la llamada a la función.
			ResultSet resultados = declaracion.executeQuery();

			// Aunque está un While solo debe tener 1 registro
			listaPaises=new ArrayList<Pais>();
			while (resultados.next()) {
				int codigoPais= resultados.getInt("cod_pais");
				String nombrePais=resultados.getString("nombre_pais");
				String capitalPais=resultados.getString("capital");
				String codigoContinente = resultados.getString("cod_continente");
				String nombreContinente = resultados.getString("nombre_continente");
				
				Pais pais = new Pais();
				pais.setCodigoPais(codigoPais);
				pais.setNombrePais(nombrePais);
				pais.setCapital(capitalPais);
				
				Continente continente = new Continente();
				continente.setCodigo(codigoContinente);
				continente.setNombre(nombreContinente);
				pais.setContinente(continente);
				
				listaPaises.add(pais);		
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
		return listaPaises;
	}

}
