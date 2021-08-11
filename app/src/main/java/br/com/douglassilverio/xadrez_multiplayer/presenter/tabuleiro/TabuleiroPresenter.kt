package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotoesDto
import br.com.douglassilverio.xadrez_multiplayer.model.JogadorDto

class TabuleiroPresenter(private var viewTabuleiroActivity: ITabuleiroActivity) : ITabuleiroPresenter{

    private var estadoBotoesDto = EstadoBotoesDto()
    var configuraTabuleiro = ConfiguraTabuleiro(this)
    private var estadoBotoesTabuleiro:EstadoBotoesTabuleiro
    var jogador = JogadorDto()

    init {
        val tabuleiroArray2D = configuraTabuleiro.getTabuleiroArray2D()
        estadoBotoesTabuleiro = EstadoBotoesTabuleiro(tabuleiroArray2D, estadoBotoesDto, this)
    }

    override fun recebeAcao(posSelecionada: View){
        tratarAcao(posSelecionada)

        estadoBotoesTabuleiro.executarAcao(posSelecionada)
        configuraTabuleiro.printPosicoesTabuleiro()
    }


    private fun tratarAcao(posSelecionada: View) {
        if(alterarPecaSelecionada(posSelecionada))
            return

        if(selecionarPeca(posSelecionada)){
            return
        }

        if(desselecionarPeca(posSelecionada)){
            return
        }


        //if jogada realizada foi válida remover destaque
    }

    private fun selecionarPeca(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) != Color.RED ) {//&& jogador.cor == getCorPecaSelecionada(posSelecionada)
            estadoBotoesDto.corTileUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoBotoesDto.idPosicaoSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)

            estadoBotoesTabuleiro.setPosicaoPecaSelecinada()
            return true
        }
        return false
    }

    private fun desselecionarPeca(posSelecionada: View): Boolean{
        estadoBotoesTabuleiro.setPosicaoPecaSelecinada()

        if(getColorBackgroundPos(posSelecionada) == Color.RED){
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, estadoBotoesDto.corTileUltimaPos)
            estadoBotoesDto.idPosicaoSelecionada = 0
            return true
        }
        return false
    }

    private fun alterarPecaSelecionada(posSelecionada: View): Boolean{
        if(posSelecionada.id != estadoBotoesDto.idPosicaoSelecionada && estadoBotoesDto.idPosicaoSelecionada != 0) {
            val antigaPosDestacada: View = viewTabuleiroActivity.getViewById(estadoBotoesDto.idPosicaoSelecionada)
            viewTabuleiroActivity.mudarDestaquePos(antigaPosDestacada, estadoBotoesDto.corTileUltimaPos)

            estadoBotoesDto.corTileUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoBotoesDto.idPosicaoSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)
            return true
        }
        return false
    }

    override fun moverPeca(posicaoViewSelecionada:Int, posicaoDestinoDaViewSelecionada:Int){

    }

    override fun setImagemPeca(view: View?, idImagem:Int) {
        viewTabuleiroActivity.setImagemPeca(view, idImagem)
    }

    private fun getColorBackgroundPos(posSelecionada: View) : Int {
        return (posSelecionada.background as ColorDrawable).color
    }

    override fun getViewById(idView:Int):View{
        return viewTabuleiroActivity.getViewById(idView)
    }
}