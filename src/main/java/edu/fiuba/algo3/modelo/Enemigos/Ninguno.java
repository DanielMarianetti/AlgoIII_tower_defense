package edu.fiuba.algo3.modelo.Enemigos;

import edu.fiuba.algo3.modelo.Excepciones.PasarelaInexistente;
import edu.fiuba.algo3.modelo.lectorJSON.Mapa;

public class Ninguno implements Efecto{
    @Override
    public Efecto avanzar(int cantPasos, Movimiento movimientoEnemigo, Mapa mapa) throws PasarelaInexistente {
        movimientoEnemigo.avanzar(cantPasos, mapa);

        return this;
    }
}
