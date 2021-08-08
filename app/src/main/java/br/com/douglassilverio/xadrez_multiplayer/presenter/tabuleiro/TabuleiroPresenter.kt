package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoVisualBotoeDto
import br.com.douglassilverio.xadrez_multiplayer.model.JogadorDto

class TabuleiroPresenter(private var viewTabuleiroActivity: ITabuleiroActivity) : ITabuleiroPresenter{

    private var estadoVisualBotoeDto = EstadoVisualBotoeDto()
    var configuraTabuleiro = ConfiguraTabuleiro(viewTabuleiroActivity)
    private var gerenciaAcoesTabuleiro:GerenciaAcoesTabuleiro
    var jogador = JogadorDto()

    init {
        val tabuleiroArray2D = configuraTabuleiro.getTabuleiroArray2D()
        gerenciaAcoesTabuleiro = GerenciaAcoesTabuleiro(tabuleiroArray2D)
    }



    override fun recebeAcao(posSelecionada: View){
        tratarDestaqueVisualPosicaoSelecionada(posSelecionada)
        gerenciaAcoesTabuleiro.tratarAcao(posSelecionada)
        configuraTabuleiro.printPosicoesTabuleiro()
    }


    private fun tratarDestaqueVisualPosicaoSelecionada(posSelecionada: View) {
        if(mudarDestaqueAtualParaNovaPecaSelecionada(posSelecionada))
            return

        if(destacarPecaSelecionada(posSelecionada))
            return

        if(removerDestaqueifPecaSelecionadaJaDestacada(posSelecionada))
            return
    }

    private fun destacarPecaSelecionada(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) != Color.RED ) {//&& jogador.cor == getCorPecaSelecionada(posSelecionada)
            estadoVisualBotoeDto.corTileUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoVisualBotoeDto.idPosSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)

            return true
        }
        return false
    }

    private fun removerDestaqueifPecaSelecionadaJaDestacada(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) == Color.RED){
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, estadoVisualBotoeDto.corTileUltimaPos)
            estadoVisualBotoeDto.idPosSelecionada = 0
            return true
        }
        return false
    }

    private fun mudarDestaqueAtualParaNovaPecaSelecionada(posSelecionada: View): Boolean{
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

    private fun getColorBackgroundPos(posSelecionada: View) : Int {
        return (posSelecionada.background as ColorDrawable).color
    }
}