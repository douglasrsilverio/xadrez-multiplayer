package br.com.douglassilverio.xadrez_multiplayer.model

import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class EstadoPosicao {
    var corDestaqueUltimaPos = 0

    var idPosSelecionada = 0
    var corPecaSelecionada = 0

    var corJogador = Constantes.BRANCAS //alterar para cor randomizada, p1 sempre será quem criou a sala
}