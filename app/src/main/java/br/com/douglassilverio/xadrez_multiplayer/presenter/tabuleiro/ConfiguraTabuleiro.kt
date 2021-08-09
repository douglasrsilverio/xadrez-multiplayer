package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.forEach
import br.com.douglassilverio.xadrez_multiplayer.R
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.PosicaoDto
import br.com.douglassilverio.xadrez_multiplayer.model.pecas.IPecas
import br.com.douglassilverio.xadrez_multiplayer.model.pecas.Torre
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class ConfiguraTabuleiro(private var tabuleiroPresenter: ITabuleiroPresenter) {

    private lateinit var tabuleiroArray2D: Array<Array<PosicaoDto?>>

    init {
        mapTabuleiroToArray2D()
        inserirPecasIniciaisJogadorUm(Constantes.BRANCAS.text()) //Pegar cor de um objeto do tipo Jogador passado como parâmetro no construtor, cor deve ser random
        printPosicoesTabuleiro()
    }

    fun printPosicoesTabuleiro() {
        val posicoes = " \n" + tabuleiroArray2D.contentDeepToString()
        Log.i(Constantes.TABULEIRO.text(), posicoes.split("],").joinToString("\n"))
    }

    private fun inicializarArray2DVazio(){
        tabuleiroArray2D = Array(Constantes.TOTAL_POSICOES_COLUNA.valor){
            arrayOfNulls<PosicaoDto>(Constantes.TOTAL_POSICOES_LINHA.valor)
        }
    }

    private fun mapTabuleiroToArray2D(){
        inicializarArray2DVazio()

        val listaIds = findAllIdsFromViewsInto2DLinearLayout()
        val listaViews = findAllViewsFromIdListAndInsertIntoArray(listaIds)
        insertViewsIntoObjectAndMapToArray2D(listaViews)
    }

    private fun findAllIdsFromViewsInto2DLinearLayout(): ArrayList<Int>{
        val idsTodasPosicoesTabuleiro:ArrayList<Int> = ArrayList()

        val llayoutColuna:LinearLayout = tabuleiroPresenter.getViewById(R.id.coluna0) as LinearLayout
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
                tabuleiroPresenter.getViewById(listaIds[contadorArray])
        }
        return arrayView
    }

    private fun insertViewsIntoObjectAndMapToArray2D(arrayViews: Array<View?>){
        var rowCounter = Constantes.INIT_VAR_INT_WITH_ZERO.valor
        var colCounter = Constantes.INIT_VAR_INT_WITH_ZERO.valor
        var arrayViewContador = Constantes.INIT_VAR_INT_WITH_ZERO.valor

        for (linha in tabuleiroArray2D)
            for (posicao in linha) {
                tabuleiroArray2D[rowCounter][colCounter] =
                    PosicaoDto(
                        viewPosicao = arrayViews[arrayViewContador],
                        linha = rowCounter,
                        coluna = colCounter
                    )
                arrayViewContador++
                colCounter++

                if (colCounter == Constantes.TOTAL_POSICOES_COLUNA.valor) {
                    colCounter = Constantes.INIT_VAR_INT_WITH_ZERO.valor
                    rowCounter++
                }

                if (rowCounter == Constantes.TOTAL_POSICOES_LINHA.valor && colCounter == Constantes.TOTAL_POSICOES_COLUNA.valor)
                    return
            }
    }

    private fun inserirPecasIniciaisJogadorUm(corPecasJogador:String){
        val torreBranca:IPecas = Torre(Constantes.TORRE.text(),  corPecasJogador)
        val posicao00:PosicaoDto? = tabuleiroArray2D[0][0]
        posicao00?.peca = torreBranca
        tabuleiroArray2D[0][0] = posicao00
    }

    fun getTabuleiroArray2D():Array<Array<PosicaoDto?>> {
        return this.tabuleiroArray2D
    }
}