package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexample.adapters.RecyclerAdapter
import com.example.mvvmexample.models.NicePlace
import com.example.mvvmexample.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var myAdapter: RecyclerAdapter? = null
    private var mMainActivityViewModel: MainActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMainActivityViewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        mMainActivityViewModel?.initialize()
        mMainActivityViewModel?.getNicePlaces()?.observe(this, Observer {
            myAdapter?.notifyDataSetChanged()
        })
        initRecyclerView()
    }

    private fun initRecyclerView() {
        myAdapter = RecyclerAdapter(
            this,
            mMainActivityViewModel?.getNicePlaces()?.value as ArrayList<NicePlace>
        )
        val linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = myAdapter
    }
}