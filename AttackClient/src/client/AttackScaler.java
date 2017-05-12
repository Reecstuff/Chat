package client;

public class AttackScaler
{
	private Thread[] threads;
	
	public void stop()
	{
		if(threads == null) return;
		
		for(int i = 0; i < threads.length; i++)
		{
			threads[i].interrupt();
		}
		
		threads = null;
	}
	
	public void scale(Attack attack, int num)
	{
		threads = new Thread[num];
		
		for(int i = 0; i < num; i++)
		{
			threads[i] = new Thread(attack);
		}
		
		for(int i = 0; i < num; i++)
		{
			threads[i].start();
		}
	}
	
	public boolean isRunning()
	{
		return threads != null;
	}
}
