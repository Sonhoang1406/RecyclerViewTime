package com.example.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var itemRecyclerView: RecyclerView
    private lateinit var itemList: ArrayList<Item>
    lateinit var timeList: Array<String>
    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timeList = arrayOf(
            "1m",
            "2m",
            "5m",
            "10m",
            "15m",
            "30m",
            "1H",
            "2H",
            "1D",
            "7D"
        )
        itemRecyclerView = findViewById(R.id.rcvItem)
        itemRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        itemRecyclerView.setHasFixedSize(true)
        itemList = arrayListOf<Item>()


        itemAdapter = ItemAdapter(itemList)
        itemRecyclerView.adapter = itemAdapter
        getItemData()
    }

    private fun getItemData() {
        for(i in timeList.indices){
            val item = Item(timeList[i])
            itemList.add(item)
        }
    }
}