/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.vo;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 4 nov 2023
 *
 */
public class Continente {
	private String codigo;
	private String nombre;

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Continente [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
}
