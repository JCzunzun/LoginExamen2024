package edu.iesam.loginexam1eval.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.iesam.loginexam1eval.databinding.FragmentViewFormBinding

class FragmentLogin:Fragment() {
    private var _binding: FragmentViewFormBinding?= null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentViewFormBinding.inflate(inflater,container,false)
        setupView()
        return binding.root
    }



    private fun setupView(){
        binding.register.setOnClickListener{
            navigation()
        }

        /*
        val username = findViewById<EditText>(R.id.username).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        val reminderIsChecked = findViewById<CheckBox>(R.id.reminder).isChecked
        findViewById<Button>(R.id.action).setOnClickListener {
            //Hago algo con los datos
        }
        */
    }
    fun navigation(){
        findNavController().navigate(FragmentLoginDirections.actionFragmentLoginToFragmentRegister2())
    }
}