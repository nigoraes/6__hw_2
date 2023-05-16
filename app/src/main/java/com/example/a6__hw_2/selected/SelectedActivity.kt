package com.example.a6__hw_2.selected

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a6__hw_2.MainActivity.Companion.MA_SA
import com.example.a6__hw_2.databinding.ActivitySelectedBinding
import com.example.a6__hw_2.model.Photo
import com.example.a6__hw_2.selected.adapter.PhotoAdapter

class SelectedActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectedBinding
    private lateinit var adapter: PhotoAdapter
    private var list: ArrayList<Photo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initGetExtra()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initGetExtra() {
        val getExtra = intent.getSerializableExtra(MA_SA) as? ArrayList<Photo>
        if (getExtra != null) {
            list.addAll(getExtra)
            adapter.notifyDataSetChanged()
        }
    }

    private fun initAdapter() {
        adapter = PhotoAdapter(list,
            clickListener = { },
            deleteItem = { }
        )
        binding.recyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBackPressed() {
        super.onBackPressed()
        list.clear()
        adapter.notifyDataSetChanged()
        finish()
    }
}