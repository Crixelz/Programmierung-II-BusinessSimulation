import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CommandSpeichern implements Command {
	
	public String menuItemName() {
		return "Abspeichern des Fortschritts";

	}
	
	public void execute(ApplicationContext context) {
		
		FileWriter fw = null;
		
		Scanner myScanner = new Scanner(System.in);
		String Verzeichnis = myScanner.next();
		// fuhrpark
		try {
			fw = new FileWriter(new File(Verzeichnis+"fuhrpark.txt"));
			fw.write(context.getFuhrpark().getAnzahl()+";"+context.getFuhrpark().getPreis());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//guthaben
		fw = null;
		try {
			fw = new FileWriter(new File(Verzeichnis+"guthaben.txt"));
			fw.write(context.getGuthaben());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int index = 0;
		//lager
		fw = null;
		try {
			fw = new FileWriter(new File("lager.txt"));
			fw.write(context.getLager().getOrt()+"\n"+context.getLager().getEingelagerteWaren());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
