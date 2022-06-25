import java.util.Iterator;
import java.awt.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.naming.Context;


public class BusinessSimulation {


	ApplicationContext appContext;

	Menu mainMenu;

	public BusinessSimulation() {
		this.appContext = new ApplicationContext();
	}

	public void play() {

		initStartzustand();

		mainMenu = initMainMenu();

		int runde = 1;

		while(true) {
			System.out.println("=====================================");
			System.out.println("========== Runde "+runde+" ==========");

			System.out.println("========== TODO: Aktuellen Spielstand ausgeben");
			
			DisplayService.anzeigenLager(appContext);
			DisplayService.anzeigenNiederlassungen(appContext);
			DisplayService.anzeigenGuthaben(appContext);
			// TODO Aktuellen Bestand im Lager ausgeben
			// TODO aktuelle Liste der Niederlassungen ausgeben
			// TODO Guthaben ausgeben

			// mit Hilfe des Menus kann der Spieler seine Ressourcen verwalten
			mainMenu.showMenu();

			// Produktion durchfuehren
			// produzierte Menge vor dem nächsten Rundenbeginn bei allen Niederlassungen abholen und einlagern
			int produzierteMenge;
			Warenart produzierteWarenart;
			System.out.println("========== Produzierte Mengen");
			for (Niederlassung niederlassung : appContext.getNiederlassungen()) {
				niederlassung.produzieren();
				produzierteMenge=niederlassung.abholen();
				produzierteWarenart=niederlassung.getWarenart();
				appContext.getLager().einlagern(produzierteWarenart, produzierteMenge);
				System.out.printf("Ort: %10s Ware: %10s produzierte Menge: %d\n",
						niederlassung.getOrt(),niederlassung.getWarenartString(),produzierteMenge);
			}

			// aufraeumen am Ende der Runde
			appContext.geplanteTransporteZuruecksetzen();
			runde++;
		}
	}

	private void initStartzustand() {
		appContext.addNiederlassung(new Niederlassung("Einbeck", Warenart.BIER, 1));
		appContext.addNiederlassung(new Niederlassung("Wien", Warenart.WEIN, 1));
		appContext.setLager(new Lager("Augsburg"));
		appContext.setFuhrpark(new Fuhrpark(1, 20));
	}

	private Menu initMainMenu() {

		// Untermenu für die Verwaltung der Niederlassungen und Transporte
		Submenu subNiederlassung = new Submenu("Niederlassungen, Anforderungen verwalten", appContext, "Zurück");
		subNiederlassung.setCommand(new CommandAnfordern());
		subNiederlassung.setCommand(new CommandEinstellen());
		subNiederlassung.setCommand(new CommandLoehneFestlegen());

		// Untermenu für die Verwaltung der Fuhrwerke
		Submenu subFuhrpark = new Submenu("Fuhrpark verwalten", appContext, "Zurück");
		subFuhrpark.setCommand(new CommandFuhrwerkeKaufen());
		subFuhrpark.setCommand(new CommandFuhrwerkeVerkaufen());
		// TODO CommandFuhrwerkeReparieren

		// Hauptmenu
		Menu mainMenu = new Menu("Hauptmenu", appContext, "");
		mainMenu.setCommand(new CommandVerkaufen());
		mainMenu.setCommand(subNiederlassung);
		mainMenu.setCommand(subFuhrpark);
		mainMenu.setCommand(new CommandPrintNiederlassungen());
		mainMenu.setCommand(new CommandSpeichern());

		return mainMenu;
	}


}

