package controleur;

import java.util.List;

import moteur.Couleur;
import moteur.Coup;
import moteur.Pieces;
import moteur.Plateau;
import moteur.Type;

public class Controleur {

	Plateau plateau;
	
	public Controleur() {
		plateau = new Plateau(false, true); //J1 joueur, J2 ia
	}
	
	public String[][] getTabChess() {
		Pieces[][] tabPion  = this.plateau.getPlateau();
		String[][] tabTempo = new String[tabPion.length][tabPion[0].length];
		
		for(int i=0;i<tabTempo.length;i++)
			for(int j=0;j<tabTempo[0].length;j++)
				tabTempo[i][j] = tabPion[i][j].getName();
		
		return tabTempo;
	}

	public Type getType(int[] tab) {
		return this.plateau.getCase(tab[0], tab[1]).getType();
	}
	
	public Couleur getCouleur(int[] tab) {
		return this.plateau.getCase(tab[0], tab[1]).getCouleur();
	}
	
	public Couleur getJoueurAct() {
		return this.plateau.getJoueurAct();
	}
	
	public boolean getJoueurUn_IA() {
		return this.plateau.getJoueurUn_IA();
	}
	
	public boolean getJoueurDeux_IA() {
		return this.plateau.getJoueurDeux_IA();
	}

	public List<Coup> getListCoupPossible(int i, int j) {
		return this.plateau.getListCoupPossible(i,j);
	}

	public boolean jouer(int[] tabCoord, int[] tabCoordFinal) {
		return this.plateau.jouer(tabCoord[0], tabCoord[1], tabCoordFinal[0], tabCoordFinal[1]);
	}
	
	public void jouerIa() {
		this.plateau.jouerIA();
	}
}
