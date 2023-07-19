package phoneWithoutFactory;

public class EndUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iphone iphone = new Iphone();
		
		iphone.setPhoneName("iphone14");
		System.out.println(iphone.getPhoneName());
		
		Samsung sam = new Samsung();
		
		sam.setPhoneName("Samsung GS24");
		System.out.println(sam.getPhoneName());
		
		Reno re = new Reno();
		
		re.setPhoneName("Reno 8");
		System.out.println(re.getPhoneName());

	}

}
