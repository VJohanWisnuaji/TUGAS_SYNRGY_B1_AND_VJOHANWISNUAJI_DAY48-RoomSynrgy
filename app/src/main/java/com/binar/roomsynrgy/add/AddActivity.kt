package com.binar.roomsynrgy.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.binar.roomsynrgy.db.Item
import com.binar.roomsynrgy.R
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity(), AddActivityPresenter.Listener {
    private lateinit var presenter: AddActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnSave.setOnClickListener {
            val item = Item(
                null,
                etName.text.toString(),
                etQuantity.text.toString().toInt()
            )
           presenter.saveItem(item)
        }
    }

    override fun showSaveSuccess() {
        runOnUiThread {
                Toast.makeText(this@AddActivity,"Data Sukses Disimpan", Toast.LENGTH_LONG).show()
        }
    }

    override fun showSaveFailed() {
        runOnUiThread {
            Toast.makeText(this@AddActivity,"Data Gagal Disimpan", Toast.LENGTH_LONG).show()
        }
    }
}