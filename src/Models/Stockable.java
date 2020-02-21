/**
 * 
 */
package Models;

/**
 * @author Vincent RETORE
 *
 * @createdAt: 19 févr. 2020
 */
public abstract class Stockable {
	protected String id;
	protected int qty = 0;

	public String getId() {
		return this.id;
	}

	public void addQty() {
		this.qty++;
	}

	public void addQty(int value) {
		this.qty += value;
	}

	public void removeQty() {
		this.qty--;
	}

	public boolean hasAQty() {
		return this.qty > 0;
	};
}
