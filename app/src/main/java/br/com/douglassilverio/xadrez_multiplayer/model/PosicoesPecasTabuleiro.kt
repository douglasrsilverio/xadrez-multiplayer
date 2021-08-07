package br.com.douglassilverio.xadrez_multiplayer.model

import android.util.Log
import br.com.douglassilverio.xadrez_multiplayer.model.pecas.Torre
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class PosicoesPecasTabuleiro {

    var tb = Torre(Constantes.BRANCAS.toString(),0, 0)


    var tabuleiroPecas: Array<Array<out Any>> = arrayOf(
        arrayOf(tb, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0))

    var tabuleiroViews: Array<Array<out Any>> = arrayOf(
        arrayOf(, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0))

    fun printPosicoesTabuleiro(){
        for ((i, linha) in tabuleiroPecas.withIndex())
            Log.i(Constantes.TABULEIRO.toString(), tabuleiroPecas[i].contentToString())
    }

    fun mapearPosViewToArray(){

    }
}