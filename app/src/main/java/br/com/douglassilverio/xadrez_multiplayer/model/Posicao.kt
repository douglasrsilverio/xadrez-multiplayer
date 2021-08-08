package br.com.douglassilverio.xadrez_multiplayer.model

import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.model.pecas.Pecas

class Posicao(private var peca:Pecas? = null, private var viewPosicao: View? = null, private var linha:Int? = null, private var coluna:Int? = null){

    override fun toString(): String {
        //return if(peca != null) peca.toString() else "Empty"
        return " $linha $coluna"
    }

    fun novoParametro(viewPosicao: View?, linha:Int?, coluna:Int?, peca:Pecas? = null){
        this.peca = peca
        this.linha = linha
        this.coluna = coluna
    }
}




