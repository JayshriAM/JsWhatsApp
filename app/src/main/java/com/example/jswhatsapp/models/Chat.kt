package com.example.jswhatsapp.models

class Chat {

    var id: Int
    var message: String
    var time: String
    var senderUid: String
    var receiverUid: String
    var sender: Boolean
    var receiver: Boolean

    constructor(id: Int, message: String, time: String, senderUid: String, receiverUid: String, sender: Boolean, receiver: Boolean){

        this.id = id
        this.message = message
        this.time = time
        this.senderUid = senderUid
        this.receiverUid = receiverUid
        this.sender = sender
        this.receiver = receiver
    }

}