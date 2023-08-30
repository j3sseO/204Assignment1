import java.net.*;

/**
 * resolve class
 *
 * Obtains IPv4 addresses of corresponding DNS names
 *
 * Jesse O'Connor
 * 1534760
 */
class resolve {

    // static global int variable that can be used in catch blocks
    static int i;

    static public void main(String[] args) {
	
	// checks whether there are DNS names to resolve
	if(args.length < 1) {
	    System.err.println("Usage: resolve <name1> <name2> ... <nameN>");
	    return;
	}

	// loops through DNS names
	for (i = 0; i < args.length; i++) {

	    InetAddress ia;

	    // gets InetAddress object by DNS name and grabs corresponding
	    // IP and prints
	    try {
		ia = InetAddress.getByName(args[i]);
		String ip = ia.getHostAddress();
		System.out.println(args[i] + " : " + ip);
	    } catch (UnknownHostException E) {
		System.out.print(args[i] + " : unknown host\n");

	    }
	}
    }
}
    





