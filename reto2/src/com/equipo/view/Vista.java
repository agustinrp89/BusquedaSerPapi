package com.equipo.view;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import com.equipo.controller.ControladorAutor;
import com.equipo.model.Autor;
import com.equipo.mysql.conexion;

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

    	conexion con=new conexion();
		con.miConexion();
		
        ControladorAutor ControladorAutor = new ControladorAutor(author_id, hl);
        ControladorAutor.insertAuthor();
    }
}