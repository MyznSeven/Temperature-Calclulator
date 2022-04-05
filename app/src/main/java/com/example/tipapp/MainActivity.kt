package com.example.tipapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.tipapp.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            if (binding.inputSuhuEditText.text?.isEmpty() == true) {
                binding.inputSuhuEditText.error = "Isi kolom ini terlebih dahulu"
            } else {
                hitungSuhu()
                namaSuhu()
            }
        }
        binding.inputSuhuEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(view, keyCode)
        }
    }

    private fun namaSuhu() {
        val suhupilihan = binding.tipOptions.checkedRadioButtonId
        if (suhupilihan == R.id.celcius1) {
            binding.inputSuhu.setEndIconDrawable(R.drawable.ic_temperature_1)
        }
    }

    private fun hitungSuhu() {
        val stringInput = binding.inputSuhuEditText.text.toString()
        val suhu = stringInput.toDouble()
        val suhuPilihan1 = binding.tipOptions.checkedRadioButtonId
        val suhuPilihan2 = binding.konversiKeSini.checkedRadioButtonId
        fun hitungSuhu(): Double {
            return if (suhuPilihan1 == R.id.celcius1 && suhuPilihan2 == R.id.celcius2) {
                suhu * 1
            } else if (suhuPilihan1 == R.id.celcius1 && suhuPilihan2 == R.id.kelvin2) {
                suhu + 273.15
            } else if (suhuPilihan1 == R.id.celcius1 && suhuPilihan2 == R.id.farenheit2) {
                suhu * 1.8 + 32
            } else if (suhuPilihan1 == R.id.kelvin1 && suhuPilihan2 == R.id.celcius2) {
                suhu - 273.15
            } else if (suhuPilihan1 == R.id.kelvin1 && suhuPilihan2 == R.id.kelvin2) {
                suhu * 1
            } else if (suhuPilihan1 == R.id.kelvin1 && suhuPilihan2 == R.id.farenheit2) {
                suhu * 1.8 - 459.67
            } else if (suhuPilihan1 == R.id.farenheit1 && suhuPilihan2 == R.id.celcius2) {
                (suhu - 32) / 1.8
            } else if (suhuPilihan1 == R.id.farenheit1 && suhuPilihan2 == R.id.kelvin2) {
                (suhu + 459.67) * 5 / 9
            } else if (suhuPilihan1 == R.id.farenheit1 && suhuPilihan2 == R.id.farenheit2) {
                suhu * 1
            } else if (suhuPilihan1 == R.id.reamur1 && suhuPilihan2 == R.id.farenheit2) {
                (suhu * 9 / 4) + 32
            } else if (suhuPilihan1 == R.id.reamur1 && suhuPilihan2 == R.id.celcius2) {
                suhu * 5 / 4
            } else if (suhuPilihan1 == R.id.reamur1 && suhuPilihan2 == R.id.kelvin2) {
                (suhu * 5 / 4) + 273.15
            } else if (suhuPilihan1 == R.id.farenheit1 && suhuPilihan2 == R.id.reamur2) {
                (suhu - 32) * 4 / 9
            } else if (suhuPilihan1 == R.id.celcius1 && suhuPilihan2 == R.id.reamur2) {
                suhu * 4 / 5
            } else if (suhuPilihan1 == R.id.kelvin1 && suhuPilihan2 == R.id.reamur2) {
                (suhu - 273.15) * 4 / 5
            } else suhu * 1
        }

        fun hasil(): Double {
            return if (binding.bulatkan.isChecked) {
                ceil(hitungSuhu())
            } else {
                hitungSuhu()
            }
        }
        binding.hasilkalkulasi.text = getString(R.string.tip_amount, hasil().toString())
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}
