package com.example.crypto_app.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crypto_app.Adapter.CryptoListAdapter
import com.example.crypto_app.ViewModel.MainViewModel
import com.example.crypto_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initRecyclerviewCrypto()

    }

    private fun initRecyclerviewCrypto() {
        binding.view.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.view.adapter=CryptoListAdapter(mainViewModel.loadData())
    }
}