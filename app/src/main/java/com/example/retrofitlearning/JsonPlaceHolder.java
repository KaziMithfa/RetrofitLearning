package com.example.retrofitlearning;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Post>>getPosts();

   /* @GET("comments")
    Call<List<Comment>>getComments(@Query("postId") Integer[] userId,
                                   @Query("_sort")String sort,
                                   @Query("_order")String order

    );*/

    @GET("comments")
    Call<List<Comment>>getComments(@QueryMap Map<String,String>parameters);

    /*@POST("posts")
    Call<Post>createPost(@Body Post post);*/


    @POST("posts")
    Call<Post>createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post>createPost(
            @Field("userId")int userId,
            @Field("title") String title,
            @Field("body") String text

    );

    @PUT("posts/{id}")
    Call<Post>putPost(
            @Path("id")int id,
            @Body Post post
    );

   @PATCH("posts/{id}")
    Call<Post>putpatch(
            @Body Post post
    );

   @DELETE("posts/{id}")
    Call<Void>deleteposts(
            @Path("id")int id
   );












}
