package br.com.douglassilverio.xadrez_multiplayer.util

enum class Constantes(var descricao: String) {

    P1("Jogador 1"),
    P2("Jogador 2"),
    BRANCAS("Brancas"),
    PRETAS("Pretas"),
    TABULEIRO("Tabuleiro"),
    TORRE_BRANCA("tb"),
    TORRE_PRETA("tp");

    override fun toString(): String {
        return this.descricao
    }
}