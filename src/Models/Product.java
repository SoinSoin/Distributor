/**
 * 
 */
package Models;

/**
 * @author Vincent RETORE
 *
 * @createdAt: 19 févr. 2020
 */
public class Product extends Stockable {
	static private int incrementator = 1;

	private String nom;
	private int prix;

	public Product(String pNom, int pPrix) {
		this.nom = pNom;
		this.prix = pPrix;
		this.id = Integer.toString(incrementator++);
		// TODO Auto-generated constructor stub
	}

	public Product(String pNom, int pPrix, int pQty) {
		this.nom = pNom;
		this.prix = pPrix;

		this.id = Integer.toString(incrementator++);
		this.qty = pQty;

		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String pNom) {
		this.nom = pNom;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return this.prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int pPrix) {
		this.prix = pPrix;
	}

	/**
	 * 
	 */

	// pour avoir le prix au format pièce
	public float getPrixToFloat(int pPrix) {
		return (float) pPrix / 100f;
	}

}
