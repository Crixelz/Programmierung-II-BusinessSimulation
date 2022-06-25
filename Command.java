public interface Command {

	public String menuItemName();
	
	public void execute(ApplicationContext context);
	
}