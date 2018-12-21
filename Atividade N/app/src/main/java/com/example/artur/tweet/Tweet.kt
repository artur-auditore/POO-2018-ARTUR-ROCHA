package com.example.artur.tweet

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Tweet (var nomeAutor: String,
             var username: String,
             var texto: String,
             var data: String){

    @Id var id: Long = 0
}