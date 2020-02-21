/**
 * 
 */
package Models;

import java.util.Map;
import java.util.HashMap;

/**
 * @author Vincent RETORE
 *
 * @createdAt: 19 févr. 2020
 */
public class Stocker<T extends Stockable> {

	protected Map<String, T> listItem = new HashMap<String, T>();

	/**
	 * 
	 */
	public T getItemByid(String id) {
		return this.listItem.get(id);
	}

	public void removeOneItem(String id) {
		this.listItem.remove(id);
	}
	
	
	public void removeOneItem(T stockable) {
		this.listItem.remove(stockable);
	}

	public void addOneItem(T stockable) {
		this.listItem.put(stockable.getId(), stockable);
	}

	public Map<String, T> getHMListItem() {
		return this.listItem;
	}
}
