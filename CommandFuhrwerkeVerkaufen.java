import java.util.List;
import java.util.Scanner;

public class CommandFuhrwerkeVerkaufen implements Command {

	@Override
	public String menuItemName() {
		return "Fuhrwerke kaufen";
	}

	@Override
	public void execute(ApplicationContext context) {
	
		System.out.println("========== "+menuItemName());
		System.out.println("========== Wieviele Fuhrwerke sollen verkauft werden?");
		Scanner myScanner = new Scanner(System.in);
		int zuVerkaufendeFuhrwerke = myScanner.nextInt();
		context.getFuhrpark().verkaufen(zuVerkaufendeFuhrwerke);
		myScanner.nextLine();
	}
}