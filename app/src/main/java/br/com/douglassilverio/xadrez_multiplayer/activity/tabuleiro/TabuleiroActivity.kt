package br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.douglassilverio.xadrez_multiplayer.R
import br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro.ITabuleiroPresenter
import br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro.TabuleiroPresenter


class TabuleiroActivity : AppCompatActivity(){


    private lateinit var tabuleiroPresenter: ITabuleiroPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabuleiro)
        loadView()
    }

    private fun loadView(){
        tabuleiroPresenter = TabuleiroPresenter(this, this)
    }

    fun mudarCorPos(btSelecionado: View, cor: Int){
        btSelecionado.setBackgroundColor(cor)
   }

    fun moverPeca(peca: View, posX: Int, posY: Int){

    }

    fun posA8(btA8: View){
        tabuleiroPresenter.validaAcao(btA8)
    }

    fun posB8(btB8: View){
        tabuleiroPresenter.validaAcao(btB8)
    }

    fun posC8(btC8: View){
        tabuleiroPresenter.validaAcao(btC8)
    }
}