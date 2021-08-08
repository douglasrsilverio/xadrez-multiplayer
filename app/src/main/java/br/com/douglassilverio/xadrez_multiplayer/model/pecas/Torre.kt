package br.com.douglassilverio.xadrez_multiplayer.model.pecas

import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class Torre(private var cor:String, tipo:String, posY:Int, posX:Int) : IPecas {
    override fun getCorPeca(): String {
        TODO("Not yet implemented")
    }

    override fun getTipoPeca(): String {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return if(cor == Constantes.BRANCAS.toString()) Constantes.TORRE_BRANCA.toString()
                else Constantes.TORRE_PRETA.toString()
    }
}