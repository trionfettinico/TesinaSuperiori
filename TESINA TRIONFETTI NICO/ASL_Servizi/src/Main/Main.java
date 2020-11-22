package Main;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import Database.Database;

public class Main extends Database 
{
	// Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8081/ASL/";
    public static Database DB;
    
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in hiplan.web.services.it.hiplan.web.services.it1 package
        final ResourceConfig rc = new ResourceConfig().packages("Servizi");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */

 	public static void main(String[] args) 
 	{
 		// TODO Auto-generated method stub
 		DB = new Database();
 		if(_Connected!=false)
 		{
	 		final HttpServer server = startServer();
	        System.out.println(String.format("Servizio Rest Thron "+"%s\n\nLista Servizi Chiamati ", BASE_URI));
 		}
 	}
}




