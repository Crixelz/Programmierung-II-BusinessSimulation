import java.util.List;

public class CommandPrintNiederlassungen implements Command {

	@Override
	public String menuItemName() {
		return "Niederlassungen ausgeben";
	}

	@Override
	public void execute(ApplicationContext context) {
		
		System.out.println("========== "+menuItemName());

		List<Niederlassung> listeNiederlassung = context.getNiederlassungen();
		
		for(int indexNdls=0; indexNdls<listeNiederlassung.size(); indexNdls++) {
			System.out.println(listeNiederlassung.get(indexNdls).getOrt()+"\t\t"+listeNiederlassung.get(indexNdls).getWarenartString());
		}
		
	}


}
