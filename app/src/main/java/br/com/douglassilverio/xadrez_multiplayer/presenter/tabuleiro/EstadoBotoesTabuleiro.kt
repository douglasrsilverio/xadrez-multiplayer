package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.util.Log
import android.view.View
import android.widget.ImageButton
import br.com.douglassilverio.xadrez_multiplayer.R
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotoesDto
import br.com.douglassilverio.xadrez_multiplayer.model.PosicaoDto
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class EstadoBotoesTabuleiro(var tabuleiroArray2D:Array<Array<PosicaoDto?>>, var estadoBotoesDto: EstadoBotoesDto, var tabuleiroPresenter: TabuleiroPresenter) {

    //mover essas informacoes para dentro do EstadoBotoesDto apos finalizar implementacoes
    var tagPosicaoSelecionada = ""
    var tagPosicaoDestino = ""

    fun executarAcao(posSelecionada: View){
        if(estadoBotoesDto.idPosicaoSelecionada == Constantes.NADA_SELECIONADO.valor) {
            tagPosicaoSelecionada = ""
            tagPosicaoDestino = ""
            return
        }

        setPosicaoPecaSelecinada()

        if(tagPosicaoSelecionada != "" && tagPosicaoDestino != "") {
            moverPeca()
            tagPosicaoSelecionada = ""
            tagPosicaoDestino = ""
        }

        Log.i(Constantes.TABULEIRO.toString(), "$tagPosicaoSelecionada | $tagPosicaoDestino")
    }

    fun setPosicaoPecaSelecinada(){
        var viewSelecionadaAtual = tabuleiroPresenter.getViewById(estadoBotoesDto.idPosicaoSelecionada)
        var tagPosicaoSelecionada:String = viewSelecionadaAtual.tag.toString()

        if(tagPosicaoSelecionada != this.tagPosicaoSelecionada && this.tagPosicaoSelecionada != "") {
             this.tagPosicaoDestino = tagPosicaoSelecionada
            return
        }

        this.tagPosicaoSelecionada = tagPosicaoSelecionada
    }

    fun moverPeca(){
        Log.i(Constantes.TABULEIRO.toString(), "$tagPosicaoSelecionada | $tagPosicaoDestino")

        val delimitadorString = ":"
        var posAtual = tagPosicaoSelecionada.split(delimitadorString)

        var posSelecionada = tabuleiroArray2D[posAtual[0].toInt()][posAtual[1].toInt()]
        var pecaSelecionada = posSelecionada?.peca
        posSelecionada?.removerPeca()

        var viewPosSelecionada = posSelecionada?.viewPosicao as ImageButton
        viewPosSelecionada.setImageResource(android.R.color.transparent)




        var posDestino = tagPosicaoDestino.split(delimitadorString)
        //vazio ou matou a peca do lugar
        tabuleiroArray2D[posDestino[0].toInt()][posDestino[1].toInt()]?.peca = pecaSelecionada
        var posicaoDestino = tabuleiroArray2D[posDestino[0].toInt()][posDestino[1].toInt()]?.viewPosicao //posicoes estao invertidas

        var viewPosDestino = posicaoDestino as ImageButton
        viewPosDestino.setImageResource(R.drawable.ic_brancas_torre)
        //inserir resource de imagem nas pecas?
    }
}