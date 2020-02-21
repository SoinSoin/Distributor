/**
 * 
 */
package Models;

/**
 * @author Vincent RETORE
 *
 * @createdAt: 19 févr. 2020
 */
public class Money extends Stockable {
	static private int incrementator = 1;
	/**
	 * 
	 */

	private int value;
	private String brand;

	public Money(int pValue) {
		this.value = pValue;

		this.id = Integer.toString(incrementator++);
		// TODO Auto-generated constructor stub
	}

	public Money(int pValue, String pBrand) {
		this.value = pValue;
		this.brand = pBrand;

		this.id = Integer.toString(incrementator++);
		// TODO Auto-generated constructor stub
	}

	public Money(int pValue, String pBrand, int pQty) {
		this.value = pValue;
		this.brand = pBrand;
		this.qty = pQty;

		this.id = Integer.toString(incrementator++);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int pValue) {
		this.value = pValue;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String pBrand) {
		this.brand = pBrand;
	}

}
