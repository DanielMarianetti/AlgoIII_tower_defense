
package edu.fiuba.algo3.modelo.Creador;


import edu.fiuba.algo3.modelo.Enemigos.Araña;
import edu.fiuba.algo3.modelo.Enemigos.Enemigo;
import edu.fiuba.algo3.modelo.Enemigos.Hormiga;
import edu.fiuba.algo3.modelo.lectorJSON.Lector;
import edu.fiuba.algo3.modelo.miscelanea.Coordenada;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.parcelas.PasarelaIntermedia;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CreadorEnemigos implements Creador {
    Queue<ArrayList<Enemigo>> colaSpawner;
    public CreadorEnemigos(){
        colaSpawner = new LinkedList<>();
    }

    public Object crear(String direccionArchivoJSON) {
        crearTurnoEnemigos(Lector.leer(direccionArchivoJSON));
        return colaSpawner;
    }

    public void crearTurnoEnemigos(JSONArray listaTurnos) {
        listaTurnos.forEach( turno -> crearTurno( (JSONObject) turno) );
    }

    private void crearTurno(JSONObject turno) {
        final int POSICION_HORMIGAS = 0;
        final int POSICION_ARAÑAS = 1;

        Coordenada coordenadaInicial = new Coordenada(0, 0);
        Pasarela pasarelaInicial = new PasarelaIntermedia(coordenadaInicial, null);

        ArrayList<Enemigo> enemigosTurnoActual = new ArrayList<Enemigo>();

        JSONObject enemigoObject = (JSONObject) turno.get("enemigos");
        JSONArray jsonArray = new JSONArray();

        Iterator x = enemigoObject.keySet().iterator();
        while (x.hasNext()) {
            String key = (String) x.next();
            jsonArray.add(enemigoObject.get(key));
        }
        int cantidadHormigas = ((Long) jsonArray.get(POSICION_HORMIGAS)).intValue();
        for (int i = 0; i < cantidadHormigas; i++) {
            enemigosTurnoActual.add(new Hormiga(pasarelaInicial));
        }
        int cantidadArañas = ((Long) jsonArray.get(POSICION_ARAÑAS)).intValue();
        for (int i = 0; i < cantidadArañas; i++) {
            enemigosTurnoActual.add(new Araña(pasarelaInicial));
        }
        colaSpawner.add(enemigosTurnoActual);
    }
}