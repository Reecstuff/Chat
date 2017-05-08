package chatProvidedTemplate;

import java.time.LocalTime;
import java.util.Hashtable;

public class Actimal extends SecurityManager
{
	Hashtable<String, LocalTime> ht = new Hashtable<String, LocalTime>();
	public Actimal ()
	{
		
	}

	@Override
	public void checkAccept(String arg0, int arg1)
	{
		if(ht.isEmpty())
		{
			return;
		}
		if(ht.contains(arg0))
		{
			super.checkAccept(arg0, arg1);
		}
	}	
}
