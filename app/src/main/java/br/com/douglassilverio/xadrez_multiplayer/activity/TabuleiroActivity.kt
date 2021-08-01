package br.com.douglassilverio.xadrez_multiplayer.activity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.douglassilverio.xadrez_multiplayer.R
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotoes


class TabuleiroActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var estadoBotoes: EstadoBotoes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabuleiro)

        estadoBotoes = EstadoBotoes()

    }

    private fun getColorBackgroundBt(view: View) : Int{
        return (view.background as ColorDrawable).color
    }

     override fun onClick(view: View){
        destaquePosPecaSelecionada(view)
    }

    fun destaquePosPecaSelecionada(view: View) {
        if(getColorBackgroundBt(view) != Color.RED) {
            estadoBotoes.corPadrao = getColorBackgroundBt(view)
            view.setBackgroundColor(Color.RED)
            return
        }

        if(getColorBackgroundBt(view) == Color.RED){
            view.setBackgroundColor(estadoBotoes.corPadrao)
        }
    }

    fun pos8A(view: View){

    }

    fun ifPecaDestacadaAndNextHavePecaAliadaReset(){

    }

}