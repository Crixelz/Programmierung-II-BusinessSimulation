import java.util.List;
import java.util.Scanner;

public class CommandFuhrwerkeKaufen implements Command {

	@Override
	public String menuItemName() {
		return "Fuhrwerke kaufen";
	}

	@Override
	public void execute(ApplicationContext context) {
	
		System.out.println("========== "+menuItemName());
		System.out.println("========== Wieviele Fuhrwerke sollen gekauft werden?");
		Scanner myScanner = new Scanner(System.in);
		int zuKaufendeFuhrwerke = myScanner.nextInt();
		context.getFuhrpark().kaufen(zuKaufendeFuhrwerke);
		myScanner.nextLine();
	}
}