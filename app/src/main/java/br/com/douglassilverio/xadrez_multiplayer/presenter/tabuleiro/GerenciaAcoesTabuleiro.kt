package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotoesDto
import br.com.douglassilverio.xadrez_multiplayer.model.PosicaoDto
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class GerenciaAcoesTabuleiro(var tabuleiroArray2D:Array<Array<PosicaoDto?>>, var estadoBotoesDto: EstadoBotoesDto, var tabuleiroPresenter: TabuleiroPresenter) {

    //mover essas informacoes para dentro do EstadoBotoesDto apos finalizar implementacoes
    var tagPosicaoSelecionada = ""
    var colunaSelecionada = Constantes.INIT_VAR_POSICAO.valor
    var linhaSelecionada = Constantes.INIT_VAR_POSICAO.valor

    var tagPosicaoDestino = ""
    var colunaDestino = Constantes.INIT_VAR_POSICAO.valor
    var linhaDestino = Constantes.INIT_VAR_POSICAO.valor

    fun tratarMovimento(posSelecionada: View){
        if(tagPosicaoSelecionada != "" && tagPosicaoDestino != "")
            tagPosicaoSelecionada = ""
            tagPosicaoDestino = ""

        if(estadoBotoesDto.idPosicaoSelecionada == Constantes.NADA_SELECIONADO.valor) {
            tagPosicaoSelecionada = ""
            tagPosicaoDestino = ""
            return
        }

        setPosicaoPecaSelecinada()

        var posicaoSelecionadaNoArray2D = tabuleiroArray2D[colunaSelecionada][linhaSelecionada]
    }

    fun setPosicaoPecaSelecinada(){
        var viewSelecionadaAtual = tabuleiroPresenter.getViewById(estadoBotoesDto.idPosicaoSelecionada)
        var tagPosicaoSelecionada:String = viewSelecionadaAtual.tag.toString()

        val delimitadorString = ":"
        var posicaoColunaLinhaSelecionada = tagPosicaoSelecionada.split(delimitadorString)

        colunaSelecionada = posicaoColunaLinhaSelecionada[0].toInt()
        linhaSelecionada = posicaoColunaLinhaSelecionada[1].toInt()

        if(tagPosicaoSelecionada != this.tagPosicaoSelecionada && this.tagPosicaoSelecionada != "") {
            this.tagPosicaoDestino = tagPosicaoSelecionada
            return
        }

        this.tagPosicaoSelecionada = tagPosicaoSelecionada
    }

    fun setPosicaoDestino(){

    }
}