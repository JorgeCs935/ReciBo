package com.example.recibo

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class QrScannerActivity : AppCompatActivity() {

    private lateinit var btnScannerQr: Button
    private lateinit var tvScannedValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_qr_scanner)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnScannerQr = findViewById(R.id.btnScannerQr)
        tvScannedValue = findViewById(R.id.tvScannedValue)

        registerUiListener()

    }

    private fun registerUiListener(){
        btnScannerQr.setOnClickListener {
            scannerLauncher.launch(ScanOptions().setPrompt("Escanee el QR")
                .setDesiredBarcodeFormats(ScanOptions.QR_CODE)
            )
        }
    }

    private val scannerLauncher = registerForActivityResult<ScanOptions , ScanIntentResult>(
        ScanContract()
    ){result ->
        if (result.contents == null){
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
        }else{
            tvScannedValue.text = "Valor escaneado: " + result.contents
        }
    }
}