package ihm;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import routage.Reseau;

public class ActionAjouterCommutateur extends AbstractAction{
	
	private Reseau reseau;
	private ActionAjouterOrdinateur actionAutre;
	private Fenetre fenetre;
	
	public ActionAjouterCommutateur(Reseau reseau, Fenetre fenetre) {
		super("Ajouter commutateur");
		this.reseau = reseau;
		this.fenetre = fenetre;
	}
	
	public void setActionAutre(ActionAjouterOrdinateur actionAutre) {
		this.actionAutre = actionAutre;
	}
	  
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		reseau.addCommutateur();
		if(reseau.getNbelem() == Reseau.NB_MAX_APPAREIL) {
		      setEnabled(false);
		      actionAutre.setEnabled(false);
		}
		String id = reseau.getLastId();
		fenetre.ajouerItemList(id);
		fenetre.ajouterOrdiList(id);
		fenetre.ajouterCommutateurTable(id);
		if(reseau.reseauConnexe()) {
			fenetre.actionTrouverRoute.setEnabled(true);
			fenetre.actionTrouverTable.setEnabled(true);
		}
		else {
			fenetre.actionTrouverRoute.setEnabled(false);
			fenetre.actionTrouverTable.setEnabled(false);
		}
	}
}
