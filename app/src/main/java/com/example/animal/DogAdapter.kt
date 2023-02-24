package com.example.animal

import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class DogAdapter(
    private val listDog: List<Dog>
): Adapter<DogAdapter.DogViewHolder>() {

    private val colors = arrayOf("#9D3C72", "#144272", "#3C2A21", "#DC0000", "#CB1C8D", "#810CA8")

    inner class DogViewHolder(private val itemDog: View): RecyclerView.ViewHolder(itemDog){
            val tvDogName = itemDog.findViewById<TextView>(R.id.tvname)
            val tvDogBreed = itemDog.findViewById<TextView>(R.id.tvBreed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dog, parent, false))
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogs = listDog[position]
        holder.tvDogName.apply {
            text = dogs.age?.let {
                dogs.dogName + "(Age = $it)"
            } ?: dogs.dogName
            setTextColor(Color.parseColor(colors[position % colors.size]))
            if(text.endsWith("A", true)){
            typeface = Typeface.DEFAULT_BOLD
            }
            if (text.startsWith("B", true)){
                typeface = Typeface.create(typeface, Typeface.ITALIC)
                Log.d("TAG", "onBindViewHolder: $text")
            }
        }
        holder.tvDogBreed.text = dogs.dogBreed
    }

    override fun getItemCount(): Int {
        Log.d("varna", "getItemCount: ${listDog.size}")
        return listDog.size
    }
}
