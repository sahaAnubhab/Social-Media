package com.example.socialmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.socialmedia.daos.PostDao
import kotlinx.android.synthetic.main.activity_create_post.*

class CreatePostActivity : AppCompatActivity() {

    private lateinit var postDao: PostDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        postDao = PostDao()

        createPostButton.setOnClickListener {
            val postInput = postWriteUp.text.toString().trim()
            if (postInput.isNotEmpty()){
                postDao.addPost(postInput)
                finish()
            }else{
                Toast.makeText(this, "Please write a post.", Toast.LENGTH_SHORT).show()
            }
                
        }
    }
}