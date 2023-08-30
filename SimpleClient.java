import java.net.*;
import java.io.*;

/**
 * SimpleClient class
 *
 * Connects to SimpleServer then reads and prints information
 *
 * Jesse O'Connor
 * 1534760
 */
class SimpleClient {

    static public void main(String[] args) {

	InetAddress ia;

	// gets server-side InetAddress object by DNS name 
	try {
	    ia = InetAddress.getByName(args[0]);
	} catch (UnknownHostException e) {
	    System.err.println("Unknown name");
	    return;
	}
	

	Socket s;
	try {

	    // creates new socket with server-side InetAddress and port number
	    s = new Socket(ia, Integer.parseInt(args[1]));

	    // creates BufferedReader object
	    BufferedReader read = new BufferedReader(
  		new InputStreamReader(s.getInputStream()));

	    // reads lines sent from server (BufferedReader)
	    String line = read.readLine();
	    String line1 = read.readLine();

	    // prints DNS name and IP
	    System.out.println(line);
	    System.out.println(line1);

	} catch (IOException e) {
	    System.err.println("IO Exception" + e);
	    return;
	}
    }
}
