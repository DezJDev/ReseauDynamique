package routage;

import java.util.ArrayList;
import java.util.Stack;

public class RoutePlusCourteChercheur {

	private Reseau reseau;
	private Appareil appareilA, appareilB;
	private Appareil appCourant;
	private ArrayList<Appareil> nonVisite;
	private ArrayList<Appareil> visite;

	public RoutePlusCourteChercheur(Reseau reseau, Appareil appareilA, Appareil appareilB) {
		this.reseau = reseau;
		this.appareilA = appareilA;
		this.appareilB = appareilB;
		this.appCourant = this.appareilA;
		this.nonVisite = new ArrayList<>(reseau.getAppareils());
		this.visite = new ArrayList<>();

	}

	public Route getCheminPlusCourt() {
		preparerGraph();
		while (!(this.nonVisite.isEmpty())) {
			checkVoisinnage();
			deplacer();

		}
		Route resultat = getRoute();
		return resultat;
	}

	public ArrayList<Appareil> getTable() {

		return null;
	}

	private void checkVoisinnage() {
		for (Artere e : appCourant.getTabArtere()) {
			Appareil voisin;

			if (this.appCourant == e.getAppareilUn()) {
				voisin = e.getAppareilDeux();
			} else {
				voisin = e.getAppareilUn();
			}
			int distance = e.getPoid() + appCourant.getDistance();
			if (voisin.getDistance() > distance) {
				voisin.setDistance(distance);
				voisin.setPrecedent(appCourant);
			}
		}

		this.nonVisite.remove(appCourant);
		this.visite.add(appCourant);
	}

	private void deplacer() {
		if (!(this.nonVisite.isEmpty())) {
			Appareil courant = this.nonVisite.get(0);
			for (Appareil e : this.nonVisite) {
				if (e.getDistance() < courant.getDistance()) {
					courant = e;
				}
			}
			this.appCourant = courant;
		}
	}

	private void preparerGraph() {
		for (Appareil e : reseau.getAppareils()) {
			e.setPrecedent(null);
			e.setDistance(Integer.MAX_VALUE);
		}
		appareilA.setDistance(0);
	}

	private Route getRoute() {
		Route route = new Route();
		this.appCourant = this.appareilB;
		route.setPoids(this.appCourant.getDistance());
		Stack<Appareil> etapes = new Stack<>();

		while (this.appCourant != this.appareilA) {
			etapes.push(appCourant);
			this.appCourant = this.appCourant.getPrecedent();
		}
		etapes.push(appCourant);

		while (!(etapes.isEmpty())) {
			route.addAppareil(etapes.pop());
		}
		return route;
	}

}
