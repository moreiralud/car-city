package com.example.demo.domain.interfaces;
import com.example.demo.domain.Driver;
import com.example.demo.domain.DriverRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service //para que a classe seja reconhecida pelo Spring
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE]) //retorna uma lista com objetos do tipo Driver

 class DriverAPI(
    val driverRepository: DriverRepository
    ){

    @GetMapping("/drivers")
      fun listDrivers() = driverRepository.findAll()

    @GetMapping("/drivers/{id}")
    fun findDriver(@PathVariable("id") id: Long) =
            driverRepository.findById(id)
                    .orElseThrow(){ ResponseStatusException(HttpStatus.NOT_FOUND)} //erro 404 e não o 500 em caso de um id inexistente
}



