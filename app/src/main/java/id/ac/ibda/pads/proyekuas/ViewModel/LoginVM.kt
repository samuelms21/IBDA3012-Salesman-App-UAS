package id.ac.ibda.pads.proyekuas.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ibda.pads.proyekuas.Model.SalesPersonItem
import id.ac.ibda.pads.proyekuas.Repository.SalesPersonRepo
import kotlinx.coroutines.launch
import retrofit2.Response


class LoginVM : ViewModel() {

    private val repo = SalesPersonRepo()
    private val  _salesperson = MutableLiveData<Response<List<SalesPersonItem>>>()

    val salesperson: MutableLiveData<Response<List<SalesPersonItem>>>
        get() = _salesperson

    private fun loadSalesPerson() {
        viewModelScope.launch {
            val result = repo.getSalesPerson()
            _salesperson.postValue(result)
        }
    }

    fun checkLogin(): MutableLiveData<Response<List<SalesPersonItem>>> {
        loadSalesPerson()

        return this._salesperson
    }

}