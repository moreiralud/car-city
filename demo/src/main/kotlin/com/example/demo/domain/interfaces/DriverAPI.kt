package com.example.demo.domain.interfaces;
import com.example.demo.domain.Driver;
import com.example.demo.domain.DriverRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Service //para que a classe seja reconhecida pelo Spring
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE]) //retorna uma lista com objetos do tipo Driver

 class DriverAPI(
    val driverRepository: DriverRepository
    ) {

    @GetMapping("/drivers")
    fun listDrivers() = driverRepository.findAll()

    @GetMapping("/drivers/{id}")
    fun findDriver(@PathVariable("id") id: Long) =
        driverRepository.findById(id)
            .orElseThrow() { ResponseStatusException(HttpStatus.NOT_FOUND) } //erro 404 e não o 500 em caso de um id inexistente

    @PostMapping("/drivers")
    fun createDriver(@RequestBody driver: Driver): Driver = driverRepository.save(driver)

    @PutMapping("/drivers/{id}")
    fun fullUpdateDriver(@PathVariable("id") id: Long, @RequestBody driver: Driver) : Driver{
        val foundDriver = findDriver(id)
        val copyDriver = foundDriver.copy(
            birthDate =  driver.birthDate,
            name = driver.name
        )
        return driverRepository.save(copyDriver)
    }

}



