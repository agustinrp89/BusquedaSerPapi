package com.equipo.view;
import com.equipo.controller.ControladorAutor;
import com.equipo.model.Autor;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;


public class Vista {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter author ID: ");
        String author_id = scanner.nextLine();
        System.out.print("Enter API Key: ");
        String apiKey = scanner.nextLine();
        System.out.print("Enter language (e.g. en, es, fr): ");
        String hl = scanner.nextLine();
        System.out.print("Enter number of results: ");
        int numResults = scanner.nextInt();

        String url = "https://serpapi.com/search.json?engine=google_scholar_author";

        
        String searchUrl = url + "&hl=" + hl + "&api_key=" + apiKey;

        Autor autor = new Autor(author_id, apiKey, hl, numResults, searchUrl);
        ControladorAutor controller = new ControladorAutor(autor);

        String searchResult = controller.performSearch();
        System.out.println(searchResult);
    }
}
