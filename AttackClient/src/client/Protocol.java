package client;

public interface Protocol
{
	public static final String MESSAGE = "MSG";
	public static final String JOIN = "NCK";
	public static final String CLOSE = "BYE";
	public static final String USER_LIST= "USR";
	
	public static final String SEPERATOR = "\u001E";
	
	public static String Join(String name) 
	{
		return String.format("%s%s%s", JOIN, SEPERATOR, name);
	}
	
	public static String Message(String msg)
	{
		return String.format("%s%s%s", MESSAGE, SEPERATOR, msg);
	}
}
