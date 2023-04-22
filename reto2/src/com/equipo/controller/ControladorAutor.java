package com.equipo.controller;
import java.io.IOException;
import java.net.URISyntaxException;
import com.equipo.model.Autor;

public class ControladorAutor {
    private Autor autor;

    public ControladorAutor(Autor autor) {
        this.autor = autor;
    }

    public String performSearch() throws URISyntaxException, IOException, InterruptedException {
        return autor.performSearch();
    }
}
