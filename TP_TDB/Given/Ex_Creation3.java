package Jena_TDB;
import com.hp.hpl.jena.query.Dataset ;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.shared.PrefixMapping;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.hp.hpl.jena.tdb.store.DatasetGraphTDB;

import java.util.*;
import com.hp.hpl.jena.util.FileManager;

public class Ex_Creation3
{
	public static final String rdf_file_3 = "geonames_v3.rdf";
	
    public static void main(String[] args)
    {
        // Make a TDB-back Jena model in the named directory.
        String directory = "/home/isa/Desktop/My_GeoBase" ;
        Dataset ds = TDBFactory.createDataset(directory) ;
        Model reg = ds.getNamedModel( "gazeetter" );       
        FileManager.get().readModel( reg, rdf_file_3);
        Model	model = null;     
        Iterator<String> graphNames = ds.listNames();
        while (graphNames.hasNext()) {
            String graphName = graphNames.next();       
      model = ds.getNamedModel(graphName);
      		System.out.println("Named graph " + graphName + " size: " + model.size());
       	}  	       
        ds.close();
        
    }
}