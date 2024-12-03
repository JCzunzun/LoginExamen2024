package edu.iesam.loginexam1eval.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.loginexam1eval.databinding.FragmentUnsuscribeBinding
import edu.iesam.loginexam1eval.domain.User
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentUnsuscribe : Fragment() {
    private var _binding: FragmentUnsuscribeBinding? = null
    val binding get() = _binding!!
    val unsuscribeViewModel: UnsuscribeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUnsuscribeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.actionUnsuscribe.setOnClickListener {
            bindData()
        }
        setupObservers()
    }

    fun setupObservers() {
        val observer = Observer<UnsuscribeViewModel.UiState> { uiState ->
            if (uiState.delete == true) {
                navigationToLogin()
            } else {
                Log.d("Login", "Usuario no encontrado")
            }
        }
        unsuscribeViewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    fun bindData() {
        val username = binding.usernameUnsuscribe.text.toString()
        val password = binding.passwordUnsuscribe.text.toString()
        val user = User(username, username, password, false)
        unsuscribeViewModel.unsuscribe(user)
    }

    fun navigationToLogin() {
        findNavController().navigate(FragmentUnsuscribeDirections.actionFragmentUnsuscribeToFragmentLogin())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}