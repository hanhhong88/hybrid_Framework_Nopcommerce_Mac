package phoneFactory;

public abstract class PhoneFactory {
	protected String phoneName;
	
	protected abstract void setPhoneName(String phoneName);
	
	protected abstract String getPhoneName();
	
}
