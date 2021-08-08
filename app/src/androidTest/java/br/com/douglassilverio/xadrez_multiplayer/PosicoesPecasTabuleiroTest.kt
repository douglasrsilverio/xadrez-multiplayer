package br.com.douglassilverio.xadrez_multiplayer

import android.util.Log
import android.view.View
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.douglassilverio.xadrez_multiplayer.model.Posicao
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PosicoesPecasTabuleiroTest {

    var posicao = Posicao(null,null, null, null)
    var tabuleiroPosicoes: Array<Array<Posicao>> = Array(7) {Array(7) {posicao} }


    @Test
    fun printPosicoesTabuleiro(){

        var posicoes = " \n" + tabuleiroPosicoes.contentDeepToString()
        Log.i(Constantes.TABULEIRO.text(), posicoes.split("],").joinToString("\n"))
    }

    fun inserirPecasIniciaisJogador1(corPecas:String){
        //var torre = Torre(corPecas, 0, 0)
        //tabuleiroPosicoes[0][0].put(torre)
    }

    @Test
    fun mapearPosicoesViewToArray(view: View){
        var axisY = 0
        var axisX = 0

        var viewAray:Array<View?> = Array(63) {null}
        viewAray.set(0, view.findViewById(R.id.pos70))
        viewAray.set(1, view.findViewById(R.id.pos60))
        viewAray.set(2, view.findViewById(R.id.pos50))
        viewAray.set(3, view.findViewById(R.id.pos40))
        viewAray.set(4, view.findViewById(R.id.pos30))
        viewAray.set(5, view.findViewById(R.id.pos20))
        viewAray.set(6, view.findViewById(R.id.pos10))
        viewAray.set(7, view.findViewById(R.id.pos71))
        viewAray.set(8, view.findViewById(R.id.pos61))
        viewAray.set(9, view.findViewById(R.id.pos51))
        viewAray.set(10, view.findViewById(R.id.pos41))
        viewAray.set(11, view.findViewById(R.id.pos31))
        viewAray.set(12, view.findViewById(R.id.pos21))
        viewAray.set(13, view.findViewById(R.id.pos11))

        var posicaoArrayView = 0
        for(array in tabuleiroPosicoes)
            for(posicao in array){
                posicao.novoParametro(viewAray[posicaoArrayView], axisY, axisX)
                tabuleiroPosicoes[axisY][axisX] = posicao
                posicaoArrayView++
                axisX++

                if(axisX == 7)
                    axisX = 0
                    axisY++

                if (axisX == 7 && axisY == 7)
                    break
            }




        /*var viewPosicao:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = axisX)
        tabuleiroPosicoes[0][0] = posicao
        axisX++

        viewPosicao = view.findViewById(R.id.posA2)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = axisX)
        tabuleiroPosicoes[0][axisX] = posicao
        axisX++

        viewPosicao = view.findViewById(R.id.posA3)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = axisX)
        tabuleiroPosicoes[0][axisX] = posicao
        axisX++

        viewPosicao = view.findViewById(R.id.posA4)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = axisX)
        tabuleiroPosicoes[0][axisX] = posicao
        axisX++

        viewPosicao = view.findViewById(R.id.posA5)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = axisX)
        tabuleiroPosicoes[0][axisX] = posicao
        axisX++

        viewPosicao = view.findViewById(R.id.posA6)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = axisX)
        tabuleiroPosicoes[0][axisX] = posicao
        axisX++

        viewPosicao = view.findViewById(R.id.posA7)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = axisX)
        tabuleiroPosicoes[0][axisX] = posicao
        axisX++

        viewPosicao = view.findViewById(R.id.posA8)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = axisX)
        tabuleiroPosicoes[0][axisX] = posicao

        var view00:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view00:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view00:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view00:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view00:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view00:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view00:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao

        var view01:View = view.findViewById(R.id.posA1)
        posicao.novoParametro(viewPosicao = view, linha = 0, coluna = 0)
        tabuleiroPosicoes[0][0] = posicao
*/





    }


}