package id.ac.ibda.pads.proyekuas.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ibda.pads.proyekuas.Model.SalesPersonItem
import id.ac.ibda.pads.proyekuas.Repository.SalesPersonRepo
import kotlinx.coroutines.launch


class LoginVM : ViewModel() {

    private val repo = SalesPersonRepo()
    private val  _salesperson = MutableLiveData<SalesPersonItem>()
    val salesperson: LiveData<SalesPersonItem>
        get() = _salesperson

    fun loadSalesPerson() {
        viewModelScope.launch {
            val result = repo.getSalesPerson()
            _salesperson.postValue(result)
        }
    }

    fun checkLogin(): Any {
//        loadSalesPerson()

        return "spUsername"
    }

}