import Controllers.ControllerDistributor;
import Models.Distributor;
import Views.IHM;

/**
 * 
 */

/**
 * @author Vincent RETORE
 *
 * @createdAt: 19 févr. 2020
 */
public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Model
		Distributor model = new Distributor();
		
		// view
		IHM menu = new IHM(model);
		
		//Controller
		ControllerDistributor ctrl = new ControllerDistributor(model);
		
		// je donne à ma l'action contoller 
		menu.init(ctrl);
		menu.shower();
		
		// je dit à mon model qu'il va etre observer par mon menu 
		model.addObserver(menu);	// add observer Methode herité d'observable 
	}

}
