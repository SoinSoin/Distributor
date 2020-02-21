/**
 * 
 */
package Models;

import java.util.Observable;

/**
 * @author Vincent RETORE
 *
 * @createdAt: 19 févr. 2020
 */
public class Distributor extends Observable {
	/*
	 * 
	 * ########### ATTRIBUTES ############
	 * 
	 */
	private int moneyInsert;

	private String msg;
	private boolean isAnnuled;

	private Stocker<Product> stockProduct = new Stocker<Product>();
	private CoinChange coinChange = new CoinChange();

	/**
	 * 
	 */
	public Distributor() {
		this.isAnnuled = false;
		this.msg = "Séléctionner votre produit";
		this.generateMonney();
		this.generateProduct();
		// TODO Auto-generated constructor stub
	}

	/*
	 * 
	 * ########### SETTER/GETTER ############
	 * 
	 */
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return this.msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String pMsg) {
		this.msg = pMsg;
	}

	public boolean getIsAnnuled() {
		return this.isAnnuled;
	}

	/**
	 * @return the moneyInsert
	 */
	public int getMoneyInsert() {
		return this.moneyInsert;
	}

	/**
	 * @param moneyInsert the moneyInsert to set
	 */
	public void setMoneyInsert(int pMoneyInsert) {
		this.moneyInsert += pMoneyInsert;
	}

	/**
	 * @return the stockProduct
	 */
	public Stocker<Product> getStockProduct() {
		return this.stockProduct;
	}

	/**
	 * @return the coinChange
	 */
	public CoinChange getCoinChange() {
		return this.coinChange;
	}

	/*
	 * 
	 * ########### Methodes ############
	 * 
	 */
	public void rebootMoneyInsert() {
		this.moneyInsert = 0;
	}

	// retourne le produit du client
	public String renderProduct(String id) {
		this.rebootMoneyInsert();
		return this.stockProduct.getItemByid(id).getNom();
	}

	// verifie si la personne à mis pile pole la monnaie
	public boolean hasRenderMoney(String id) {
		return this.moneyInsert == this.stockProduct.getItemByid(id).getPrix();
	}

	// verifi si il y a assez de monnaie pour la boisson
	public boolean hasMoney(String id) {
		return this.moneyInsert >= this.stockProduct.getItemByid(id).getPrix();
	}

	// appelle la methode du monnayeur qui retourne la monanaie
	public String renderMoney() {
		return "";
	}

	// retourne la monnaie du client si il annule
	public String stopped() {
		return "";
	}

	// pour notifier à ma vue par le controller qu'il y a un changement
	public void callerEvent() {
		setChanged();
		notifyObservers();
	}

	// permet de passer à vrai si c'est faux et inversement
	public void toggleIsAnnuled() {
		this.isAnnuled = !this.isAnnuled ? true : false;
	}

	public void generateMonney() {
		this.coinChange.addOneItem(new Money(200, "€", 25));
		this.coinChange.addOneItem(new Money(100, "€", 25));
		this.coinChange.addOneItem(new Money(50, "ct", 25));
		this.coinChange.addOneItem(new Money(20, "ct", 25));
		this.coinChange.addOneItem(new Money(10, "ct", 25));
	}

	public void generateProduct() {
		this.stockProduct.addOneItem(new Product("coca", 90, 0));
		this.stockProduct.addOneItem(new Product("café", 60, 20));
		this.stockProduct.addOneItem(new Product("fanta", 80, 20));
		this.stockProduct.addOneItem(new Product("thé", 50, 20));
	}

}
