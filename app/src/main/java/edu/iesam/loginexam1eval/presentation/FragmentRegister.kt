package edu.iesam.loginexam1eval.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.loginexam1eval.databinding.FragmentFormRegisterBinding
import edu.iesam.loginexam1eval.domain.User
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentRegister : Fragment() {
    val register: RegisterViewModel by viewModel()
    private var _binding: FragmentFormRegisterBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.actionCreate.setOnClickListener {
            register.buildUser(bindData())
        }
        setObservers()
        super.onViewCreated(view, savedInstanceState)
    }
    fun setObservers(){
        val observer = Observer<RegisterViewModel.UiState>{ uiState ->
            if (uiState.create){
                navigation()
            }else{
                Log.d("Login", "Usuario no creado")
            }
        }
        register.uiState.observe(viewLifecycleOwner, observer)
    }

    fun bindData(): User {
        val id = binding.usernameCreate.text.toString()
        val username = binding.usernameCreate.text.toString()
        val password = binding.passwordCreate.text.toString()
        var user = User(id, username, password,false)

        return user
    }
    fun navigation(){
        findNavController().navigate(FragmentRegisterDirections.actionFragmentRegister2ToFragmentWelcome())
    }
}