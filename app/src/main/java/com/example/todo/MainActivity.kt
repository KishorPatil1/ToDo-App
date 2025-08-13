package com.example.todo

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log



class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var listView: ListView

    var itemlist=ArrayList<String>()
    var filehelper=FileHelper()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.text)
        button = findViewById(R.id.button)
        listView = findViewById(R.id.list)
        itemlist=filehelper.readdata(this@MainActivity)
        val arrayAdapter= ArrayAdapter(this@MainActivity,android.R.layout.simple_expandable_list_item_1,itemlist)
        listView.adapter=arrayAdapter
        button.setOnClickListener {
            Log.d("123", "Add button clicked")
            val item:String=editText.text.toString()
            itemlist.add(item)
            editText.setText("")
            filehelper.writedata(itemlist,applicationContext)
            arrayAdapter.notifyDataSetChanged()

        }
        listView.setOnItemClickListener { parent, view, position, id ->
            var alert=AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Delete")
            alert.setMessage("Do you want to delete a item from a list?")
            alert.setCancelable(false)
            alert.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, which ->
                dialogInterface.cancel()
            })
            alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, which ->
                itemlist.removeAt(position)
                arrayAdapter.notifyDataSetChanged()
                filehelper.writedata(itemlist,applicationContext)
            })
            alert.create().show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}