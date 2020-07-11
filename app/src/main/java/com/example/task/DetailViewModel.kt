package com.example.task

import androidx.lifecycle.*
import com.example.task.data.ResultExp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel: ViewModel() {

    private val repository = Repository()

    val result_exp: MutableLiveData<ResultExp> = MutableLiveData()


    val error: MutableLiveData<Throwable> = MutableLiveData()

    fun loadDetails(id: String) {

        viewModelScope.launch(Dispatchers.Default) {


            try {
                val resultExp: ResultExp = repository.getDetail(id)
                withContext(Dispatchers.Main) {
                    result_exp.value = resultExp
                }
            }catch (e: Throwable){
                withContext(Dispatchers.Main){
                    error.value = e
                }
            }
        }
    }



}