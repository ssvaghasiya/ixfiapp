package com.example.ixfiapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ixfiapp.retrofit.APIInterface
import com.example.ixfiapp.utils.NetworkResult
import com.example.ixfiapp.utils.SafeApiCall
import com.example.ixfiapp.pojo.ExampleData
import retrofit2.Response
import javax.inject.Inject

class ExampleRepository @Inject constructor(private val APIInterface: APIInterface) {

    private val _examples = MutableLiveData<ExampleData?>()
    val examples: LiveData<ExampleData?>
        get() = _examples

    suspend fun getExamples() {
        val result: NetworkResult<Response<ExampleData?>> = SafeApiCall.safeApiCall {
            APIInterface.getExamples()
        }
        when (result) {
            is NetworkResult.Success -> {//Handle success
                if (result.data.isSuccessful && result.data.body() != null) {
                    _examples.postValue(result.data.body())
                }
            }
            is NetworkResult.Error -> { //Handle error
                Log.e("Error", result.message.toString())
                _examples.postValue(null)
            }
        }

    }


}