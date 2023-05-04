package com.equipo.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URISyntaxException;
import com.equipo.model.Autor;
import com.equipo.mysql.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONObject;

public class ControladorAutor {


    private final String authorId;
    private final String language;

    public ControladorAutor(String authorId, String language) {
        this.authorId = authorId;
        this.language = language;
    }
    
    public void insertAuthor() throws IOException, InterruptedException, URISyntaxException {
        HttpClient client = HttpClient.newHttpClient();

        String url = "https://serpapi.com/search.json?engine=google_scholar_author";
        String apiKey = "8e3791e84d353f8461ef13177156611a53c087d9dfa2cdbb9af9566b9856c7d2";
        int numResults = 1;
    
        String requestUrl = url + "&author_id=" + authorId + "&hl=" + language + "&num=" + numResults + "&api_key=" + apiKey;
    
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(requestUrl)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
    
        String json_data = response.body();
        JSONObject data = new JSONObject(json_data);
    
        String name = data.getJSONObject("author").getString("name");
        String affiliations = data.getJSONObject("author").getString("affiliations");       
        String googleScholarAuthorUrl = data.getJSONObject("search_metadata").getString("google_scholar_author_url");

       Autor author = new Autor (name, affiliations, googleScholarAuthorUrl);
       insertAuthorIntoDatabase(author);
    }
    
    	private void insertAuthorIntoDatabase(Autor author) {
    		conexion con=new conexion();
    		con.miConexion();
    		String bd="top10";
    		String user="root";
    		String pass="cristian26.";
        try (Connection conn = DriverManager.getConnection(bd, user, pass);
             Statement stmt = conn.createStatement()) {
             String base = "INSERT INTO authors (name, afiliation,url) VALUES ('" +
                    author.getName() + "', '" +
                    author.getAffiliations() + "', '" +                   
                    author.getGoogleScholarAuthorUrl() + "')";
            stmt.executeUpdate(base);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
