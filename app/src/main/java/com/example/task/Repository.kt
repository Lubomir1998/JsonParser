package com.example.task

import com.example.task.data.ApiService
import com.example.task.data.Experience
import com.example.task.data.RetrofitHelper
import com.example.task.room.DbHelper
import com.example.task.room.ExperienceDao


class Repository(experienceDb: DbHelper) {

  // Room
    var experienceDao: ExperienceDao = experienceDb.exDao()


    suspend fun insert(experience: Experience){

//        experiences.forEach {
//            experienceDao.insert(it)
//        }

//        for(experience in experiences){
//            experienceDao.insert(experience)
//        }

        experienceDao.insert(experience)
    }

    suspend fun update(experience: Experience){
        experienceDao.update(experience)
    }

    suspend fun getAllFromDB(): List<Experience>{
        return experienceDao.getAllExperiences()
    }

    suspend fun getExperienceById(id: String): Experience{
        return experienceDao.getExperienceById(id)
    }


  // Retrofit
    private val client: ApiService = RetrofitHelper.retrofit


    suspend fun getDataFromAPI() = client.getDataFromApi()

    suspend fun getDetailFromAPI(id: String) = client.getDetailInfoFromApi(id)




}
