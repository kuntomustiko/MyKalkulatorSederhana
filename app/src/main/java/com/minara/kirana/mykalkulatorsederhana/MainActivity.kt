package com.minara.kirana.mykalkulatorsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHitungTambah.setOnClickListener {
            hasil("+")
        }

        btnHitungKurang.setOnClickListener {
            hasil("-")
        }
        btnHitungPerkalian.setOnClickListener {
            hasil("*")
        }
        btnHitungBagi.setOnClickListener {
            hasil("/")
        }
        btnHapus.setOnClickListener {
            edtAngkaPertama_main.text.clear()
            edtAngkaKedua_main.text.clear()
        }

    }

    fun hasil(operator: String) {
        if (testEmpty()) {
            val hasilButton = hitung(operator).toString()
            showAlert("$hasilButton")
        } else {
            showAlert("Isi terlebih dahulu")
        }
    }

    fun testEmpty() =
        edtAngkaPertama_main.text.toString().isNotEmpty() && edtAngkaKedua_main.text.toString().isNotEmpty()


    fun hitung(operator: String): Double {

        val angka1 = edtAngkaPertama_main.text.toString().toDouble()
        val angka2 = edtAngkaKedua_main.text.toString().toDouble()

        var hasil = 0.0
        when (operator) {
            "+" -> hasil = angka1.plus(angka2)
            "-" -> hasil = angka1.minus(angka2)
            "*" -> hasil = angka1.times(angka2)
            "/" -> hasil = angka1.div(angka2)
        }

        return hasil
    }

    fun showAlert(msg: String) {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Hasil")
        alert.setMessage(msg)
        alert.show()
    }
}
