package com.example.jswhatsapp.models

class ChatContact {

    var id: Int
    var name: String
    var description: String
    var time: String
    var profileImage: Int

    constructor(id: Int, name: String, description: String, time: String, profileImage: Int){

        this.id = id
        this.name = name
        this.description = description
        this.time = time
        this.profileImage = profileImage

    }

}