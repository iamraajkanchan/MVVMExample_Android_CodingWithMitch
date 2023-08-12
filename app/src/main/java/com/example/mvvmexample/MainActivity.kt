package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexample.adapters.RecyclerAdapter
import com.example.mvvmexample.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var myAdapter: RecyclerAdapter? = null
    private var mMainActivityViewModel: MainActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMainActivityViewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        mMainActivityViewModel?.nicePlaces?.observe(this) {
            myAdapter?.notifyDataSetChanged()
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        myAdapter = RecyclerAdapter(
            this,
            mMainActivityViewModel?.nicePlaces?.value ?: emptyList()
        )
        val linearLayoutManager = LinearLayoutManager(this)
        rvNicePlaceList.layoutManager = linearLayoutManager
        rvNicePlaceList.adapter = myAdapter
    }
}