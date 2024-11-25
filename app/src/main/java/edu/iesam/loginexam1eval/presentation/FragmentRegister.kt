package edu.iesam.loginexam1eval.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.loginexam1eval.databinding.FragmentFormRegisterBinding
import edu.iesam.loginexam1eval.domain.User
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentRegister:Fragment() {
    val register:RegisterViewModel by viewModel()
    private var _binding : FragmentFormRegisterBinding ?= null
    val binding get() = _binding !!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        register.buildView(bindData())
        super.onViewCreated(view, savedInstanceState)
    }
    fun bindData():User{
        val id = binding.usernameCreate.toString()
        val username = binding.usernameCreate.toString()
        val password= binding.passwordCreate.toString()
        return User(id,username,password)
    }
}