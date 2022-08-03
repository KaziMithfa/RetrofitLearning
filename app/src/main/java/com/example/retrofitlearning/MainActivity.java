package com.example.retrofitlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private JsonPlaceHolder jsonPlaceHolder;
    private List<Integer>postId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textviewId);
        postId = new ArrayList<>();
        postId.add(2);
        postId.add(3);
        postId.add(4);

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        //getPosts();

        //getComments();

        //createPost();

        //updatePosts();

        deletePosts();




    }

    private void deletePosts(){
        Call<Void>call = jsonPlaceHolder.deleteposts(1);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                    textView.setText(response.code());

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void updatePosts() {

        Post post = new Post(12,"Hello",null);
        Call<Post>call = jsonPlaceHolder.putPost(1,post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    textView.setText(response.code());
                }

                Post post1 = response.body();
                String text = "";
                text+= "Code: "+response.code()+"\n";
                text+= "ID: "+post1.getId()+"\n";
                text+= "User ID: "+post1.getUserId()+"\n";
                text+= "Title: "+post1.getTitle()+"\n\n";

                textView.setText(text);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void createPost() {
        Post post = new Post(12,"Hello","Bangladesh");

        Call<Post>call = jsonPlaceHolder.createPost(12,"Hello","Bangladesh");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    textView.setText(response.code());
                    return;

                }

                Post  post1  = response.body();


                String text = "";
                text+= "Code: "+response.code()+"\n";
                text+= "ID: "+post1.getId()+"\n";
                text+= "User ID: "+post1.getUserId()+"\n";
                text+= "Title: "+post1.getTitle()+"\n\n";

                textView.setText(text);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


    }

    private void getComments() {
        Map<String,String>parameters = new HashMap<>();
        parameters.put("postId","1");
        parameters.put("_sort","id");
        parameters.put("_order","desc");

        Call<List<Comment>>call = jsonPlaceHolder.getComments(parameters);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if(!response.isSuccessful()){
                    textView.setText(response.code());
                }

                List<Comment>comments = response.body();

                for(Comment comment : comments){

                    String text = "";
                    text += "Post Id: "+comment.getPostId()+"\n";
                    text += "Id : "  +comment.getId() + "\n";
                    text += "Name : "  +comment.getName() + "\n";
                    text += "Email : "  +comment.getEmail() + "\n";
                    text += "Text : "  +comment.getText()+ "\n\n";

                    textView.append(text);

                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {



            }
        });

    }

    private void getPosts() {

        Call<List<Post>>call = jsonPlaceHolder.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()){
                    textView.setText(response.code());
                }

                List<Post>posts = response.body();

                for(Post post : posts){
                    String text = "";
                    text += "User Id: "+post.getUserId()+"/n";
                    text += "Id : "  +post.getId() + "/n";
                    text += "title : "  +post.getTitle() + "/n";
                    text += "Text : "  +post.getText() + "/n/n";

                    textView.append(text);

                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                textView.setText(t.getMessage());

            }
        });


    }


}