package br.com.douglassilverio.xadrez_multiplayer

import android.util.Log
import org.junit.Test

class PosicoesPecasTest {

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

    @Test
    fun printarPosicoesTabuleiro(){
        Log.i("Xadrez", tabuleiro[0][0].toString())
        Log.i("Xadrez", tabuleiro[2][1].toString())
    }


}