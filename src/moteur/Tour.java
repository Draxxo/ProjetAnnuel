package moteur;

import java.util.List;

public class Tour extends Pieces {
	
	public Tour (int PositionX, int PositionY, Type Type, Couleur Couleur) {
		super(PositionX, PositionY, Type, Couleur, "T");
		
		AjoutCoups();
	}
	
	public List<Coup> getListeCoupPossible(List<Coup> listeCoup, Plateau plateau) {

		System.out.println(listeCoup);
		int a = 0;
		if (this.getPositionX() < 9) {
			for(int i=0;i<getListCoup().size();i++)
				if(plateau.getCase(listeCoup.get(a).getPosX(), listeCoup.get(a).getPosY()).getType() == Type.SansPiece)
					if (this.getPositionX() < listeCoup.get(a).getPosX())
						a = i;
			
			if (plateau.getCase(listeCoup.get(a).getPosX(), listeCoup.get(a).getPosY()).getCouleur().oppose(this.getCouleur())) {
				a++;
			}
			
			for (int i = 8 - this.getPositionX(); i >= a; i--) {
				listeCoup.remove(i);
			}
		}
		System.out.println(listeCoup);
		
		int b = a;
		if (this.getPositionX() > 0) {
			for(int i=a;i<getListCoup().size();i++)
				if(plateau.getCase(listeCoup.get(b).getPosX(), listeCoup.get(b).getPosY()).getType() == Type.SansPiece)
					if (this.getPositionX() != listeCoup.get(b).getPosX())
						b = i;
			
			if (plateau.getCase(listeCoup.get(b).getPosX(), listeCoup.get(b).getPosY()).getCouleur().oppose(this.getCouleur())) {
				b++;
			}
			
			for (int i = this.getPositionX() + a - 1; i >= b; i--) {
				listeCoup.remove(i);
			}
		}
		System.out.println(listeCoup);
		
		int c = b;
		if (this.getPositionY() < 8) {
			for(int i=b;i<getListCoup().size();i++)
				if(plateau.getCase(listeCoup.get(c).getPosX(), listeCoup.get(c).getPosY()).getType() == Type.SansPiece)
					if (this.getPositionY() < listeCoup.get(c).getPosY())
						c = i + 1;
			
			if (plateau.getCase(listeCoup.get(c).getPosX(), listeCoup.get(c).getPosY()).getCouleur().oppose(this.getCouleur())) {
				c++;
			}

			for (int i = b + 7 - this.getPositionY(); i >= c; i--) {
				listeCoup.remove(i);
			}			
		}
		System.out.println(listeCoup);
		
		int d = c;
		if (this.getPositionY() > 0) {
			for(d=c;d<getListCoup().size();d++)
				if(plateau.getCase(listeCoup.get(d).getPosX(), listeCoup.get(d).getPosY()).getType() != Type.SansPiece)
					break;
			
			boolean sauver = false;
			Coup savegarde = null;

			if (d < listeCoup.size()) {
				if (plateau.getCase(listeCoup.get(d).getPosX(), listeCoup.get(d).getPosY()).getCouleur().oppose(this.getCouleur())) {
					sauver = true;
					savegarde = new Coup(listeCoup.get(d).getPosX(), listeCoup.get(d).getPosY());
				}
			}
			
			for (int i = c + this.getPositionY() - 1; i >= d; i--) {
				listeCoup.remove(i);
			}
			if (sauver) {
				listeCoup.add(savegarde);
			}
		}
		System.out.println(listeCoup);
		return plateau.estEchec(this, listeCoup);
	}

	public void AjoutCoups() {
		List<Coup> liste = this.getListCoup();
		liste.clear();
		
		for(int i = this.getPositionX() + 1; i < 10; i++){
			liste.add(new Coup(i, this.getPositionY()));
		}
		
		for(int i = this.getPositionX() - 1; i >= 0; i--){
			liste.add(new Coup(i, this.getPositionY()));
		}
		
		for(int i = this.getPositionY() + 1; i < 9; i++){
			liste.add(new Coup(this.getPositionX(), i));
		}
		
		for(int i = this.getPositionY() - 1; i >= 0; i--){
			liste.add(new Coup(this.getPositionX(), i));
		}
	}
}
