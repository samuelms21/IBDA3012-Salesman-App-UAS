package id.ac.ibda.pads.proyekuas.Repository

import id.ac.ibda.pads.proyekuas.Model.SalesPersonItem
import id.ac.ibda.pads.proyekuas.Utils.RetrofitObject

class SalesPersonRepo {

    private val apiService = RetrofitObject.apiService

    suspend fun getSalesPerson(): SalesPersonItem {
        return apiService.getSalesPerson()
    }
}