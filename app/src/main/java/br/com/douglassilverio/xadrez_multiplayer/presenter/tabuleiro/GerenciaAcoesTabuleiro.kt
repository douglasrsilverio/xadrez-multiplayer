package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.TabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotoesDto
import br.com.douglassilverio.xadrez_multiplayer.model.PosicaoDto

class GerenciaAcoesTabuleiro(var tabuleiroArray2D:Array<Array<PosicaoDto?>>, var estadoBotoesDto: EstadoBotoesDto, var tabuleiroPresenter: TabuleiroPresenter) {

    fun tratarAcao(posSelecionada: View){
        var viewSelecionadaAtual = tabuleiroPresenter.getViewById(estadoBotoesDto.idPosSelecionada)
        var tagComPosicaoSelecionada:String = viewSelecionadaAtual.tag.toString()

        val delimitadorString = ":"
        var listaPosicaoColunaLinha = tagComPosicaoSelecionada.split(delimitadorString)

        var posicaoSelecionadaNoArray2D = tabuleiroArray2D[listaPosicaoColunaLinha[0].toInt()][listaPosicaoColunaLinha[1].toInt()]
    }
}