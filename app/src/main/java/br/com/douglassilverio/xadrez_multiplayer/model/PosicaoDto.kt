package br.com.douglassilverio.xadrez_multiplayer.model

import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.model.pecas.IPecas
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class PosicaoDto(var peca:IPecas? = null, private var viewPosicao: View? = null, private var linha:Int? = null, private var coluna:Int? = null){

    override fun toString(): String {
        var tipoPeca = peca?.getNomePeca() ?: Constantes.POSICAO_VAZIA.text()
        var corPeca = peca?.getCorPeca() ?: Constantes.POSICAO_VAZIA.text()
        var corTipoPeca = if(tipoPeca != Constantes.POSICAO_VAZIA.text() &&
            corPeca != Constantes.POSICAO_VAZIA.text())
                tipoPeca + corPeca
            else
                "  "

        return "$coluna$linha$corTipoPeca"
    }
}




