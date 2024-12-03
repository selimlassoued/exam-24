package ex2;
import java.time.LocalDate;
public class BilletTaggable extends Billet implements Taggable{
	protected String[] LTags;
	protected static int nbTags=0;
	public BilletTaggable(LocalDate datePub,String auteur,int capacite) {
		super(datePub,auteur);
		LTags=new String[capacite];
	}
	public String toString() {
		String ch=super.toString()+" et de "+this.nbTags+"tags: \n";
		for(int i=0;i<nbTags;i++) {
			ch=ch+LTags[i];
		}
		return ch;
	}
	public void ajoutTag(String tag) {
		boolean verif=true;
		if(this.nbTags<LTags.length) {
			for(int i=0;i<nbTags;i++) {
				if(LTags[i].compareTo(tag)==0) {
					verif=false;
				}
			}
		}
		if(verif==true) {
			LTags[nbTags]=tag;
			nbTags++;
		}
	}
	public void supprimeTag(String tag) {
		int i=0;
		while(i<nbTags && LTags[i].compareTo(tag)!=0)
		{
			i++;
		}
		if(i!=nbTags) {
			while(i+1!=nbTags) {
				LTags[i]=LTags[i+1];
			}
			nbTags--;
			System.out.println("Suppression avec succès");
		}
		else {
			System.out.println(tag+" n'est pas présent dans le tableau");
		}
	}
	public int nombreTags() {
		return this.nbTags;
	}
	public int rechercheTag(String tag) {
		int i=0;
		while(i<nbTags && LTags[i].compareTo(tag)!=0) {
			i++;
		}
		if (i==nbTags) {
			return -1;
		}
		else {
			return i;
		}
	}
	
}
