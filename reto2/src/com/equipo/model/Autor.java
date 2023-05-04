package com.equipo.model;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Autor {
    private String name;
    private final String affiliations;
    private final String googleScholarAuthorUrl;

    public Autor(String name, String affiliations, String googleScholarAuthorUrl) {
    	  this.name = name;
          this.affiliations = affiliations;         
          this.googleScholarAuthorUrl = googleScholarAuthorUrl;
    }

    public String getName() {
        return name;
    }

    public String getAffiliations() {
        return affiliations;
    }
    

    public String getGoogleScholarAuthorUrl() {
        return googleScholarAuthorUrl;
    }

  
}