package com.example.roboter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
//import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Environment
import java.io.File

//< init >
var phonenumber_spareparts = "+49 4447 801 373"
var phonenumber_service = "+49 4447 801 4500"
//</ init >




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //dial the spareparts
        btnsparepartsnumber.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_DIAL, Uri.parse(
                    "tel:$phonenumber_spareparts"
                    //"tel:+@string/phonenumber_spareparts"
                )
            )
            startActivity(intent)
        }

        //dial the service
        btnservicenumber.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_DIAL, Uri.parse(
                    "tel:$phonenumber_service"
                    //"tel:+@string/phonenumber_spareparts"
                )
            )
            startActivity(intent)
        }

        //open the manual
        btnmanual.setOnClickListener {
            // applicationContext.assets.open("test.pdf").use


            fun openPDFDocument(context: Context, filename: String = "test") {
                //Create PDF Intent
                val pdfFile = File("/" + filename)
                val pdfIntent = Intent(Intent.ACTION_VIEW)
                pdfIntent.setDataAndType(Uri.fromFile(pdfFile), "app/")
                pdfIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)

                //Create Viewer Intent
                val viewerIntent = Intent.createChooser(pdfIntent, "Open PDF")
                context.startActivity(viewerIntent)
            }
        }
    }
}



