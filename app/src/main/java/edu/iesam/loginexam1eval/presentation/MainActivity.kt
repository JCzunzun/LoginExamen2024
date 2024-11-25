package edu.iesam.loginexam1eval.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import edu.iesam.loginexam1eval.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Método de prueba para acceder a los elementos de la vista
     */
    private fun setupView(){
        val username = findViewById<EditText>(R.id.username).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        val reminderIsChecked = findViewById<CheckBox>(R.id.reminder).isChecked
        findViewById<Button>(R.id.action).setOnClickListener {
            //Hago algo con los datos
        }
        findViewById<Button>(R.id.register).setOnClickListener{
            it.findNavController().navigate(R.layout.fragment_form_register)
        }
    }


}