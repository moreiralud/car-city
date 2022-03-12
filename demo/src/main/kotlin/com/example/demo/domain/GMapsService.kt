package com.example.demo.domain

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class GMapsService(
    @Value("\${com.example.demo.domain.googlemaps.apikey}")
    val appKey : String){
    val GMAPS_TEMPLATE =
        "https://maps.googleapis.com/maps/api/directions/json?origin={origin}&destination={destination}&key={key}"

    fun getDistanceBetweenAddresses(addressOne:String,addressTwo:String) : Int{
       val template = RestTemplate()
        val jsonResult = template.getForObject(GMAPS_TEMPLATE, String::class.java, addressOne, addressTwo, appKey)
    }
}