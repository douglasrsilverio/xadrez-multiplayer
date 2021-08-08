package br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.douglassilverio.xadrez_multiplayer.R
import br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro.ITabuleiroPresenter
import br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro.TabuleiroPresenter


class TabuleiroActivity : ITabuleiroActivity, AppCompatActivity(){


    private lateinit var tabuleiroPresenter: ITabuleiroPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabuleiro)
        loadView()
    }

    private fun loadView(){
        tabuleiroPresenter = TabuleiroPresenter( this)
    }

    override fun mudarDestaquePos(btSelecionado: View, cor: Int){
        btSelecionado.setBackgroundColor(cor)
   }

    override fun getViewById(idView:Int):View{
        return findViewById(idView)
    }

    fun moverPeca(peca: View, posX: Int, posY: Int){

    }

    fun pos00(btA8: View){
        tabuleiroPresenter.recebeAcao(btA8)
    }

    fun pos01(btB8: View){
        tabuleiroPresenter.recebeAcao(btB8)
    }

    fun pos02(btC8: View){
        tabuleiroPresenter.recebeAcao(btC8)
    }
}