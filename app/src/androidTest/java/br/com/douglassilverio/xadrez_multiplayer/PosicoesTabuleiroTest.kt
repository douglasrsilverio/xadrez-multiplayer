package br.com.douglassilverio.xadrez_multiplayer

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.douglassilverio.xadrez_multiplayer.model.pecas.Torre
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class PosicoesTabuleiroTest {

    var tb = Torre(Constantes.P1.toString(),0, 0)

    var tabuleiro: Array<Array<Any>> = arrayOf(
        arrayOf(tb, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0))

    @Test
    fun printPosicoesTabuleiro(){
        var posicoes = " \n" + tabuleiro.contentDeepToString()
        Log.i(Constantes.TABULEIRO.toString(), posicoes.split("],").joinToString("\n"))
    }

}