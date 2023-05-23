package id.ac.ibda.pads.proyekuas.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import id.ac.ibda.pads.proyekuas.Model.LoginRequest
import id.ac.ibda.pads.proyekuas.Model.LoginResponse
import id.ac.ibda.pads.proyekuas.Utils.AccessTokenManager
import id.ac.ibda.pads.proyekuas.Utils.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginVM : ViewModel() {
    private val apiService = RetrofitObject.apiService

    fun login(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)
        apiService.login(loginRequest).enqueue(object: Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val user = response.body()
                if (user!!.access_token != "invalid_credentials" ) {
                    AccessTokenManager.setAccessToken(user.access_token)
                } else {
                    Log.e("LOGIN_ERROR", "Invalid credentials.")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("LOGIN_ERROR", t.message.toString())
            }
        })
    }

}