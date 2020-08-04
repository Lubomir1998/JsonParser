package com.example.task.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.Repository
import com.example.task.data.Experience
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    lateinit var repository: Repository

    val experiences: MutableLiveData<List<Experience>> = MutableLiveData()
    val error: MutableLiveData<Throwable> = MutableLiveData()

    fun loadFromDB() {

         viewModelScope.launch {
             experiences.value = repository.getAllFromDB()
         }

    }


    fun updateFromAPI() {

        viewModelScope.launch(Dispatchers.Default) {

            try {
                val listOfExperiences: List<Experience> = repository.getDataFromAPI().result

                withContext(Dispatchers.Main){

//                    if(experiences.value!!.isEmpty()) {
//                        repository.insert(listOfExperiences)
//                    }

                    for(experience in listOfExperiences){
                        repository.insert(experience)
                    }

                    loadFromDB()
                }

            } catch (e: Throwable) {

                withContext(Dispatchers.Main) {
                    error.value = e
                }
            }
        }


    }
}
