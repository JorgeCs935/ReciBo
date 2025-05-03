package com.example.recibo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recibo.databinding.ActivitySignInBinding

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btChallenges.setOnClickListener{
            val intent = Intent(this , ChallengesActivity::class.java)
            startActivity(intent)
        }
        binding.btMap.setOnClickListener{
            val intent = Intent(this , MapActivity::class.java)
            startActivity(intent)
        }
        binding.btProfile.setOnClickListener{
            val intent = Intent(this , ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.btQrMenu.setOnClickListener{
            val intent = Intent(this , QrMenuActivity::class.java)
            startActivity(intent)
        }
        binding.btQrScanner.setOnClickListener{
            val intent = Intent(this , QrScannerActivity::class.java)
            startActivity(intent)
        }
        binding.btStore.setOnClickListener{
            val intent = Intent(this , StoreActivity::class.java)
            startActivity(intent)
        }
        binding.btStore.setOnClickListener{
            val intent = Intent(this , StoreActivity::class.java)
            startActivity(intent)
        }
        binding.btTipsAndNews.setOnClickListener{
            val intent = Intent(this , TipsAndNewsActivity::class.java)
            startActivity(intent)
        }

    }
}