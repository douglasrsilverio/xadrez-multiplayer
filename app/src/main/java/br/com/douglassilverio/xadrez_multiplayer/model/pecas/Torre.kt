package br.com.douglassilverio.xadrez_multiplayer.model.pecas

import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class Torre(private var cor:String, tipo:String, posY:Int, posX:Int) : Pecas {

    override fun toString(): String {
        return if(cor == Constantes.BRANCAS.toString()) Constantes.TORRE_BRANCA.toString()
                else Constantes.TORRE_PRETA.toString()
    }
}