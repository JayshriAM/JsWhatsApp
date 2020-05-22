package com.example.jswhatsapp.activities

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.jswhatsapp.MainActivity
import com.example.jswhatsapp.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth?=null
    private var database = FirebaseDatabase.getInstance()
    private var myRef = database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        mAuth = FirebaseAuth.getInstance()

        signupScreen_profile_image.setOnClickListener(View.OnClickListener {
            checkPermission()
        })

        signUpScreen_signupBtn.setOnClickListener {view->
            if (signUpScreen_email.text.trim().length!=0 && signUpScreen_password.text.trim().length!=0){
                SignUpToFireBase(signUpScreen_email.text.toString(), signUpScreen_password.text.toString())
            }else{
                Snackbar.make(view, "Enter all the details.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }

    }
    fun SignUpToFireBase (email: String, password:String){
        mAuth!!.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {task ->
            if (task.isSuccessful){
                Toast.makeText(applicationContext,"Successful Login", Toast.LENGTH_LONG).show()
                var currentUser = mAuth!!.currentUser
                if (currentUser != null) {
                    SaveImageInFirebase()
                }
                LoadMain()
            }else{
                Toast.makeText(applicationContext,"Login Failed", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        LoadMain()
    }

    fun LoadMain(){
        var currentUser = mAuth!!.currentUser

        if (currentUser!=null){
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", currentUser.email)
            intent.putExtra("uid", currentUser.uid)

            startActivity(intent)

        }
    }

    fun splitString(str:String): String{
        var split = str.split("@")
        return split[0]
    }

    val READIMAGE: Int = 253
    fun checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) !=
                PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    READIMAGE
                )
                return
            }
        }
        loadImage()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            READIMAGE -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadImage()
                } else {
                    Toast.makeText(applicationContext, "Cannot Access Storage", Toast.LENGTH_LONG)
                        .show()
                }
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    val PICK_IMAGE_CODE = 123

    fun loadImage() {
        val galleryIntent = Intent()
        galleryIntent.type = ("image/*")
        galleryIntent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(galleryIntent, PICK_IMAGE_CODE)
    }

    //THIS METHOD GETS FIRED AUTOMATICALLY WHEN THE startActivityForResult is called
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_CODE && resultCode == Activity.RESULT_OK && data != null) {

            try {
                val imgUri = data.data
                val bitMap: Bitmap =
                    BitmapFactory.decodeStream(imgUri?.let { contentResolver.openInputStream(it) })
                signupScreen_profile_image.setImageBitmap(bitMap)
            } catch (ex: Exception) {
                ex.message

            }
        }
    }

    fun SaveImageInFirebase(){
        var currentUser = mAuth!!.currentUser
        var email:String = currentUser!!.email.toString()
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.getReferenceFromUrl("gs://jswhatsapp-9ad4f.appspot.com")
        val df = SimpleDateFormat("ddMMyyHHmmss")
        val dataObj = Date()
        val imagePath = splitString(email) + "." + df.format(dataObj) + ".jpg"
        val ImageRef = storageRef.child("images/"+imagePath)
        signupScreen_profile_image.isDrawingCacheEnabled = true
        signupScreen_profile_image.buildDrawingCache()
        val drawable = signupScreen_profile_image.drawable as BitmapDrawable
        val bitmap = drawable.bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos)
        val data = baos.toByteArray()
        val uploadTask = ImageRef.putBytes(data)
        uploadTask.addOnFailureListener{
            Toast.makeText(applicationContext,"Failed to upload your profile pic",Toast.LENGTH_LONG).show()
        }.addOnSuccessListener {taskSnapshot ->
            var DownloadUrl = taskSnapshot.storage.downloadUrl.toString()
            myRef.child("Users").child(currentUser.uid).child("email").setValue(currentUser.email)
            myRef.child("Users").child(currentUser.uid).child("ProfileImage").setValue(DownloadUrl)
            LoadMain()
        }
    }

//    fun loadImage(){
//        var intent = Intent(Intent.ACTION_PICK,
//        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//        startActivityForResult(intent, PICK_IMAGE_CODE)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == PICK_IMAGE_CODE && data != null){
//            val selectedImage = data.data
//            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
//            //val cursor = contentResolver.query(selectedImage, filePathColumn, null, null, null)
//            val cursor =
//                selectedImage?.let { contentResolver.query(it, filePathColumn, null, null, null) }
//            cursor!!.moveToFirst()
//            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
//            val picturePath = cursor.getString(columnIndex)
//            cursor.close()
//            signupScreen_profile_image.setImageBitmap(BitmapFactory.decodeFile(picturePath))
//        }
//    }

}
