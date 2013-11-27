package Jena_TDB;

import com.hp.hpl.jena.query.Dataset ;
import com.hp.hpl.jena.query.Query ;
import com.hp.hpl.jena.query.QueryExecution ;
import com.hp.hpl.jena.query.QueryExecutionFactory ;
import com.hp.hpl.jena.query.QueryFactory ;
import com.hp.hpl.jena.query.ResultSet ;
import com.hp.hpl.jena.query.ResultSetFormatter ;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.tdb.TDBFactory ;
import com.hp.hpl.jena.vocabulary.RDF;


public class Ex_Consultation_Sparql_Geonames
{
	 public static final String NL = System.getProperty("line.separator") ;
    public static void main(String[] args)
    {
        // Direct way: Make a TDB-back Jena model in the named directory.
        String directory = "/home/isa/Desktop/My_GeoBase" ;
        Dataset dataset = TDBFactory.createDataset(directory) ;
        Model reg = dataset.getNamedModel( "geo" );  
        Model gz = dataset.getNamedModel( "gazeetter");
        // idem que interrogation sur le dataset
        Model dm = dataset.getDefaultModel();  
        
    	String gn = gz.getNsPrefixURI("gn");
    	String skos = gz.getNsPrefixURI("skos");
		   
    	String prolog1 = "PREFIX geonames: <"+gn+">" ;
        String prolog2 = "PREFIX rdf: <"+RDF.getURI()+">" ;
        String prolog3 = "PREFIX skos: <"+skos+">" ;
        // Query string.
        String sparqlQueryString = prolog1 + NL + prolog2 + NL + prolog3 + NL +
            "SELECT ?i ?d WHERE { ?i rdf:type geonames:Code ." +
            " ?i skos:definition ?d ." +
            " ?i skos:inScheme geonames:A} " ;
           
        Query query = QueryFactory.create(sparqlQueryString) ;
        QueryExecution qexec = QueryExecutionFactory.create(query, gz) ;
        ResultSet results = qexec.execSelect() ;
        ResultSetFormatter.out(results) ;
        qexec.close() ;

        dataset.close();
    }
}