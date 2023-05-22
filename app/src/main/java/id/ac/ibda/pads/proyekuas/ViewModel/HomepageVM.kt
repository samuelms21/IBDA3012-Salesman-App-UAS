package id.ac.ibda.pads.proyekuas.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ibda.pads.proyekuas.Model.ProductModel
import id.ac.ibda.pads.proyekuas.Utils.RetrofitObject
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomepageVM: ViewModel() {
    val itemList = MutableLiveData<List<ProductModel>>()

    fun getProducts() {
        viewModelScope.launch {
            val response = try {
                RetrofitObject.apiService.getProducts()
            } catch (e: IOException) {
                Log.d("AAA", "IOException, you might not have an internet connection", e)
                return@launch
            } catch (e: HttpException) {
                Log.d("BBB", "HttpException, unexpected response", e)
                return@launch
            }

            if (response.isSuccessful && response.body() != null) {
                itemList.value = response.body()!!
            } else {
                Log.e("CCC", "Response not successful")
            }
        }
    }


}