package com.example.imc_app.utils

import android.util.Log
import java.time.LocalDate
import java.time.Period

    fun calcularIdade(dataNascimento: String): Int {

        // Obter  a data atual
        val hoje = LocalDate.now()
        //Log.i("xpto", hoje.toString())

        // Converter a dataNascimento que é String em LocalDate
        val data = dataNascimento.split("/")

        val nascimento = LocalDate.of(
            data.get(2).toInt(),
            data.get(1).toInt(),
            data.get(0).toInt())

//        Log.i("xpto",data.get(0))
//        Log.i("xpto",data.get(1))
//        Log.i("xpto",data.get(2))

        // Calcular o intervalo entre a data atual (hoje) e a data de nascimento
        val idade = Period.between(nascimento, hoje).years
        Log.i("xpto", idade.toString())

        return 0
    }