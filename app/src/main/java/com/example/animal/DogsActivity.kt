package com.example.animal

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import net.datafaker.Faker

class DogsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs)

        val rvDog = findViewById<RecyclerView>(R.id.rvDog)

        val faker: Faker = Faker()

        val list: ArrayList<Dog> = ArrayList()
        for (i in 1..100) {
            val dogName = faker.dog().name()
            if (dogName.startsWith("C", true)){
                list.add(Dog(dogName, faker.dog().breed(),5))
            }else{
            list.add(Dog(dogName, faker.dog().breed()))
            }
        }
        val filteredDog: List<Dog> = list.filter { 
            it.age != null
        }
        Log.d("var13", "onCreate: ${filteredDog.size}")


        rvDog.adapter = DogAdapter(list)
        rvDog.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvDog.addItemDecoration(object : ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                val position = parent.getChildAdapterPosition(view)
                when {
                    position == 0 -> outRect.top = 40
                    position % 4 == 0 -> outRect.bottom = 60

                }
            }
        })
    }
}
