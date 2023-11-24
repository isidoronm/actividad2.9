/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.fichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;

import es.iescanaveral.dam2.aadd.inm.utilidades.GestorConfiguracion;
import es.iescanaveral.dam2.aadd.inm.vo.Organismo;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 11 nov 2023
*
*/
public class GestionFicherosOrganismo {
	private final static char SEPARADOR_CSV_ORGANISMO='|';
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<OrganismoCSV> obtenerListaOrganismoCSV() {
		List<OrganismoCSV> listaOrganismosCSV=null;
		
		String nombreFicheroCSV=GestorConfiguracion.getInfoConfiguracion("ruta.directorio") + GestorConfiguracion.getInfoConfiguracion("ruta.fichero.organismo.csv"); 
	     try {
			listaOrganismosCSV = new CsvToBeanBuilder(new FileReader(nombreFicheroCSV))
				       .withType(OrganismoCSV.class).withSeparator(SEPARADOR_CSV_ORGANISMO).build().parse();
		} catch (IllegalStateException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaOrganismosCSV;		
	}
	public Organismo getOrganismoDeOrganismoCSV(OrganismoCSV organismoCVS) {
		Organismo organismo=null;
		if(organismoCVS!=null) {
			organismo = new Organismo();
			organismo.setCodigo(organismoCVS.getCodigo());
			organismo.setNombre(organismoCVS.getOrganismo());
			organismo.setAnyoCreacion(organismoCVS.getAnyo_creacion());
			organismo.setSede(organismoCVS.getSede());
			organismo.setUrl(organismoCVS.getUrl());
		}
		return organismo;
	}
	public List<OrganismoJSON> obtenerListaOrganismoJSON() {
		List<OrganismoJSON> listaOrganismosJSON=null;
		
		String nombreFicheroCSV=GestorConfiguracion.getInfoConfiguracion("ruta.directorio") + GestorConfiguracion.getInfoConfiguracion("ruta.fichero.organismo.json"); 
    	ObjectMapper mapper = new ObjectMapper();
    	TypeReference<List<OrganismoJSON>> typeReference = new TypeReference<List<OrganismoJSON>>() {};
    	try {
			listaOrganismosJSON=mapper.readValue(new File(nombreFicheroCSV), typeReference);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaOrganismosJSON;		
	}
	public Organismo getOrganismoDeOrganismoJSON(OrganismoJSON organismoJSON) {
		Organismo organismo=null;
		if(organismoJSON!=null) {
			organismo = new Organismo();
			organismo.setCodigo(organismoJSON.getCodigo());
			organismo.setNombre(organismoJSON.getOrganismo());
			organismo.setAnyoCreacion(organismoJSON.getAnyo_creacion());
			organismo.setSede(organismoJSON.getDireccion().getCiudad());
			organismo.setUrl(organismoJSON.getUrl());
		}
		return organismo;
	}
	
	public List<DelegacionXML> obtenerListaDelegacionesXML() {
		List<DelegacionXML> listaDelegacionesXML=null;
		
		String nombreFicheroCSV=GestorConfiguracion.getInfoConfiguracion("ruta.directorio") + GestorConfiguracion.getInfoConfiguracion("ruta.fichero.delegaciones.xml"); 
    	ObjectMapper mapper = new ObjectMapper();
    	TypeReference<List<DelegacionXML>> typeReference = new TypeReference<List<DelegacionXML>>() {};
    	try {
    		listaDelegacionesXML=mapper.readValue(new File(nombreFicheroCSV), typeReference);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaDelegacionesXML;		
	}
	
}
