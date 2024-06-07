package com.o5appstudio.androidconcepts.mvvmpractice.usersapi

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.o5appstudio.androidconcepts.databinding.ActivityUsersMvvmactivityBinding
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.adapter.UsersAdapter
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.api.UserService
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.api.UsersApiHelper
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.repository.UsersRepository
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.repository.UsersResponse
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.viewmodel.UsersViewModel
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.viewmodel.UsersViewModelFactory

class UsersMVVMActivity : AppCompatActivity() {
    lateinit var binding: ActivityUsersMvvmactivityBinding
    private lateinit var viewModel: UsersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersMvvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.userList.layoutManager = LinearLayoutManager(this)


        val userService = UsersApiHelper.getInstance().create(UserService::class.java)
        val repository = UsersRepository(userService)
        viewModel = ViewModelProvider.create(this, UsersViewModelFactory(repository))[UsersViewModel::class.java]

        val adapter  = UsersAdapter(this, arrayListOf())
        binding.userList.adapter = adapter

        viewModel.usersList.observe(this) {
            when(it){
                is UsersResponse.Loading -> {
                    binding.loading.visibility = View.VISIBLE
                    binding.userList.visibility = View.GONE
                    binding.errorMessage.visibility = View.GONE
                }
                is UsersResponse.Failure -> {
                    binding.loading.visibility = View.GONE
                    binding.userList.visibility = View.GONE
                    binding.errorMessage.visibility = View.VISIBLE
                    binding.errorMessage.text = it.errorMessage.toString()
                }
                is UsersResponse.Success -> {
                    binding.errorMessage.visibility = View.GONE
                    binding.loading.visibility = View.GONE
                    binding.userList.visibility = View.VISIBLE
                    it.data?.let { it1 -> adapter.updateUsers(it1) }
                }



            }
        }


    }
}