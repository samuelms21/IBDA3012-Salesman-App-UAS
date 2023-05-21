package id.ac.ibda.pads.proyekuas.Repository

import id.ac.ibda.pads.proyekuas.Model.SalesPersonItem
import id.ac.ibda.pads.proyekuas.Utils.RetrofitObject
import retrofit2.Response

class SalesPersonRepo {

    private val apiService = RetrofitObject.apiService

    suspend fun getSalesPerson(): Response<List<SalesPersonItem>> {
        return apiService.getSalesPerson()
    }
}