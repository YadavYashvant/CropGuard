package com.example.compose_tflite.plantsApi_feature.network
import com.example.compose_tflite.plantsApi_feature.model.Movie
import com.example.compose_tflite.plantsApi_feature.model.expTrefle.Plant
import com.example.compose_tflite.plantsApi_feature.model.expTrefle.PlantData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
/*https://trefle.io/api/v1/plants?token=VTBxqDOSN_RDSJQKrC_P-XvdTQq-7mVRKFQPhsC_9RI*/
interface ApiService {
    @GET("movielist.json")
    /*@GET("plants?token=VTBxqDOSN_RDSJQKrC_P-XvdTQq-7mVRKFQPhsC_9RI")*/
    suspend fun getMovies() : List<Movie>

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    /*.baseUrl("https://trefle.io/api/v1/")*/
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}