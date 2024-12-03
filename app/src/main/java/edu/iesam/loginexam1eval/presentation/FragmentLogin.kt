package edu.iesam.loginexam1eval.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.loginexam1eval.databinding.FragmentViewFormBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentLogin:Fragment() {
    private var _binding: FragmentViewFormBinding?= null
    val binding get() = _binding!!
    val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentViewFormBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.register.setOnClickListener{
            navigationToRegister()
        }
        binding.action.setOnClickListener{
            bindData()
        }
        setupObservers()
    }

    fun setupObservers() {
        loginViewModel.getRememberUser()
        val observer = Observer<LoginViewModel.UiState> { uiState ->
            if (uiState.correct == true) {
                navigationToWelcome()
            }else{
                Log.d("Login", "Usuario no encontrado")
            }
            uiState.userReminder?.let {
                binding.username.setText(it.username)
                binding.password.setText(it.password)
            }
        }
        loginViewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    fun bindData(){
        val username = binding.username.text.toString()
        val password = binding.password.text.toString()
        val reminderIsChecked = binding.reminder.isChecked
        loginViewModel.login(username, password, reminderIsChecked)
    }

    fun navigationToRegister(){
        findNavController().navigate(FragmentLoginDirections.actionFragmentLoginToFragmentRegister2())
    }
    fun navigationToWelcome(){
        findNavController().navigate(FragmentLoginDirections.actionFragmentLoginToFragmentWelcome())
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}