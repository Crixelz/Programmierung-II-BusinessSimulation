import java.util.Scanner;

public class CommandLoehneFestlegen implements Command {

	@Override
	public String menuItemName() {
		return "Löhne festlegen";
	}

	@Override
	public void execute(ApplicationContext context) {
		
		System.out.println("========== "+menuItemName());
		System.out.println("========== Soll der Lohn der Arbeiter verändert werden? (j/n)");
		Scanner myScanner = new Scanner(System.in);
		String zeichenkette = myScanner.nextLine();
		if (zeichenkette.equals("j")) {
			System.out.println("Wieviel Lohn sollen die Arbeiter erhalten?");
			int lohn = myScanner.nextInt();
		}
		else if (zeichenkette.equals("n")) {

		}
		else {
			System.out.println("Keine gültige Eingabe");
		}
		myScanner.nextLine();
		
	}

}