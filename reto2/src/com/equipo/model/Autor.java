package com.equipo.model;



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