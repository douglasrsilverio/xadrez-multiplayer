package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.TabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotoes

class TabuleiroPresenter(var context: Context, var view: TabuleiroActivity) : ITabuleiroPresenter{

    private lateinit var estadoBotoes: EstadoBotoes

    init {
        estadoBotoes = EstadoBotoes()
    }

    override fun validaAcao(posSelecionada: View){
        destacarPosSelecionada(posSelecionada)
    }

    private fun getColorBackgroundBt(posSelecionada: View) : Int {
        return (posSelecionada.background as ColorDrawable).color
    }

    fun destacarPosSelecionada(posSelecionada: View) {
        if(getColorBackgroundBt(posSelecionada) != Color.RED) {
            estadoBotoes.corPadrao = getColorBackgroundBt(posSelecionada)
            view.mudarCorPosSelecionada(posSelecionada, Color.RED)
            return
        }

        if(getColorBackgroundBt(posSelecionada) == Color.RED){
            view.mudarCorPosSelecionada(posSelecionada, estadoBotoes.corPadrao)
        }
    }

    fun comportamentoBotoes(view: View){
        destacarPosSelecionada(view)
    }
}