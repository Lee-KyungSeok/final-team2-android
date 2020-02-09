package com.def.team2.network

import com.def.team2.network.model.*
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @POST("/api/users/validation")
    fun checkEmailDuplicated(@Body checkEmailRequest: Map<String, String>): Completable

    @GET("api/school")
    fun getSchool(@Query("schoolId") schoolId: Long): Single<School>

    @GET("/api/school/nearby")
    fun getNearSchoolList(@Query("start_y") south: Double,
                          @Query("end_y") north: Double,
                          @Query("start_x") west: Double,
                          @Query("end_x") east: Double,
                          @Query("size") pageSize: Int): Single<List<School>>

    @GET("/api/school/search")
    fun searchSchoolList(@Query("query") schoolName: String,
                         @Query("size") pageSize: Int): Single<List<School>>

    @GET("/api/idol/search")
    fun searchIdolList(@Query("query") idolName: String): Single<List<Idol>>

    @POST("/api/users")
    fun signUp(@Body signUpRequest: SignUpRequest): Single<SignUpResponse>

    @POST("/api/login")
    fun signIn(@Body signInRequest: SignInRequest): Single<SignInResponse>

    @POST("/api/vote")
    fun vote(@Body voteRequest: VoteRequest): Single<VoteResponse>

    @GET("/api/vote")
    fun getVote(): Single<List<VoteResponse>>

    @GET("/api/me")
    fun getMe(): Single<User>

    @GET("/api/users")
    fun getUsers(@Query("userId") userId: String): Single<User>
}