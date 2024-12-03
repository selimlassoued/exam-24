package ex2;
import java.time.LocalDate;
public class Billet implements Publiable{
	protected LocalDate datePub;
	protected String auteur;
	public Billet(LocalDate datePub,String auteur) {
		this.auteur=auteur;
		this.datePub=datePub;
	}
	public LocalDate getDatePublication() {
		return this.datePub;
	}
	public String getAuteur() {
		return this.auteur;
	}
	public String toString() {
		return "Billet [datePub=" + datePub + ", auteur=" + auteur + "]";
	}
	
}
