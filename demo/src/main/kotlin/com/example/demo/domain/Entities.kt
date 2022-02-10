package com.example.demo.domain

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Driver(
        @Id //chave primária da tabela
        var id: Long? = null,
        val name: String,
        val birthDate: LocalDate,
        val gender: String
        )

