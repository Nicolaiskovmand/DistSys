import java.io.*; 
import java.net.*; 

public class TcpClient
{  
	
	public static void main(String argv[]) throws Exception  
	{   
		//Opretter Strings til at afsende og modtage
		String sentence;   
		String modifiedSentence;   
		InetAddress IPAddress = InetAddress.getByName("172.17.172.159");
		//InetAddress fort�ller hvilken IP at du skal svare p�
		
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));   
		//Reader input fra user
		
		Socket clientSocket = new Socket(IPAddress, 6789);   
		//Generer en �bning (ClientSocket) i form a localhost igennem port 6789 
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());   
		//DataOutputStream l�ser ClientSocket og f�r info om �bningen gennem denne)
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));   
		//L�ser inputtet fra 
		sentence = inFromUser.readLine();   
		
		outToServer.writeBytes(sentence + '\n');   
		
		modifiedSentence = inFromServer.readLine();   
		
		System.out.println("FROM Mathias: " + modifiedSentence);   
		
		clientSocket.close();  
		} 
	}  
	