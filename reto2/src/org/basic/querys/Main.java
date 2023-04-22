package org.basic.querys;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://serpapi.com/search.json?engine=google_scholar";
        String apiKey = "keyapi"; 
        String query = "";
        String autor = "";
        String hl = "";
        int numResults = ;
       
              
        if (args.length > 0) {
            autor = "&author=" + args[0];
        }

              
        String requestUrl = url + "&q=" + query + "&hl=" + hl + "&num=" + numResults + autor +  "&api_key=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder().uri(new URI(requestUrl)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
