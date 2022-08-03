package com.example.retrofitlearning;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {







        @SerializedName("userId")
        @Expose
        private Integer userId;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("body")
        @Expose
        private String text;

    public Post(Integer userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

