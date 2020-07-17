package com.example.task.viewModels

import androidx.lifecycle.*
import com.example.task.Repository
import com.example.task.data.Experience
import com.example.task.models.ResultExp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel: ViewModel() {

    lateinit var repository: Repository

    val experienceInDetail: MutableLiveData<Experience> = MutableLiveData()


    val error: MutableLiveData<Throwable> = MutableLiveData()


    fun loadFromDB(id: String) {

        viewModelScope.launch {

            experienceInDetail.value = repository.getExperienceById(id)
//            experienceInDetail.value = experience
        }

    }


    fun updateFromAPI(id: String) {

        viewModelScope.launch(Dispatchers.Default) {


            try {
                val detailExperience: Experience = repository.getDetailFromAPI(id).result
                withContext(Dispatchers.Main) {

                    repository.update(detailExperience)
                    loadFromDB(id)

                  //  experienceInDetail.value = detailExperience
                }
            }catch (e: Throwable){
                withContext(Dispatchers.Main){
                    error.value = e
                }
            }
        }
    }



}