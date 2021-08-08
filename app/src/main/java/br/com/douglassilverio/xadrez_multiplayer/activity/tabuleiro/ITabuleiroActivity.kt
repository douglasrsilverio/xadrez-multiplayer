package br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro

import android.view.View

interface ITabuleiroActivity {
    fun getViewById(idView:Int): View
    fun mudarDestaquePos(btSelecionado: View, cor: Int)
}