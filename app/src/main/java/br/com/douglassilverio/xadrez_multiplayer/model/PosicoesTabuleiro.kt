package br.com.douglassilverio.xadrez_multiplayer.model

import android.util.Log


class PosicoesTabuleiro {

    var tabuleiro = arrayOf(
        arrayOf("4", 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, "2", 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0)
    )


    fun printarPosicoesTabuleiro(){
        Log.i("Xadrez", tabuleiro[0][1].toString())
        Log.i("Xadrez", tabuleiro[2][1].toString())
    }
}