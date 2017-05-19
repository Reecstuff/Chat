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
	LocalTime lastmessage = null;
	public Actimal ()
	{
		blacklist = new Hashtable<String, LocalTime>();		
		log = new Hashtable<String, LocalTime>();
	}

	@Override
	public void checkAccept(String arg0, int arg1)
	{
		System.out.println("Actimal works!");
		
		
		if(blacklist.containsKey(arg0))
		{
			throw new SecurityException();
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
				}
				return;
			}			
			lastIP = arg0;
			log.put(arg0, LocalTime.now());
		}
	}

	@Override
	public void checkPermission(Permission perm) { }
	
	public void checkSpamAttack(String IP)
	{
		LocalTime messagetime = LocalTime.now();
		if(blacklist.containsKey(IP))
		{
			throw new SecurityException();
		}
		if(lastmessage != null)
		{
			Long check = lastmessage.until(messagetime, ChronoUnit.MILLIS);
			
			if(check < 20)
			{
				blacklist.put(IP, messagetime);
				
				throw new SecurityException();
			}
		}
						
		lastmessage = messagetime;
	}
	
	public void addToBlacklist(String IP)
	{
		blacklist.put(IP, LocalTime.now());
	}
	
	public boolean buffercheck(String buffer[], String IP)
	{
		System.out.println("Buffer checked");
		if(buffer.length > 1)
		{
			return true;
		}
		
		else
		{
			addToBlacklist(IP);
			return false;
		}
	}
	
}
