package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.TabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotao
import br.com.douglassilverio.xadrez_multiplayer.model.RegrasJogo

class TabuleiroPresenter(var context: Context, var viewTabuleiroActivity: TabuleiroActivity) : ITabuleiroPresenter{

    init {
        var RegrasJogo = RegrasJogo()
    }

    private var estadoBotao: EstadoBotao = EstadoBotao()

    override fun recebeAcao(posSelecionada: View){

        if(posSelecionada.id != estadoBotao.idUltimaPos && estadoBotao.idUltimaPos != 0) {
            destacarNewPosPecaAliada(posSelecionada)
            return
        }

        destacarPosSelecionada(posSelecionada)
    }

    private fun getColorBackgroundPos(posSelecionada: View) : Int {
        return (posSelecionada.background as ColorDrawable).color
    }

    private fun destacarPosSelecionada(posSelecionada: View) {
        if(getColorBackgroundPos(posSelecionada) != Color.RED) {
            estadoBotao.corPadraoUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoBotao.idUltimaPos = posSelecionada.id

            viewTabuleiroActivity.mudarCorPos(posSelecionada, Color.RED)
            return
        }

        if(getColorBackgroundPos(posSelecionada) == Color.RED){
            viewTabuleiroActivity.mudarCorPos(posSelecionada, estadoBotao.corPadraoUltimaPos)
        }
    }

    fun destacarNewPosPecaAliada(novaPosDestacar: View){
        var antigaPosDestacada: View = viewTabuleiroActivity.findViewById(estadoBotao.idUltimaPos)
        viewTabuleiroActivity.mudarCorPos(antigaPosDestacada, estadoBotao.corPadraoUltimaPos)

        estadoBotao.corPadraoUltimaPos = getColorBackgroundPos(novaPosDestacar)
        estadoBotao.idUltimaPos = novaPosDestacar.id
        viewTabuleiroActivity.mudarCorPos(novaPosDestacar, Color.RED)
    }



}