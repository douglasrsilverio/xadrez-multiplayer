package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoVisualBotoes
import br.com.douglassilverio.xadrez_multiplayer.model.Jogador
import br.com.douglassilverio.xadrez_multiplayer.model.PosicoesTabuleiro

class TabuleiroPresenter(private var viewTabuleiroActivity: ITabuleiroActivity) : ITabuleiroPresenter{

    var posicoesPecasTabuleiro = PosicoesTabuleiro(viewTabuleiroActivity)
    var jogador = Jogador()

    private var estadoVisualBotoes: EstadoVisualBotoes = EstadoVisualBotoes()

    override fun recebeAcao(posSelecionada: View){
        tratarSelecaoPosicao(posSelecionada)
    }

    private fun tratarSelecaoPosicao(posSelecionada: View) {
        if(mudarPecaSelecionada(posSelecionada))
            return

        if(selecionarPeca(posSelecionada))
            return

        if(desselecionarPeca(posSelecionada))
            return
    }

    private fun selecionarPeca(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) != Color.RED ) {//&& jogador.cor == getCorPecaSelecionada(posSelecionada)
            estadoVisualBotoes.corTileUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoVisualBotoes.idPosSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)

            return true
        }
        return false
    }

    private fun desselecionarPeca(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) == Color.RED){
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, estadoVisualBotoes.corTileUltimaPos)
            estadoVisualBotoes.idPosSelecionada = 0
            return true
        }
        return false
    }

    private fun mudarPecaSelecionada(posSelecionada: View): Boolean{
        if(posSelecionada.id != estadoVisualBotoes.idPosSelecionada && estadoVisualBotoes.idPosSelecionada != 0) {
            val antigaPosDestacada: View = viewTabuleiroActivity.getViewById(estadoVisualBotoes.idPosSelecionada)
            viewTabuleiroActivity.mudarDestaquePos(antigaPosDestacada, estadoVisualBotoes.corTileUltimaPos)

            estadoVisualBotoes.corTileUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoVisualBotoes.idPosSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)
            return true
        }
        return false
    }

    fun getCorPecaSelecionada(posSelecionada: View){

    }

    private fun getColorBackgroundPos(posSelecionada: View) : Int {
        return (posSelecionada.background as ColorDrawable).color
    }
}