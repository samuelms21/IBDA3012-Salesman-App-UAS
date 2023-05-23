package id.ac.ibda.pads.proyekuas.Utils

import id.ac.ibda.pads.proyekuas.Model.ProductModel
import id.ac.ibda.pads.proyekuas.Model.SalesPeople
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.net.CacheRequest
import id.ac.ibda.pads.proyekuas.Model.LoginRequest
import id.ac.ibda.pads.proyekuas.Model.LoginResponse
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {
    @GET("salespeople")
    fun getSalesPerson(): Response<List<SalesPeople>>

    @GET("products")
    fun getProducts(@Header("Authorization") accessToken: String): Call<List<ProductModel>>

    @POST("salespeople/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}