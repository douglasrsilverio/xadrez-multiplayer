package br.com.douglassilverio.xadrez_multiplayer.util

enum class Constantes(var valor:Int, var descricao: String) {


    P1(0, "Jogador 1"),
    P2(1, "Jogador 2"),
    BRANCAS(0, "Brancas"),
    PRETAS(0, "Pretas"),
    TABULEIRO(0, "Tabuleiro"),
    TORRE_BRANCA(0,"tb"),
    TORRE_PRETA(0,"tp"),
    POSICAO_VAZIA(0, "Posicao Vazia"),
    TOTAL_POSICOES_TABULEIRO(64, ""),
    TOTAL_POSICOES_COLUNA(8, ""),
    TOTAL_POSICOES_LINHA(0, ""),
    INIT_VAR_INT_WITH_ZERO(0, "");

    fun text(): String {
        return this.descricao
    }

    fun valor(): Int{
        return this.valor
    }
}