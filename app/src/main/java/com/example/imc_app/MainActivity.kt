package com.example.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val buttonEntrar = findViewById<Button>(R.id.button_entrar)
        val buttonNovaConta = findViewById<Button>(R.id.nova_conta)

        val editEmail = findViewById<EditText>(R.id.edit_login_email)
        val editSenha = findViewById<EditText>(R.id.edit_login_senha)

        buttonEntrar.setOnClickListener {

            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

            // Recupera o email e senha de dentro do arquivo
            val email = arquivo.getString("email", "")
            val senha = arquivo.getString("senha", "")

            if(email == editEmail.text.toString() && senha == editSenha.text.toString()){
                val abrirDashBoard = Intent(this, DashBoardActivity::class.java)
                startActivity(abrirDashBoard)
            }else{
                Toast.makeText(this, "Senha ou usuário incorretos", Toast.LENGTH_SHORT).show()
            }

            //Toast.makeText(this, "Senha ou usuário incorretos", Toast.LENGTH_SHORT.toShort())

            val abrirDashBoardActivity = Intent(this, DashBoardActivity::class.java)
            startActivity(abrirDashBoardActivity)
        }

        buttonNovaConta.setOnClickListener {
            val abrirNovaConta = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirNovaConta)
        }
    }
}