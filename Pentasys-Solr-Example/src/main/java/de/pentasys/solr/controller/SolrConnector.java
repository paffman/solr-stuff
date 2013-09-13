package de.pentasys.solr.controller;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.SolrParams;

/**
 * @author André Paffenholz
 * @version 1.0
 * @created 14.07.13
 */
public class SolrConnector {

    private static final String SOLR_URL ="http://localhost:8080/solr/";
    private static final String SOLR_PORT ="8983";

    public static void main(String[] args){
        HttpSolrServer server = new HttpSolrServer(SOLR_URL);
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setFacet(true);
        query.set("wt", "json");
        query.setRows(5);
        query.setStart(0);

        try{
            System.out.println("los geht es...");
            System.out.println(server.getHttpClient().getConnectionManager().getSchemeRegistry().getSchemeNames());
            QueryResponse response = server.query(query);
            System.out.println(response);
        }catch (Exception ex){

        }
    }
}
