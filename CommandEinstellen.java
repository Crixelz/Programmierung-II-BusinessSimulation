import java.util.List;
import java.util.Scanner;

public class CommandEinstellen implements Command {

	@Override
	public String menuItemName() {
		return "Arbeitende einstellen";
	}

	@Override
	public void execute(ApplicationContext context) {
		// TODO Auto-generated method stub

		boolean scannerErfolg=false;

		// Variable für Eingabe der zu verkaufenden Menge
		int auswahlNiederlassungIndex=0;

		int indexNdls = 0;

		// Liste der Niederlassungen ausgeben
		System.out.println("========== "+menuItemName());
		System.out.println("========== In welcher Niederlassung sollen Arbeiter eingestellt werden?");
		List<Niederlassung> listeNiederlassung = context.getNiederlassungen();


		for (indexNdls = 0; indexNdls < listeNiederlassung.size(); indexNdls++) {
			System.out.println(listeNiederlassung.get(indexNdls));
		}
		Scanner myScanner = new Scanner(System.in);
		while(!scannerErfolg) {
			try {
				System.out.print("Auswahl:");
				auswahlNiederlassungIndex = myScanner.nextInt();
				scannerErfolg=true;
				myScanner.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				scannerErfolg=false;
				myScanner.nextLine();
			}

			if(auswahlNiederlassungIndex==indexNdls) {
				// Verlassen des Menus
				return;
			}
			int anzahlZuEinstellendeArbeitende=0;
			scannerErfolg=false;
			while(!scannerErfolg) {
				try {
					System.out.print("Anzahl der einzustellenden Arbeitenden:");
					anzahlZuEinstellendeArbeitende = myScanner.nextInt();
					listeNiederlassung.get(auswahlNiederlassungIndex).einstellen(anzahlZuEinstellendeArbeitende);
					scannerErfolg=true;
					myScanner.nextLine();
				} catch (Exception e) {
					e.printStackTrace();
					scannerErfolg=false;
					myScanner.nextLine();
				}
			}

		}
	}
}