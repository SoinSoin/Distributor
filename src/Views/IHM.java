/**
 * 
 */
package Views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Models.Distributor;

/**
 * @author Vincent RETORE
 *
 * @createdAt: 20 févr. 2020
 */
public class IHM extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	private Distributor distrib;

	private JPanel container = new JPanel(new GridLayout(0, 3));

	private Label screenMonaie = new Label(); // l'ecran de ma monnaie

	private Label responseToClient = new Label(); // ecran des messages aux clients

	/**
	 * @throws HeadlessException
	 */
	public IHM(Distributor myObjObs) {
		super();
		// TODO Auto-generated constructor stub
		this.distrib = myObjObs;
	}

	public void init(ActionListener al) {
		this.setSize(480, 360);

		JPanel viewToClient = new JPanel(new GridLayout(2, 0));
		viewToClient.setBackground(Color.GRAY);

		this.screenMonaie.setBackground(Color.BLACK);
		this.screenMonaie.setForeground(Color.GREEN);
		this.screenMonaie.setText("" + this.distrib.getMoneyInsert());

		this.responseToClient.setText(this.distrib.getMsg());

		viewToClient.add(screenMonaie);
		viewToClient.add(responseToClient);

		// Container pour inserer les boutons
		JPanel containerBtnBoisson = new JPanel(new GridLayout(0, 2));
		JPanel containerBtnMoney = new JPanel(new GridLayout(0, 2));

		// Génére les boutons pour la monnaie en provenance du distib et ajoute un
		// ecputeur d'evenement
		for (String id : this.distrib.getCoinChange().getHMListItem().keySet()) {
			JButton btn = new BtnMoney("" + this.distrib.getCoinChange().getItemByid(id).getValue(), id);
			btn.addActionListener(al);
			containerBtnMoney.add(btn);
		}

		// Génére les boutons pour les produits en provenance du distib et ajoute un
		// ecputeur d'evenement
		for (String id : this.distrib.getStockProduct().getHMListItem().keySet()) {
			JButton btn = new BtnProduct(this.distrib.getStockProduct().getItemByid(id).getNom() + "\n"
					+ this.distrib.getStockProduct().getItemByid(id).getPrix(), id);
			btn.addActionListener(al);
			containerBtnBoisson.add(btn);
		}

		// ajoute mes container à au cointainer global
		this.container.add(containerBtnBoisson);
		this.container.add(viewToClient);
		this.container.add(containerBtnMoney);

		this.shower();
	}

	public void shower() {
		this.getContentPane().add(this.container);
		this.setVisible(true);
		this.closer();
	}

	public void closer() {
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	/*
	 * ############# CLASS INTERNE ###############
	 */
	private abstract class Button extends JButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5255972105269266837L;

		Button(String name, String idEv, String pTypeBtn) {
			super(name);
			this.setActionCommand(idEv);
			this.putClientProperty("typeBtn", pTypeBtn);
		}

	}

	private class BtnMoney extends Button {

		/**
		 * 
		 */
		private static final long serialVersionUID = 6613424891512221646L;

		public BtnMoney(String name, String idEv) {
			// TODO Auto-generated constructor stub
			super(name, idEv, "btnM");
		}
	}

	private class BtnProduct extends Button {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1300201494509345278L;

		public BtnProduct(String name, String idEv) {
			super(name, idEv, "btnB");
		}
	}

	@Override
	public void update(Observable pDistribObs, Object arg1) {
		// TODO Auto-generated method stub
		Distributor distribObs = (Distributor) pDistribObs;

		this.screenMonaie.setText("" + distribObs.getMoneyInsert()); // affichage argnet rentré

		this.responseToClient.setText(distrib.getMsg()); // message client

	}
}
