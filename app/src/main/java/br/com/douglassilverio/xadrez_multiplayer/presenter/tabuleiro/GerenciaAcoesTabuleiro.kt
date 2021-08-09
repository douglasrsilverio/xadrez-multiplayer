package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotoesDto
import br.com.douglassilverio.xadrez_multiplayer.model.PosicaoDto
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class GerenciaAcoesTabuleiro(var tabuleiroArray2D:Array<Array<PosicaoDto?>>, var estadoBotoesDto: EstadoBotoesDto, var tabuleiroPresenter: TabuleiroPresenter) {

    var colunaSelecionada = Constantes.INIT_VAR_POSICAO.valor
    var linhaSelecionada = Constantes.INIT_VAR_POSICAO.valor
    var colunaDestino = Constantes.INIT_VAR_POSICAO.valor
    var linhaDestino = Constantes.INIT_VAR_POSICAO.valor

    fun tratarMovimento(posSelecionada: View){
        if(estadoBotoesDto.idPosSelecionada == Constantes.NADA_SELECIONADO.valor)
            return

        setaPosicaoSelecinada()

        var posicaoSelecionadaNoArray2D = tabuleiroArray2D[colunaSelecionada][linhaSelecionada]
    }

    fun setaPosicaoSelecinada(){
        var viewSelecionadaAtual = tabuleiroPresenter.getViewById(estadoBotoesDto.idPosSelecionada)
        var tagComPosicaoSelecionada:String = viewSelecionadaAtual.tag.toString()

        val delimitadorString = ":"
        var posicaoColunaLinhaSelecionada = tagComPosicaoSelecionada.split(delimitadorString)

        colunaSelecionada = posicaoColunaLinhaSelecionada[0].toInt()
        linhaSelecionada = posicaoColunaLinhaSelecionada[1].toInt()
    }
}