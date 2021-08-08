package br.com.douglassilverio.xadrez_multiplayer.model

import android.util.Log
import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.R
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.TabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class PosicoesPecasTabuleiro(viewTabuleiroActivity: ITabuleiroActivity) {

    private var posicao:Posicao = Posicao(null, null, null, null)
    private var tabuleiroPosicoes: Array<Array<Posicao>> = Array(8) { Array(8) { posicao } }

    init {
        mapearPosicoesViewToArray(viewTabuleiroActivity)
        printPosicoesTabuleiro()
    }

    private fun printPosicoesTabuleiro() {
        val posicoes = " \n" + tabuleiroPosicoes.contentDeepToString()
        Log.i(Constantes.TABULEIRO.text(), posicoes.split("],").joinToString("\n"))
    }

    fun inserirPecasIniciaisJogador1(corPecas: String) {

    }

    private fun mapearPosicoesViewToArray(viewTabuleiroActivity: ITabuleiroActivity) {
        val arrayView: Array<View?> = Array(64) { null }
        arrayView[0] = viewTabuleiroActivity.getViewById(R.id.pos00)
        arrayView[1] = viewTabuleiroActivity.getViewById(R.id.pos01)
        arrayView[2] = viewTabuleiroActivity.getViewById(R.id.pos02)
        arrayView[3] = viewTabuleiroActivity.getViewById(R.id.pos03)
        arrayView[4] = viewTabuleiroActivity.getViewById(R.id.pos04)
        arrayView[5] = viewTabuleiroActivity.getViewById(R.id.pos05)
        arrayView[6] = viewTabuleiroActivity.getViewById(R.id.pos06)
        arrayView[7] = viewTabuleiroActivity.getViewById(R.id.pos07)
        arrayView[8] = viewTabuleiroActivity.getViewById(R.id.pos10)
        arrayView[9] = viewTabuleiroActivity.getViewById(R.id.pos11)
        arrayView[10] = viewTabuleiroActivity.getViewById(R.id.pos12)
        arrayView[11] = viewTabuleiroActivity.getViewById(R.id.pos13)
        arrayView[12] = viewTabuleiroActivity.getViewById(R.id.pos14)
        arrayView[13] = viewTabuleiroActivity.getViewById(R.id.pos15)
        arrayView[14] = viewTabuleiroActivity.getViewById(R.id.pos16)
        arrayView[15] = viewTabuleiroActivity.getViewById(R.id.pos17)
        arrayView[16] = viewTabuleiroActivity.getViewById(R.id.pos20)
        arrayView[17] = viewTabuleiroActivity.getViewById(R.id.pos21)
        arrayView[18] = viewTabuleiroActivity.getViewById(R.id.pos22)
        arrayView[19] = viewTabuleiroActivity.getViewById(R.id.pos23)
        arrayView[20] = viewTabuleiroActivity.getViewById(R.id.pos24)
        arrayView[21] = viewTabuleiroActivity.getViewById(R.id.pos25)
        arrayView[22] = viewTabuleiroActivity.getViewById(R.id.pos26)
        arrayView[23] = viewTabuleiroActivity.getViewById(R.id.pos27)
        arrayView[24] = viewTabuleiroActivity.getViewById(R.id.pos30)
        arrayView[25] = viewTabuleiroActivity.getViewById(R.id.pos31)
        arrayView[26] = viewTabuleiroActivity.getViewById(R.id.pos32)
        arrayView[27] = viewTabuleiroActivity.getViewById(R.id.pos33)
        arrayView[28] = viewTabuleiroActivity.getViewById(R.id.pos34)
        arrayView[29] = viewTabuleiroActivity.getViewById(R.id.pos35)
        arrayView[30] = viewTabuleiroActivity.getViewById(R.id.pos36)
        arrayView[31] = viewTabuleiroActivity.getViewById(R.id.pos37)
        arrayView[32] = viewTabuleiroActivity.getViewById(R.id.pos40)
        arrayView[33] = viewTabuleiroActivity.getViewById(R.id.pos41)
        arrayView[34] = viewTabuleiroActivity.getViewById(R.id.pos42)
        arrayView[35] = viewTabuleiroActivity.getViewById(R.id.pos43)
        arrayView[36] = viewTabuleiroActivity.getViewById(R.id.pos44)
        arrayView[37] = viewTabuleiroActivity.getViewById(R.id.pos45)
        arrayView[38] = viewTabuleiroActivity.getViewById(R.id.pos46)
        arrayView[39] = viewTabuleiroActivity.getViewById(R.id.pos47)
        arrayView[40] = viewTabuleiroActivity.getViewById(R.id.pos50)
        arrayView[41] = viewTabuleiroActivity.getViewById(R.id.pos51)
        arrayView[42] = viewTabuleiroActivity.getViewById(R.id.pos52)
        arrayView[43] = viewTabuleiroActivity.getViewById(R.id.pos53)
        arrayView[44] = viewTabuleiroActivity.getViewById(R.id.pos54)
        arrayView[45] = viewTabuleiroActivity.getViewById(R.id.pos55)
        arrayView[46] = viewTabuleiroActivity.getViewById(R.id.pos56)
        arrayView[47] = viewTabuleiroActivity.getViewById(R.id.pos57)
        arrayView[48] = viewTabuleiroActivity.getViewById(R.id.pos60)
        arrayView[49] = viewTabuleiroActivity.getViewById(R.id.pos61)
        arrayView[50] = viewTabuleiroActivity.getViewById(R.id.pos62)
        arrayView[51] = viewTabuleiroActivity.getViewById(R.id.pos63)
        arrayView[52] = viewTabuleiroActivity.getViewById(R.id.pos64)
        arrayView[53] = viewTabuleiroActivity.getViewById(R.id.pos65)
        arrayView[54] = viewTabuleiroActivity.getViewById(R.id.pos66)
        arrayView[55] = viewTabuleiroActivity.getViewById(R.id.pos67)
        arrayView[56] = viewTabuleiroActivity.getViewById(R.id.pos70)
        arrayView[57] = viewTabuleiroActivity.getViewById(R.id.pos71)
        arrayView[58] = viewTabuleiroActivity.getViewById(R.id.pos72)
        arrayView[59] = viewTabuleiroActivity.getViewById(R.id.pos73)
        arrayView[60] = viewTabuleiroActivity.getViewById(R.id.pos74)
        arrayView[61] = viewTabuleiroActivity.getViewById(R.id.pos75)
        arrayView[62] = viewTabuleiroActivity.getViewById(R.id.pos76)
        arrayView[63] = viewTabuleiroActivity.getViewById(R.id.pos77)



        var linhaContador = 0
        var colunaContador = 0
        var arrayViewContador = 0

        for (linha in tabuleiroPosicoes)
            for (posicao in linha) {
                tabuleiroPosicoes[linhaContador][colunaContador] = Posicao(viewPosicao = arrayView[arrayViewContador], linha = linhaContador, coluna = colunaContador)
                arrayViewContador++
                colunaContador++

                if (colunaContador == 8) {
                    colunaContador = 0
                    linhaContador++
                }

                if (linhaContador == 8 && colunaContador == 8)
                    return
            }
    }
}