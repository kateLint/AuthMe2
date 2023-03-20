package com.example.authme2.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authme2.interfaces.ApiInterfaceBuilder
import com.example.authme2.model.GenerateCodeResponse
import com.example.authme2.model.NewJwtEntryRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenerateCodeViewModel: ViewModel() {

    private var mGenerateCodeLiveData = MutableLiveData<GenerateCodeResponse>()
    fun getGenerateCodeLiveData(): LiveData<GenerateCodeResponse>? {
        return mGenerateCodeLiveData
    }

    init {
    }


    fun getGenerateCode(){
        val apiInterface = ApiInterfaceBuilder.getApiInterface()
        var call = apiInterface?.getCode(NewJwtEntryRequest())
        call?.enqueue(object : Callback<GenerateCodeResponse> {

            override fun onResponse(call: Call<GenerateCodeResponse>, response: Response<GenerateCodeResponse>) {
                mGenerateCodeLiveData.value = response.body()
            }
            override fun onFailure(call: Call<GenerateCodeResponse>, t: Throwable)
            {
                Log.e("onFailure",t.printStackTrace().toString())
            }
        })
    }


}