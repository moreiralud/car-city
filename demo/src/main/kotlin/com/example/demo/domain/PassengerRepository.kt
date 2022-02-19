package com.example.demo.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.GetMapping

interface PassengerRepository : JpaRepository<Passenger, Long>

//meio de acesso ao banco de dados?

