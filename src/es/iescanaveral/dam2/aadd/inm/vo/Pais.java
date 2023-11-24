/**
 * 
 */
package es.iescanaveral.dam2.aadd.inm.vo;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 4 nov 2023
 *
 */
public class Pais {
	private int codigoPais;
	private String nombrePais;
	private String capital;
	private Continente continente;

	/**
	 * @return the codigoPais
	 */
	public int getCodigoPais() {
		return codigoPais;
	}

	/**
	 * @param codigoPais the codigoPais to set
	 */
	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	/**
	 * @return the nombrePais
	 */
	public String getNombrePais() {
		return nombrePais;
	}

	/**
	 * @param nombrePais the nombrePais to set
	 */
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * @return the continente
	 */
	public Continente getContinente() {
		return continente;
	}

	/**
	 * @param continente the continente to set
	 */
	public void setContinente(Continente continente) {
		this.continente = continente;
	}

	@Override
	public String toString() {
		return "Pais [codigoPais=" + codigoPais + ", nombrePais=" + nombrePais + ", capital=" + capital
				+ ", continente=" + continente + "]\n";
	}

}
