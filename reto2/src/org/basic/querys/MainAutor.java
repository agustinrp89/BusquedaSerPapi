package org.basic.querys;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.equipo.mysql.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONObject;
import java.io.IOException;

public class MainAutor {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://serpapi.com/search.json?engine=google_scholar_author";
        String apiKey = "8e3791e84d353f8461ef13177156611a53c087d9dfa2cdbb9af9566b9856c7d2"; 
        String autor_id = "qc6CJjYAAAAJ";
        String hl = "en";
        int numResults = 10;
        
        Connection conn=null;
    	String bd="top10";
    	String user="root";
    	String pass="cristian26.";
    	String ip="localhost";
    	String puerto="3306";
    	Statement st=null;
    	ResultSet rs=null;
    	String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    	
    	
        String requestUrl = url + "&author_id=" + autor_id + "&hl=" + hl + "&num=" + numResults + "&api_key=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder().uri(new URI(requestUrl)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        
        String json_data = response.body();

        JSONObject data = new JSONObject(json_data);

        String name = data.getJSONObject("author").getString("name");
        String affiliations = data.getJSONObject("author").getString("affiliations");       
        String google_scholar_author_url = data.getJSONObject("search_metadata").getString("google_scholar_author_url");

        System.out.println(name);
        System.out.println(affiliations);     
        System.out.println(google_scholar_author_url);

       try { 
    	   conexion con=new conexion();
		con.miConexion();
		conn=DriverManager.getConnection(cadena,user,pass);
		st=conn.createStatement();
		 String sql = "INSERT INTO top10 (nombre, afiliaciones, url) VALUES ('"+name+"', '"+affiliations+"',  '"+google_scholar_author_url+"')";
         st.executeUpdate(sql);
         
    } catch (SQLException e) {
        e.printStackTrace();
        }
}
}