package phoneFactory;

public class EndUser {
	public static void main(String[] args) {
		PhoneFactory phoneFactory;
		phoneFactory = getPhone("Iphone");
		phoneFactory.setPhoneName("Iphone 14");
		phoneFactory.getPhoneName();

	}
	public static PhoneFactory getPhone(String phoneType) {
		PhoneFactory phoneFactory;
		if(phoneType.equals("IPhone")) {
			phoneFactory = new Iphone();
		} else if (phoneType.equals("Samsung")) {
			phoneFactory = new Samsung();
		} else {
			phoneFactory = new Reno();
		}
		
		return phoneFactory;
		
	}
}
