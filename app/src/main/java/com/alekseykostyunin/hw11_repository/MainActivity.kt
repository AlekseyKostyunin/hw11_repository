package com.alekseykostyunin.hw11_repository

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alekseykostyunin.hw11_repository.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            val textFromSave: String = binding.textInput.text.toString()
            repository.saveText(this, textFromSave)
            binding.textForLoading.text =  textFromSave
        }

        binding.buttonClear.setOnClickListener  {
            repository.clearText(this)
            binding.textForLoading.text = ""
        }

        binding.textForLoading.text = repository.getText(this)


    }
}