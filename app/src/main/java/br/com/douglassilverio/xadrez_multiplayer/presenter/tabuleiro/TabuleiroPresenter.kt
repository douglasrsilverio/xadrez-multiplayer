package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoVisualBotoeDto
import br.com.douglassilverio.xadrez_multiplayer.model.JogadorDto

class TabuleiroPresenter(private var viewTabuleiroActivity: ITabuleiroActivity) : ITabuleiroPresenter{

    var posicoesPecasTabuleiro =
        ConfiguracoesTabuleiro(
            viewTabuleiroActivity
        )
    var jogador = JogadorDto()

    private var estadoVisualBotoeDto: EstadoVisualBotoeDto = EstadoVisualBotoeDto()

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
            estadoVisualBotoeDto.corTileUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoVisualBotoeDto.idPosSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)

            return true
        }
        return false
    }

    private fun desselecionarPeca(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) == Color.RED){
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, estadoVisualBotoeDto.corTileUltimaPos)
            estadoVisualBotoeDto.idPosSelecionada = 0
            return true
        }
        return false
    }

    private fun mudarPecaSelecionada(posSelecionada: View): Boolean{
        if(posSelecionada.id != estadoVisualBotoeDto.idPosSelecionada && estadoVisualBotoeDto.idPosSelecionada != 0) {
            val antigaPosDestacada: View = viewTabuleiroActivity.getViewById(estadoVisualBotoeDto.idPosSelecionada)
            viewTabuleiroActivity.mudarDestaquePos(antigaPosDestacada, estadoVisualBotoeDto.corTileUltimaPos)

            estadoVisualBotoeDto.corTileUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoVisualBotoeDto.idPosSelecionada = posSelecionada.id
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