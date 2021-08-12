package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.util.Log
import android.widget.ImageButton
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotoesDto
import br.com.douglassilverio.xadrez_multiplayer.model.PosicaoDto
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class GerenciaMovimentosPecas(private var tabuleiroArray2D:Array<Array<PosicaoDto?>>, private var estadoBotoesDto: EstadoBotoesDto, private var tabuleiroPresenter: TabuleiroPresenter) {

    //mover essas informacoes para dentro do EstadoBotoesDto apos finalizar implementacoes
    private var tagPosAtual = ""
    private var tagPosDestino = ""

    fun executarAcao() {
        if(limpaPosicoesSeNadaSelecionado())
            return

        if(setPosAtualSePosHavePeca())
            return

        if(executarMovimentoIfPosicoesPreenchidas())
            return

        Log.i(Constantes.TABULEIRO.toString(), "$tagPosAtual | $tagPosDestino")
    }

    private fun getArrayPosXY(tag:String):List<Int>{
        val delimitadorString = ":"
        val posicaoStr = tag.split(delimitadorString)
        return posicaoStr.map { it.toInt() }
    }

    private fun limpaPosicoesSeNadaSelecionado():Boolean{
        if(estadoBotoesDto.idPosicaoSelecionada == Constantes.NADA_SELECIONADO.valor) {
            tagPosAtual = ""
            tagPosDestino = ""
            return true
        }
        return false
    }

    private fun setPosAtualSePosHavePeca(): Boolean{
        val posAtual = getArrayPosXY(tagPosAtual)
        if(tabuleiroArray2D[posAtual[1]][posAtual[0]]?.peca != null) {
            setPosicaoPecaSelecionada()
            return false
        }
        return true
    }

    private fun executarMovimentoIfPosicoesPreenchidas(): Boolean{
        if(tagPosAtual != "" && tagPosDestino != "") {
            moverPeca()
            tagPosAtual = ""
            tagPosDestino = ""
            return true
        }
        return false
    }

    fun setPosicaoPecaSelecionada(){
        val viewSelecionadaAtual = tabuleiroPresenter.getViewById(estadoBotoesDto.idPosicaoSelecionada)
        val tagPosicaoSelecionada:String = viewSelecionadaAtual.tag.toString()

        if(tagPosicaoSelecionada != this.tagPosAtual && this.tagPosAtual != "") {
             this.tagPosDestino = tagPosicaoSelecionada
            return
        }

        this.tagPosAtual = tagPosicaoSelecionada
    }

    private fun moverPeca(){
        Log.i(Constantes.TABULEIRO.toString(), "$tagPosAtual | $tagPosDestino")

        val posAtual = getArrayPosXY(tagPosAtual)
        val posSelecionada = tabuleiroArray2D[posAtual[1]][posAtual[0]]
        val pecaSelecionada = posSelecionada?.peca
        posSelecionada?.removerPeca()

        val viewPosSelecionada = posSelecionada?.viewPosicao as ImageButton
        viewPosSelecionada.setImageResource(android.R.color.transparent)


        val posDestino = getArrayPosXY(tagPosDestino)
        //vazio ou matou a peca do lugar
        tabuleiroArray2D[posDestino[1]][posDestino[0]]?.peca = pecaSelecionada
        val posicaoDestino = tabuleiroArray2D[posDestino[1]][posDestino[0]]?.viewPosicao //inveter as tags no xml e inverter posicao dos números nos arrays de posicao

        val pecaSeraMovimentada = tabuleiroArray2D[posDestino[1]][posDestino[0]]?.peca
        tabuleiroPresenter.setImagemPeca(posicaoDestino, pecaSeraMovimentada?.getIdImagemPeca())
    }
}