package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.view.View

interface ITabuleiroPresenter {
    fun recebeAcao(posSelecionada: View)
    fun getViewById(idView:Int):View
}