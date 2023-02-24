package com.example.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cat = findViewById<Button>(R.id.btnCat)
        val dog = findViewById<Button>(R.id.btnDog)
        val image = findViewById<ImageView>(R.id.ivAnimal)

        cat.setOnClickListener {
            image.setImageResource(R.drawable.cat)
        }

        dog.setOnClickListener {
//            image.setImageResource(R.drawable.dog)
            val intent = Intent(this, DogsActivity::class.java)
            startActivity(intent)

        }
    }
}
