package chatProvidedTemplate;

import java.security.Permission;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Hashtable;

public class Actimal extends SecurityManager
{
	Hashtable<String, LocalTime> blacklist = null;
	Hashtable<String, LocalTime> log = null;
	String lastIP = "";
	public Actimal ()
	{
		blacklist = new Hashtable<String, LocalTime>();		
		log = new Hashtable<String, LocalTime>();
	}

	@Override
	public void checkAccept(String arg0, int arg1)
	{
		System.out.println("Actimal works!");
		log.put(arg0, LocalTime.now());
		
		if(blacklist.containsKey(arg0))
		{
			throw new SecurityException();
			//super.checkAccept(arg0, arg1);
		}
		else
		{
						
			if(lastIP.equals(arg0))
			{
				LocalTime lt = LocalTime.now();
				Long number = log.get(lastIP).until(lt, ChronoUnit.MILLIS);
				if(number < 20)
				{
					blacklist.put(arg0, lt);
					throw new SecurityException();
					//super.checkAccept(arg0, arg1);
					
				}
				return;
			}
			
			lastIP = arg0;
		}
		
		
			
	}

	@Override
	public void checkPermission(Permission perm) { }
	
}
