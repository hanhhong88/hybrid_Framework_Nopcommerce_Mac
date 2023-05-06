package phuongHaoNam;

public class CoffeeUrban {
	public String expresso = "Expresso";
	protected String fruit = "Orange";
	String lemonFruit = "lemon";
	private String UrbanMade = "onlyUrban";

	public void shipExpresso() {
		System.out.println("Ship cafe" + expresso);
	}
	
	protected void shipOrange() {
		System.out.println("Ship cafe" + fruit);
	}
	
	void shipLemon() {
		System.out.println("Ship cafe" + lemonFruit);
	}
	
	private void shipUrbanMade() {
		System.out.println("Ship cafe" + UrbanMade);
	}
	
	public static void main(String[] args) {
		CoffeeUrban ownerUrban = new CoffeeUrban();
		ownerUrban.shipExpresso();
		ownerUrban.shipOrange();
		ownerUrban.shipLemon();
		ownerUrban.shipUrbanMade();

	}

}
