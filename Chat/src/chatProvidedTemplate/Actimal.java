package chatProvidedTemplate;

import java.security.Permission;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Hashtable;

public class Actimal extends SecurityManager
{
	Hashtable<String, LocalTime> blacklist = null;
	Hashtable<String, LocalTime> log = null;
	String lastIP = null;
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
		if(log.isEmpty())
		{
			System.out.println("Actimal->Log isEmpty");
			lastIP = arg0;
			return;
		}
		else
		{
			if(blacklist.contains(arg0))
			{
				super.checkAccept(arg0, arg1);
			}
			if(log.contains(arg0))
			{
				LocalTime lt = LocalTime.now();
				Long number = log.get(lastIP).until(lt, ChronoUnit.MILLIS);
				if(number < 20)
				{
					blacklist.put(arg0, lt);
					super.checkAccept(arg0, arg1);
				}
				return;
			}
			else
			{
				lastIP = arg0;
			}
		}		
	}

	@Override
	public void checkPermission(Permission perm) { }
	
}
