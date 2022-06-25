import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisplayService {

	public static void anzeigenNiederlassungen(ApplicationContext context) {
		List<Niederlassung> ListeNiederlassung = context.getNiederlassungen();
		
		System.out.println("========== Niederlassungen ==========");
		System.out.println("Ort\t Warenart\t Status\t gesendete Fuhrwerke\t Arbeiter");
		
		int indexNdls;
		
		for (indexNdls = 0; indexNdls < ListeNiederlassung.size(); indexNdls++) {
			
			ArrayList<Niederlassung> listeAllerNiederlassungen = context.getNiederlassungen();
			Niederlassung eineBestimmteNiederlassung = listeAllerNiederlassungen.get(indexNdls);
			String derOrtsname = eineBestimmteNiederlassung.getOrt();
			Warenart warenartDerBestimmtenNiederlassung = eineBestimmteNiederlassung.getWarenart();
			String wurdeProduktionAngefordert = eineBestimmteNiederlassung.wurdeAngefordert() ? "angefordert" : "nicht angefordert";
			int momentaneArbeiter = eineBestimmteNiederlassung.getArbeitende();
			
			
			System.out.println(derOrtsname+"\t"+warenartDerBestimmtenNiederlassung+"\t"+wurdeProduktionAngefordert+"\t"+momentaneArbeiter);
			// Still missing send carts
			
		}
		
	}
	
	public static void anzeigenLager(ApplicationContext context) {

		System.out.println("========== Lagerbestand ==========");
		for (Iterator<Warenart> warenartIterator = context.getLager().getEingelagerteWaren().iterator(); warenartIterator.hasNext();) {
			Warenart warenart = (Warenart) warenartIterator.next();
			System.out.println(Util.convertWarenartToString(warenart)+": "+context.getLager().getBestand(warenart));
		}
		System.out.println("====================");
	
	}
	
	public static void anzeigenGuthaben(ApplicationContext context) {

		System.out.println("========== Guthaben ==========");
		System.out.println(context.getGuthaben());
		System.out.println("====================");
	
	}
	
	
	
}
