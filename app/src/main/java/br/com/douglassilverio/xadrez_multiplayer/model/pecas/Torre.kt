package br.com.douglassilverio.xadrez_multiplayer.model.pecas

import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class Torre(var nome:String, private var cor:String) : IPecas {
    override fun getCorPeca(): String {
        return cor
    }

    override fun getNomePeca(): String {
        return  nome
    }
}