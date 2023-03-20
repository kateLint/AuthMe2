package com.example.authme2.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authme2.interfaces.ApiInterfaceBuilder
import com.example.authme2.model.ActiveUsersResponse
import com.example.authme2.model.NewJwtEntryRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetActiveUsersViewModel : ViewModel() {
    private var mGetActiveUsersLiveData = MutableLiveData<ActiveUsersResponse>()

    fun getActiveUsersLiveData(): LiveData<ActiveUsersResponse>? {
        return mGetActiveUsersLiveData
    }

    init {
    }


    fun getActiveUsers() {
        val apiInterface = ApiInterfaceBuilder.getApiInterface()
        var call = apiInterface?.getActiveUsers(NewJwtEntryRequest())
        call?.enqueue(object : Callback<ActiveUsersResponse> {

            override fun onResponse(
                call: Call<ActiveUsersResponse>,
                response: Response<ActiveUsersResponse>
            ) {
                mGetActiveUsersLiveData.value = response.body()
            }

            override fun onFailure(call: Call<ActiveUsersResponse>, t: Throwable) {
                Log.e("onFailure", t.printStackTrace().toString())
            }
        })
    }
}