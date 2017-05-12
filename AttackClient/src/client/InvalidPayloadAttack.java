package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class InvalidPayloadAttack extends BaseAttack
{
	private ArrayList<byte[]> binaryTestCases;
	private ArrayList<String> textTestCases;
	
	
	public InvalidPayloadAttack(String host, int port)
	{
		super(host, port);
		binaryTestCases = new ArrayList<byte[]>();
		textTestCases = new ArrayList<String>();
				
		binaryTestCases.add(new byte[1024]);
		binaryTestCases.add(new byte[] {0, 50});
		binaryTestCases.add(new byte[] {0, 1, 0, 0});
		
		textTestCases.add("");
		textTestCases.add("INVALID");
		textTestCases.add(Protocol.Join(""));
		textTestCases.add(Protocol.SEPERATOR);
		textTestCases.add(Protocol.SEPERATOR+Protocol.SEPERATOR);
		textTestCases.add(Protocol.JOIN + Protocol.SEPERATOR + Protocol.SEPERATOR);
	}
	
	@Override
	public void execute() throws IOException
	{
		for(byte[] b : binaryTestCases)
		{
			new Socket(host, port).getOutputStream().write(b);
		}
		
		for(String s : textTestCases)
		{
			new DataOutputStream(new Socket(host, port).getOutputStream()).writeUTF(s);
		}
	}
}
