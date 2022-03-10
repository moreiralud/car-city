package com.example.demo.domain.interfaces


import com.example.demo.domain.TravelRequestMapper
import com.example.demo.domain.TravelRequestOutput
import com.example.demo.domain.TravelRequestStatus
import com.example.demo.domain.TravelSevice
import org.springframework.hateoas.EntityModel
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@Service
@RestController
@RequestMapping(path = ["/travelRequest"], produces = [MediaType.APPLICATION_JSON_VALUE])
class TravelRequestAPI(
    val travelSevice : TravelSevice,
    val mapper: TravelRequestMapper
    ){

    @PostMapping
    fun makeTravelRequest(@RequestBody travelRequestInput: TravelRequestInput)
        : EntityModel<TravelRequestOutput> {
        val travelRequest = travelSevice.saveTravelRequest(mapper.map(travelRequestInput))
        val output = mapper.map(travelRequest)
        return  mapper.buildOutputModel(travelRequest, output)
    }
}

data class TravelRequestInput(
    val passengerId: Long,
    val origin : String,
    val destination: String
)
data class TravelRequestOutput(
    val id: Long,
    val origin: String,
    val destination: String,
    val status: TravelRequestStatus,
    val creationDate: LocalDateTime
)
