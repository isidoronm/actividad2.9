/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.vo;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 10 nov 2023
 *
 */
public class Organismo {
	private String codigo;
	private String nombre;
	private int anyoCreacion;
	private String sede;
	private String url;
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the organismo
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param organismo the organismo to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the anyoCreacion
	 */
	public int getAnyoCreacion() {
		return anyoCreacion;
	}
	/**
	 * @param anyoCreacion the anyoCreacion to set
	 */
	public void setAnyoCreacion(int anyoCreacion) {
		this.anyoCreacion = anyoCreacion;
	}
	/**
	 * @return the sede
	 */
	public String getSede() {
		return sede;
	}
	/**
	 * @param sede the sede to set
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Organismo [codigo=" + codigo + ", organismo=" + nombre + ", anyoCreacion=" + anyoCreacion + ", sede="
				+ sede + ", url=" + url + "]\n";
	}
}
