package ex2;

import java.time.LocalDate;
public class Blog {
	private String titre;
	private Publiable[] LBillets;
	private static int nbBillet=0;
	public Blog(String titre,int capacite) {
		this.titre=titre;
		this.LBillets=new Publiable[capacite];
	}
	public void post(Publiable billet)throws InvalideURLException {
		if(nbBillet<LBillets.length) {
			if(billet instanceof Image) {
				if(((Video)billet).getUrl().startsWith("HTTPS")==true){
							LBillets[nbBillet]=billet;
							nbBillet++;
						}
				else {
					throw new InvalideURLException("L'URL de la video doit utiliser le protocole HTTPS");
				}
			}
			else {
				LBillets[nbBillet]=billet;
				nbBillet++;
			}
		}
		else
		{
			System.out.println("Le tableau a atteint sa taille maximale");
		}
	}
	public int getNombreBilletsTaggable() {
		int nbr=0;
		for(int i=0;i<nbBillet;i++) {
			if(LBillets[i] instanceof BilletTaggable) {
				nbr++;
			}
		}
		return nbr;
	}
	
	public Publiable[] RechercheBilletsTaggables(String auteur) {
		Publiable[] bt=new Publiable[8];
		int k=0;
		for(int i=0;i<nbBillet;i++) {
			if(LBillets[i] instanceof BilletTaggable) {
				if(LBillets[i].getAuteur().compareTo(auteur)==0) {
					bt[k]=LBillets[i];
					k++;
				}
			}
		}
		return bt;
	}
	
	public Publiable getPlusRecentBillet() {
		Publiable l1=LBillets[0];
		for(int i=1;i<nbBillet;i++) {
			if(LBillets[i] instanceof BilletTaggable) {
				if(LBillets[i].getDatePublication().isAfter(l1.getDatePublication())==true) {
					
				}
			}
		}
	}
	
	

}
