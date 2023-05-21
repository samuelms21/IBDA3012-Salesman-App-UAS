package id.ac.ibda.pads.proyekuas.Utils

import id.ac.ibda.pads.proyekuas.Model.SalesPersonItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("salespeople")
    suspend fun getSalesPerson(): Response<List<SalesPersonItem>>

}