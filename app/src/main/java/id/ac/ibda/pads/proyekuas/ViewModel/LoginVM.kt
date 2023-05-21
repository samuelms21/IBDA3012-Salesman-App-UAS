package id.ac.ibda.pads.proyekuas.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import id.ac.ibda.pads.proyekuas.Model.SalesPeople
import id.ac.ibda.pads.proyekuas.Utils.ApiService
import id.ac.ibda.pads.proyekuas.Utils.RetrofitObject
import kotlinx.coroutines.launch


class LoginVM : ViewModel() {

//    private val diffCallback = object : DiffUtil.ItemCallback<SalesPeople>(){
//        override fun areItemsTheSame(oldItem: SalesPeople, newItem: SalesPeople): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: SalesPeople, newItem: SalesPeople): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    private val differ = AsyncListDiffer(this, diffCallback)
//    var itemList: List<SalesPeople>
//        get() = differ.currentList
//        set(value) {differ.submitList(value)}

//    val ap = RetrofitObject.apiService.getSalesPerson()

    fun checkLogin(): Any {
        return "this.salesperson"
    }

}