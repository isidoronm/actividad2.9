package es.iescanaveral.dam2.aadd.inm;

import java.util.List;
import java.util.Scanner;

import es.iescanaveral.dam2.aadd.inm.dao.IContinenteDAO;
import es.iescanaveral.dam2.aadd.inm.dao.IOrganismoDAO;
import es.iescanaveral.dam2.aadd.inm.dao.IOrganismoPaisDAO;
import es.iescanaveral.dam2.aadd.inm.dao.IPaisDAO;
import es.iescanaveral.dam2.aadd.inm.dao.impl.ContinenteDaoJDBC;
import es.iescanaveral.dam2.aadd.inm.dao.impl.OrganismoDaoJDBC;
import es.iescanaveral.dam2.aadd.inm.dao.impl.OrganismoPaisDaoJDBC;
import es.iescanaveral.dam2.aadd.inm.dao.impl.PaisDaoJDBC;
import es.iescanaveral.dam2.aadd.inm.exception.MapaMundiException;
import es.iescanaveral.dam2.aadd.inm.fichero.DelegacionXML;
import es.iescanaveral.dam2.aadd.inm.fichero.GestionFicherosOrganismo;
import es.iescanaveral.dam2.aadd.inm.fichero.OrganismoCSV;
import es.iescanaveral.dam2.aadd.inm.fichero.OrganismoJSON;
import es.iescanaveral.dam2.aadd.inm.vo.Continente;
import es.iescanaveral.dam2.aadd.inm.vo.Organismo;
import es.iescanaveral.dam2.aadd.inm.vo.Pais;

/**
 * @author Isidoro Nevares Martín Fecha: 29 oct 2023
 *
 */
public class GestorMapamundi {
	//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
	public static void main(String[] args) {

		GestorMapamundi app = new GestorMapamundi();
		
		// Tratamiento de lógica de negocio
		String operacion = app.obtenerOperacionProcesar();

		app.gestionarMapamundi(operacion);
		
	}
	public String gestionarMapamundi(String operacion){
		String resultado=null;
		try {
			switch (operacion) {
			case "1": { // Consulta paises americanos que empiezan por 'Sa'
				resultado=consultarPaisesCapitalEmpiezaPor(false);
				break;
			}
			case "2": { // Insertar continente Antártida
				resultado=insertarNuevoContinente();
				break;
			}
			case "3": { // Actualizar capital del país 107 a "Capital City"
				resultado=actualizarCapitalPais();
				break;
			}
			case "4": { // Borrar continente con código '03'
				resultado=borrarContinente();
				break;
			}
			case "5": { // Consulta paises americanos que empiezan por 'Sa' (con un procedimiento almacenado).
				resultado=consultarPaisesCapitalEmpiezaPor(true);
				break;
			}
			case "6": { // Llamar al tratamiento del fichero CSV de Organismo.
				resultado=tratarFicheroCSVOrganismos();
				break;
			}
			case "7": { // Llamar al tratamiento del fichero JSON de Organismo.
				resultado=tratarFicheroJSONOrganismos();
				break;
			}
			case "8": { // Llamar al tratamiento del fichero JSON de Organismo.	
					resultado=crearTablaOrganismoPais();
				break;
			}
			case "9": { // Llamar al tratamiento del fichero JSON de Organismo.
				resultado=tratarFicheroXMLOrganismoPais();
				break;
			}
			}
		} catch (MapaMundiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultado;
	}

	private String insertarNuevoContinente() {
		String resultadoDevolver =null;
		// Construcción del implementador de Continente
		IContinenteDAO continenteDAO = new ContinenteDaoJDBC();

		Continente continente = new Continente();
		continente.setCodigo("06");
		continente.setNombre("Antártida");

		int resultado = continenteDAO.crearContinente(continente);
		resultadoDevolver ="Inserción del continente " + ((resultado == 1) ? "correcta" : "errónea");
		System.out.println("Inserción del continente " + ((resultado == 1) ? "correcta" : "errónea"));
		return resultadoDevolver;
	}

	private String consultarPaisesCapitalEmpiezaPor(boolean opcionProcedimiento) {
		String resultadoDevolver ="";
		List<Pais> listaPaises = null;
		// Construcción del implementador de Pais
		IPaisDAO paisDAO = new PaisDaoJDBC();

		if (opcionProcedimiento) {// Consulta procedimiento almacenado en MySQL
			listaPaises = paisDAO.consultarPaisesCapitalComiezaPor_Procedure("02", "Sa");
		} else {// Consulta sentencia SQL en MySQL
			listaPaises = paisDAO.consultarPaisesCapitalComiezaPor("02", "Sa");
		}
		for (Pais pais : listaPaises) {
			StringBuffer bufferResultado = new StringBuffer();
			bufferResultado.append(pais.getCapital()).append(" capital de ").append(pais.getNombrePais());
			bufferResultado.append(" (").append(pais.getCodigoPais()).append(")");
			bufferResultado.append(" pertence al continente ");
			bufferResultado.append(pais.getContinente().getNombre()).append(" (")
					.append(pais.getContinente().getCodigo()).append(") ");
			;
			resultadoDevolver +=bufferResultado.toString()+"\n";
		}
		return resultadoDevolver;
	}

	private String actualizarCapitalPais() {
		String resultadoDevolver =null;
		// Construcción del implementador de Pais
		IPaisDAO paisDAO = new PaisDaoJDBC();

		// Obtener pais 107
		Pais pais = paisDAO.obtenerPaisPorId(107);
		System.out.println(pais);
		if (pais != null) {
			pais.setCapital("Capital City");
			int resultado = paisDAO.actualizarPais(pais);
			System.out.println("Actualización de la capital " + ((resultado == 1) ? "correcta" : "errónea"));
			resultadoDevolver="Actualización de la capital " + ((resultado == 1) ? "correcta" : "errónea");
		}
		return resultadoDevolver;
	}

	private String borrarContinente() {
		String resultadoDevolver =null;
		// Construcción del implementador de Continente
		IContinenteDAO continenteDAO = new ContinenteDaoJDBC();

		int resultado = continenteDAO.borrarContinente("06");
		if (resultado == 1) {
			resultadoDevolver="Se ha borrado el continente.";
			System.out.println("Se ha borrado el continente.");
		} else {
			resultadoDevolver="No había continente que borrar.";
			System.out.println("No había continente que borrar.");
		}
		return resultadoDevolver;
	}

	private String tratarFicheroCSVOrganismos() {
		String resultadoDevolver =null;
		GestionFicherosOrganismo gestor = new GestionFicherosOrganismo();
		List<OrganismoCSV> listaOrganismosCSV = gestor.obtenerListaOrganismoCSV();
		// Tratamiento Organismo CSV
		if (listaOrganismosCSV != null && listaOrganismosCSV.size() > 0) {
			IOrganismoDAO organismoDAO = new OrganismoDaoJDBC();

			for (OrganismoCSV organismoCSV : listaOrganismosCSV) {
				String operacion = organismoCSV.getOperacion();
				if (!operacion.equals("-")) {
					Organismo organismo = gestor.getOrganismoDeOrganismoCSV(organismoCSV);
					int resultado = -1;
					switch (operacion) {
					case "A": { // Actualizar Organismo
						resultado = organismoDAO.actualizarOrganismo(organismo);
						break;
					}
					case "B": { // Borrar Organismo
						Organismo organismoBBDD = organismoDAO.obtenerOrganismoDeID(organismo.getCodigo());
						if (organismoBBDD != null) { // Borrar organismo
							resultado = organismoDAO.borrarOrganismo(organismo.getCodigo());
						}
						break;
					}
					case "I": { // Insertar Organismo
						Organismo organismoBBDD = organismoDAO.obtenerOrganismoDeID(organismo.getCodigo());
						if (organismoBBDD == null) { // Borrar organismo
							resultado = organismoDAO.crearOrganismo(organismo);
						}
						break;
					}
					}
					System.out.println("Valor de resulado: " + resultado);
				}
			}
		}
		resultadoDevolver="Se ha ejecutado correctamente el fichero CSV";
		return resultadoDevolver;
	}

	private String tratarFicheroJSONOrganismos() {
		String resultadoDevolver =null;
		GestionFicherosOrganismo gestor = new GestionFicherosOrganismo();
		List<OrganismoJSON> listaOrganismosJSON = gestor.obtenerListaOrganismoJSON();
		// Tratamiento Organismo CSV
		if (listaOrganismosJSON != null && listaOrganismosJSON.size() > 0) {
			IOrganismoDAO organismoDAO = new OrganismoDaoJDBC();

			for (OrganismoJSON organismoJSON : listaOrganismosJSON) {
				String operacion = organismoJSON.getOperacion();
				if (!operacion.equals("N")) {
					Organismo organismo = gestor.getOrganismoDeOrganismoJSON(organismoJSON);
					int resultado = -1;
					switch (operacion) {
					case "M": { // Actualizar Organismo
						resultado = organismoDAO.actualizarOrganismo(organismo);
						break;
					}
					case "B": { // Borrar Organismo
						Organismo organismoBBDD = organismoDAO.obtenerOrganismoDeID(organismo.getCodigo());
						if (organismoBBDD != null) { // Borrar organismo
							resultado = organismoDAO.borrarOrganismo(organismo.getCodigo());
						}
						break;
					}
					case "C": { // Insertar Organismo
						Organismo organismoBBDD = organismoDAO.obtenerOrganismoDeID(organismo.getCodigo());
						if (organismoBBDD == null) { // Borrar organismo
							resultado = organismoDAO.crearOrganismo(organismo);
						}
						break;
					}
					}
					System.out.println("Valor de resulado: " + resultado);
				}
			}
		}
		resultadoDevolver="Se ha ejecutado correctamente el fichero JSON";
		return resultadoDevolver;
	}

	private String crearTablaOrganismoPais() throws MapaMundiException {
		String resultado =null;
		IOrganismoPaisDAO organismoPaisDAO  = new OrganismoPaisDaoJDBC();
		resultado = String.valueOf( organismoPaisDAO.crearTablaOrganismoPais());
		return resultado;		
	}

	private String tratarFicheroXMLOrganismoPais() {
		String resultadoDevolver =null;
		GestionFicherosOrganismo gestor = new GestionFicherosOrganismo();
		List<DelegacionXML> listaDelegacionesXML = gestor.obtenerListaDelegacionesXML();
		// Tratamiento Organismo CSV
		if (listaDelegacionesXML != null && listaDelegacionesXML.size() > 0) {
			IOrganismoPaisDAO organismoDAO = new OrganismoPaisDaoJDBC();

			for (DelegacionXML delegacionXML : listaDelegacionesXML) {
				String operacion = delegacionXML.getOperacion();
				if (!operacion.equals("N")) {
//					Organismo organismo = gestor.getOrganismoDeOrganismoJSON(organismoJSON);
//					int resultado = -1;
//					switch (operacion) {
//					case "B": { // Borrar Organismo
//						Organismo organismoBBDD = organismoDAO.obtenerOrganismoDeID(organismo.getCodigo());
//						if (organismoBBDD != null) { // Borrar organismo
//							resultado = organismoDAO.borrarOrganismo(organismo.getCodigo());
//						}
//						break;
//					}
//					case "C": { // Insertar Organismo
//						Organismo organismoBBDD = organismoDAO.obtenerOrganismoDeID(organismo.getCodigo());
//						if (organismoBBDD == null) { // Borrar organismo
//							resultado = organismoDAO.crearOrganismo(organismo);
//						}
//						break;
//					}
//					}
//					System.out.println("Valor de resulado: " + resultado);
				}
			}
		}
		resultadoDevolver="Se ha ejecutado correctamente el fichero XML";
		return resultadoDevolver;
	}

	private String obtenerOperacionProcesar() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Menú:");
		System.out.println("  1: Consulta Paises americanos cuya Capital comienza por 'Sa'");
		System.out.println("  2: Añadir un nuveo continente: 'Antártida'");
		System.out.println("  3: Actualizar la capital del país con códifo 107 a 'Capital City'");
		System.out.println("  4: Eliminación del continente con código '02'");
		System.out.println("  5: Consulta Paises americanos cuya Capital comienza por 'Sa' (Procedimiento)");
		System.out.println("  6: Tratamiento fichero CSV (Organismos)");
		System.out.println("  7: Tratamiento fichero JSON (Organismos)");
		System.out.println("  8: Creación de Tabla T_ORGANISMO_PAIS");
		System.out.println("  9: Tratamiento fichero XML (Delegaciones)");
		System.out.println("----------------------------------------------------------");
		System.out.println("Introduce la operación a realizar:");
		// Operación recogida
		String operacion = entrada.nextLine().trim();

		while (!("123456789".contains(operacion))) {
			System.out.println("Has seleccionado un operación errónea (ha de ser un número entre 1 y 7)");
			System.out.print("Introduce la operación a realizar:");

			// Operación recogida
			operacion = entrada.nextLine();
		}
		System.out.println("Operación a realizar: " + operacion);
		// Cerrar la entrada del Scanner
		entrada.close();

		return operacion;
	}
}
