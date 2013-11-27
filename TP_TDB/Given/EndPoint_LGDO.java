package Jena_TDB;
import java.util.Properties;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;


public class EndPoint_LGDO {

	  
    public static void main( String[] args ) {
    	/* pour FDS
		Properties systemProperties = System.getProperties();
		systemProperties.setProperty("http.proxyHost","162.38.218.204");
		systemProperties.setProperty("http.proxyPort","3128");
		*/
	String service_ep = "http://linkedgeodata.org/sparql";
	String query = "Prefix lgd:<http://linkedgeodata.org/>  " +
			" Select *  { ?s ?p ?o } " ;
 QueryExecution x = QueryExecutionFactory.sparqlService(service_ep, query);
 ResultSet results = x.execSelect();
 ResultSetFormatter.out(System.out, results);
 
    }
}