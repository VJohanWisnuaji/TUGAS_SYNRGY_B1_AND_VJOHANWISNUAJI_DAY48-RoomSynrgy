package com.binar.roomsynrgy.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.binar.roomsynrgy.db.Item
import com.binar.roomsynrgy.R
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity(), EditActivityPresenter.Listener {
    private lateinit var presenter: EditActivityPresenter
    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        intent.getParcelableExtra<Item>("item")?.let {
            item = it
        }

        etName.setText(item.name)
        etQuantity.setText(item.quantity.toString())

        etName.addTextChangedListener {
            Toast.makeText(this@EditActivity, "EditText Berubah", Toast.LENGTH_LONG).show()
        }

        btnSave.setOnClickListener {
            item.apply {
                name = etName.text.toString()
                quantity = etQuantity.text.toString().toInt()
            }
            presenter.editItem(item)
        }
    }

    override fun showEditSuccess() {
        runOnUiThread {
            Toast.makeText(this@EditActivity, "Data Sukses Diupdate", Toast.LENGTH_LONG).show()
            this@EditActivity.finish()
        }
    }

    override fun showEditFailed() {
        runOnUiThread {
            Toast.makeText(this@EditActivity, "Data Gagal Diupdate", Toast.LENGTH_LONG).show()
        }
    }
}