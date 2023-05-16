package com.example.a6__hw_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a6__hw_2.databinding.ActivityMainBinding
import com.example.a6__hw_2.model.Photo
import com.example.a6__hw_2.selected.SelectedActivity
import com.example.a6__hw_2.selected.adapter.PhotoAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<Photo> = ArrayList()
    private var selectedList: ArrayList<Photo> = ArrayList()
    private lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        initAdapter()
        initListener()
    }

    private fun initListener() {
        binding.btnSend.setOnClickListener {
            val intent = Intent(this, SelectedActivity::class.java)
            intent.putExtra(MA_SA, selectedList)
            startActivity(intent)
        }
    }

    private fun initAdapter() {
        adapter = PhotoAdapter(list, this::clickListener, this::deleteItem)
        binding.recyclerView.adapter = adapter
    }

    private fun clickListener(item: Photo) {
        selectedList.add(item)
    }

    private fun deleteItem(item: Photo) {
        selectedList.remove(item)
    }

    private fun loadData() {
        list.add(Photo("https://images.pexels.com/photos/1187079/pexels-photo-1187079.jpeg?cs=srgb&dl=pexels-artem-saranin-1187079.jpg&fm=jpg"))
        list.add(Photo("https://e0.pxfuel.com/wallpapers/116/2/desktop-wallpaper-love-birds-beautiful-nature-background.jpg"))
        list.add(Photo("https://www.travelandleisure.com/thmb/rbPz5_6COrWFh94qFRHYLJrRM-g=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/iguazu-falls-argentina-brazil-MOSTBEAUTIFUL0921-e967cc4764ca4eb2b9941bd1b48d64b5.jpg"))
        list.add(Photo("https://i.pinimg.com/originals/b3/58/d2/b358d252429ed75cd15d66346d36d48f.jpg"))
        list.add(Photo("https://images.pexels.com/photos/1133957/pexels-photo-1133957.jpeg?cs=srgb&dl=pexels-philippe-donn-1133957.jpg&fm=jpg"))
        list.add(Photo("https://images.pexels.com/photos/206359/pexels-photo-206359.jpeg?cs=srgb&dl=pexels-pixabay-206359.jpg&fm=jpg"))
        list.add(Photo("https://i.pinimg.com/736x/c5/eb/32/c5eb32d557528e511b2b8860022d88ef--extreme-weather-nature-landscape.jpg"))
        list.add(Photo("https://images.pexels.com/photos/9454915/pexels-photo-9454915.jpeg?cs=srgb&dl=pexels-mo-eid-9454915.jpg&fm=jpg"))
        list.add(Photo("https://images.all-free-download.com/images/graphiclarge/creek_landscape_moss_mountain_606502.jpg"))
        list.add(Photo("https://cdn.pixabay.com/photo/2016/11/06/05/36/lake-1802337__340.jpg"))
        list.add(Photo("https://i.pinimg.com/originals/f3/03/1c/f3031c2a7cfc8fdd4e90a32b5ccb8c91.jpg"))
        list.add(Photo("https://www.adorama.com/alc/wp-content/uploads/2017/11/shutterstock_114802408-825x465.jpg"))
        list.add(Photo("https://images.all-free-download.com/images/graphiclarge/beautiful_scenery_04_hd_images_166175.jpg"))
        list.add(Photo("https://i.pinimg.com/originals/e6/87/24/e68724db306f08ee2ab2d3ed9f6ea8bb.jpg"))
        list.add(Photo("https://st.depositphotos.com/1903767/3375/i/600/depositphotos_33751169-stock-photo-provence-france-lavender-in-a.jpg"))
    }

    companion object {
        const val MA_SA = "MA_SA"
    }
}