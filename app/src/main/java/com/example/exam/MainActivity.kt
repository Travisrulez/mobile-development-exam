package com.example.exam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val verticalLinearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val userFragment = UserFragment()

        binding.recyclerView.layoutManager = verticalLinearLayoutManager
        binding.recyclerView.adapter = UsersAdapter(DataHolder.dataList) { data ->
            val bundle = Bundle()
            bundle.putString("name", data.name)
            bundle.putString("surname", data.surname)
            userFragment.arguments = bundle
            /*fragmentTransaction.add(R.id.fragment_container).commit()*/

            val transaction = supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, userFragment)
            transaction.commit()

        }
    }


}