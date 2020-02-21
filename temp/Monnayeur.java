import java.util.Observable;

/**
 * 
 */


/**
 * @author Vincent RETORE
 *
 * @createdAt: 7 févr. 2020
 */


public class Monnayeur extends Observable{
	private final Money[] LIST_MONEY;
	private int[] stockPieces = { 5, 5, 5, 5, 5 };

	public Monnayeur(Money[] pListMoney) {
		this.LIST_MONEY=pListMoney;
	}

	/**
	 * @return the list of money
	 */
	public Money[] getListMoney() {
		return this.LIST_MONEY;
	}

	/**
	 * @return the stockPieces
	 */
	public int[] getStockPieces() {
		return this.stockPieces;
	}

	/**
	 * @param pStockPieces
	 */
	public void setStockPieces(int[] pStockPieces) {
		this.stockPieces = pStockPieces;
	}

	/*
	 * @boolean
	 * @param int testValuePiece 
	 * verifie si la monnaie est prise en compte par le monnayeur
	 * 
	 * 
	 */
	public boolean isAcceptMoney(int testValuePiece) {
		for (int iValuePiece = 0; iValuePiece < this.LIST_MONEY.length; iValuePiece++) {
			if (this.LIST_MONEY[iValuePiece].isExist(testValuePiece)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	/*
	 * @void
	 * @param int morePiece 
	 * ajoute plus 1 au stocke de la monnaie
	 * 
	 * 
	 */
	public void addStockMoney(int morePiece) {
		for (int iValuePiece = 0; iValuePiece < this.LIST_MONEY.length; iValuePiece++) {
			if (this.LIST_MONEY[iValuePiece].isExist(morePiece)) {
				this.getStockPieces()[iValuePiece]++;
				System.out.println(this.getStockPieces()[iValuePiece]);
			}
		}
		setChanged();
		notifyObservers();
	}
	
	
	/*
	 * 
	 * @param int lessPiece
	 * enleve un au stock des pieces
	 * 
	 * 
	 */
	public void removeStockMoney(int lessPiece) {
		for (int iValuePiece = 0; iValuePiece < this.LIST_MONEY.length; iValuePiece++) {
			if (this.LIST_MONEY[iValuePiece].isExist(lessPiece)) {
				this.getStockPieces()[iValuePiece]--;
			}
		}
	}

	/*
	 * @String
	 * @param int pChangeCurrency la monnaie à remboursé
	 *  applique la méthode recursive calcRenderMonney qui balise toute les possibilité
	 * 
	 * 
	 */
	public String renderMonney(int pChangeCurrency) {
		return this.calcRenderMonney((int) this.getListMoney().length, pChangeCurrency, "", 0); 
	}
	
	/*
	 * @String
	 * @param int nValPiece, int currentPriceMonney, String returnMoney, int currentNbPieceRender
	 * applique la méthode recursive calcRenderMonney qui balise toute les possibilité
	 * 
	 * 
	 */
	private String calcRenderMonney(int nValPieces, int currentPriceRender, String returnMoney, int currentNbPiecesRender) {
		if (currentPriceRender == 0) {
			// TODO: Remove stock
			return returnMoney;
		}
		if (nValPieces == 0) return returnMoney;
		for (int newNbPiecesRender = MyService.min((int) (currentPriceRender / this.getListMoney()[nValPieces - 1].getValueMoney()),this.getStockPieces()[nValPieces - 1]); newNbPiecesRender >= 0; newNbPiecesRender--) {

			String newReturnMoney = returnMoney;
			if (newNbPiecesRender != 0) {
				newReturnMoney += " | " + (double) this.getListMoney()[nValPieces - 1].getValueMoney() / 100 + " "+ this.getListMoney()[nValPieces - 1].getBrand() + " x " + newNbPiecesRender;
			}
			return this.calcRenderMonney(nValPieces - 1,currentPriceRender - (newNbPiecesRender * this.getListMoney()[nValPieces - 1].getValueMoney()), newReturnMoney, newNbPiecesRender);
		}
		return returnMoney;
	}
}
