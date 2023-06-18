package edu.fiuba.algo3.modelo.Enemigos;

import edu.fiuba.algo3.modelo.Observer.Logger;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.Observer.Emisor;
import edu.fiuba.algo3.modelo.parcelas.Pasarela;
import edu.fiuba.algo3.modelo.miscelanea.Vida;

public class Hormiga extends Enemigo{
    private final int CREDITOS_HORMIGA = 1;

    public Hormiga() {
        super(1, 1, 1);
        this.tipoMovimiento = new MovimientoPasarela(this);
    }

    public Hormiga(Pasarela posicionActual) { //Constructor para test
        super(1, 1, 1);
        this.tipoMovimiento = new MovimientoPasarela(this);
        this.tipoMovimiento.actualizarPosicion(posicionActual);
    }

    public void morir(){
        emisor.notificarSubscriptores("log", "Hormiga muere y otorga " + CREDITOS_HORMIGA + " créditos al jugador");
        Jugador.getInstance().registrarHormigaMuerta();
        Jugador.getInstance().recompensar(CREDITOS_HORMIGA, true);
    }

    public String representacionString() {
        return "Hormiga";
    }
}
