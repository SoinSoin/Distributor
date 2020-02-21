/**
 * 
 */
package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Models.Distributor;

/**
 * @author Vincent RETORE
 *
 * @createdAt: 20 févr. 2020
 */
public class ControllerDistributor implements ActionListener {

	/**
	 * 
	 */

	protected Distributor distrib;

	public ControllerDistributor(Distributor pDistrib) {
		// TODO Auto-generated constructor stub
		this.distrib = pDistrib;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		JButton source = (JButton) event.getSource();
		String id = (String) source.getClientProperty("typeBtn");

		switch (id) {
		case "btnB":
			this.targetBtnEventProduct(event.getActionCommand());
			break;
		case "btnM":
			this.distrib.setMoneyInsert(this.distrib.getCoinChange().getItemByid(event.getActionCommand()).getValue());
			this.distrib.callerEvent();
			break;
		default:
				//annuler
			break;
		}
	}

	private void targetBtnEventProduct(String id) {
		if (this.distrib.getStockProduct().getItemByid(id).hasAQty()) {

			if (this.distrib.hasMoney(id)) {

				if (this.distrib.hasRenderMoney(id)) {
					this.distrib.setMsg(this.distrib.getStockProduct().getItemByid(id).getNom());
				} else {
					this.distrib.setMsg(this.distrib.getStockProduct().getItemByid(id).getNom() + " ta monnaie");
				}
			} else {
				this.distrib.setMsg("Inserer plus d'argent");
			}

		} else {
			this.distrib.setMsg("Il n'y plus de ce produit");
		}
		this.distrib.callerEvent();
	}
}
