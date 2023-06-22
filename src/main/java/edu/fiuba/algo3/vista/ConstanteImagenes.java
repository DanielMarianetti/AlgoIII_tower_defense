package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class ConstanteImagenes {
    private static Map<String, String> diccionarioImagenes;

    static {
        diccionarioImagenes =  Map.of(
                "Araña", "ImagenesGUI/arania.png",
                "Hormiga", "ImagenesGUI/hormiga.png",
                "Lechuza", "ImagenesGUI/lechuza.png",
                "TorreBlanca", "ImagenesGUI/torreBlanca.png",
                "TorrePlateada", "ImagenesGUI/torrePlateada.png" );
    }

    public static ImageView getImagen(String imagenBuscada) throws FileNotFoundException {
        InputStream stream = new FileInputStream((String) diccionarioImagenes.get(imagenBuscada));
        ImageView image = new ImageView((new Image(stream)));
        image.setFitHeight(60);
        image.setFitWidth(60);
        return image;
    }
}
