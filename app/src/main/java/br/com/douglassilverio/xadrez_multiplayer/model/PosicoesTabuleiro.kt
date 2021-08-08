package br.com.douglassilverio.xadrez_multiplayer.model

import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.forEach
import br.com.douglassilverio.xadrez_multiplayer.R
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class PosicoesTabuleiro(private var viewTabuleiroActivity: ITabuleiroActivity) {

    private var posicao:Posicao = Posicao(null, null, null, null)
    private var tabuleiroArray2D: Array<Array<Posicao>> = Array(8) { Array(8) { posicao } }

    init {
        mapTabuleiroToArray2D()
        printPosicoesTabuleiro()
    }

    private fun printPosicoesTabuleiro() {
        val posicoes = " \n" + tabuleiroArray2D.contentDeepToString()
        Log.i(Constantes.TABULEIRO.text(), posicoes.split("],").joinToString("\n"))
    }

    private fun mapTabuleiroToArray2D(){
        val listaIds = findAllIdsFromViewsInto2DLinearLayout()
        val listaViews = findAllViewsFromIdListAndInsertIntoArray(listaIds)
        insertViewsFromArrayViewIntoObjectAndMapToArray2D(listaViews)
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
        val arrayView: Array<View?> = Array(64) { null }
        for((contadorArray) in arrayView.withIndex()) {
            arrayView[contadorArray] =
                viewTabuleiroActivity.getViewById(listaIds[contadorArray])
        }
        return arrayView
    }

    private fun insertViewsFromArrayViewIntoObjectAndMapToArray2D(arrayViews: Array<View?>){
        var linhaContador = 0
        var colunaContador = 0
        var arrayViewContador = 0

        for (linha in tabuleiroArray2D)
            for (posicao in linha) {
                tabuleiroArray2D[linhaContador][colunaContador] = Posicao(viewPosicao = arrayViews[arrayViewContador], linha = linhaContador, coluna = colunaContador)
                arrayViewContador++
                colunaContador++

                if (colunaContador == 8) {
                    colunaContador = 0
                    linhaContador++
                }

                if (linhaContador == 8 && colunaContador == 8)
                    return
            }
    }
}