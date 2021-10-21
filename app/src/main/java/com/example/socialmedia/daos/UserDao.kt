package com.example.socialmedia.daos

import com.example.socialmedia.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {

    val db = Firebase.firestore
    val usersCollection = db.collection("users")

    fun addUser(user: User?) {
        GlobalScope.launch {
            user?.let {
                usersCollection.document(user.uid).set(it)
            }
        }
    }

    fun getUserById(uid: String) : Task<DocumentSnapshot>{
        return usersCollection.document(uid).get()
    }

}