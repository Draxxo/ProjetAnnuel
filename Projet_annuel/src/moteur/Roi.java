package moteur;

import java.util.List;

public class Roi extends Pieces {
	
	public Roi (int PositionX, int PositionY, Type Type, Couleur Couleur) {
		super(PositionX, PositionY, Type, Couleur, "R");
		
		AjoutCoups();
	}
	
	public List<Coup> ListeCoupPossible(List<Coup> ListeCoup, Plateau plateau) {
		
		/*for(int i = 0; i < ListeCoup.size(); i++){
			if(plateau.LireCase(ListeCoup.get(i).getPositionX(), ListeCoup.get(i).getPositionY()).getType() != Type.SansPiece){
				for (int j = i+1; j < ListeCoup.size(); i++){
					
				}
				/*if(plateau.LireCase(ListeCoup.get(i).getPositionX(), ListeCoup.get(i).getPositionY()).getCouleur() == ListeCoup.get(i).getCouleur()){
					
				}//
			}
		}*/
		return ListeCoup;
	}

	public void AjoutCoups() {
		
		ListCoup.add(new Coup(this.getPositionX() + Cardinal.Nord.getPosX(), this.getPositionY() + Cardinal.Nord.getPosY()));
		ListCoup.add(new Coup(this.getPositionX() + Cardinal.Sud.getPosX(), this.getPositionY() + Cardinal.Sud.getPosY()));
		ListCoup.add(new Coup(this.getPositionX() + Cardinal.Est.getPosX(), this.getPositionY() + Cardinal.Est.getPosY()));
		ListCoup.add(new Coup(this.getPositionX() + Cardinal.Ouest.getPosX(), this.getPositionY() + Cardinal.Ouest.getPosY()));
	}
}
