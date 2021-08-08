package br.com.douglassilverio.xadrez_multiplayer.model

import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.forEach
import br.com.douglassilverio.xadrez_multiplayer.R
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class PosicoesTabuleiro(private var viewTabuleiroActivity: ITabuleiroActivity) {

    private lateinit var tabuleiroArray2D: Array<Array<Posicao?>>

    init {
        inicializarArray2DVazio()
        mapTabuleiroToArray2D()
        printPosicoesTabuleiro()
    }

    private fun inicializarArray2DVazio(){
        tabuleiroArray2D = Array(Constantes.TOTAL_POSICOES_COLUNA.valor){
            arrayOfNulls<Posicao>(Constantes.TOTAL_POSICOES_LINHA.valor)
            }
    }

    private fun printPosicoesTabuleiro() {
        val posicoes = " \n" + tabuleiroArray2D.contentDeepToString()
        Log.i(Constantes.TABULEIRO.text(), posicoes.split("],").joinToString("\n"))
    }

    private fun mapTabuleiroToArray2D(){
        val listaIds = findAllIdsFromViewsInto2DLinearLayout()
        val listaViews = findAllViewsFromIdListAndInsertIntoArray(listaIds)
        insertViewsIntoObjectAndMapToArray2D(listaViews)
    }

    private fun findAllIdsFromViewsInto2DLinearLayout(): ArrayList<Int>{
        val idsTodasPosicoesTabuleiro:ArrayList<Int> = ArrayList()

        val llayoutColuna:LinearLayout = viewTabuleiroActivity.getViewById(R.id.coluna0) as LinearLayout
        llayoutColuna.forEach { linha -> linha as LinearLayout
            linha.forEach {
                    posicao -> idsTodasPosicoesTabuleiro.add(posicao.id)
            }
        }
        return  idsTodasPosicoesTabuleiro
    }

    private fun findAllViewsFromIdListAndInsertIntoArray(listaIds:List<Int>): Array<View?>{
        val arrayView: Array<View?> = Array(Constantes.TOTAL_POSICOES_TABULEIRO.valor) { null }
        for((contadorArray) in arrayView.withIndex()) {
            arrayView[contadorArray] =
                viewTabuleiroActivity.getViewById(listaIds[contadorArray])
        }
        return arrayView
    }

    private fun insertViewsIntoObjectAndMapToArray2D(arrayViews: Array<View?>){
        var linhaContador = Constantes.INIT_VAR_INT_WITH_ZERO.valor
        var colunaContador = Constantes.INIT_VAR_INT_WITH_ZERO.valor
        var arrayViewContador = Constantes.INIT_VAR_INT_WITH_ZERO.valor

        for (linha in tabuleiroArray2D)
            for (posicao in linha) {
                tabuleiroArray2D[linhaContador][colunaContador] = Posicao(viewPosicao = arrayViews[arrayViewContador], linha = linhaContador, coluna = colunaContador)
                arrayViewContador++
                colunaContador++

                if (colunaContador == Constantes.TOTAL_POSICOES_COLUNA.valor) {
                    colunaContador = Constantes.INIT_VAR_INT_WITH_ZERO.valor
                    linhaContador++
                }

                if (linhaContador == Constantes.TOTAL_POSICOES_LINHA.valor && colunaContador == Constantes.TOTAL_POSICOES_COLUNA.valor)
                    return
            }
    }
}