package br.com.douglassilverio.xadrez_multiplayer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.TabuleiroActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        abrirTabuleiro()
    }

    fun abrirTabuleiro(){
        var intent = Intent(this, TabuleiroActivity::class.java)
        this.startActivity(intent)
        finish()
    }
}