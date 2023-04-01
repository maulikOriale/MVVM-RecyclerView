package com.example.kotlinpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityMainViewModel : ViewModel() {

    var dataList: MutableLiveData<List<DataModel>> = MutableLiveData()

    fun getLiveObserverData(): MutableLiveData<List<DataModel>> {
        return dataList
    }

    fun makeApi() {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance()
        val retrofitService = retrofitInstance.create(RetrofitInterface::class.java)
        val call = retrofitService.getData()
        call.enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                dataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                dataList.postValue(null)
            }
        })
    }
}