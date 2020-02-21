/**
 * 
 */
package Models;

/**
 * @author Vincent RETORE
 *
 * @createdAt: 19 févr. 2020
 */
public class CoinChange extends Stocker<Money> {

	private int renderMoney;

	/**
	 * 
	 */
	public CoinChange() {
		this.renderMoney = 0;
		// TODO Auto-generated constructor stub
	}

	public CoinChange(int pRenderMoney) {
		this.renderMoney = pRenderMoney;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the renderMoney
	 */
	public int getRenderMoney() {
		return this.renderMoney;
	}

	/**
	 * @param renderMoney the renderMoney to set
	 */
	public void setRenderMoney(int pRenderMoney) {
		this.renderMoney = pRenderMoney;
	}

	public CoinChange rendererMoney() {

		return new CoinChange();
	}

}
