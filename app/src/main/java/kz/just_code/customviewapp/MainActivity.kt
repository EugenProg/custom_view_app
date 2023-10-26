package kz.just_code.customviewapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kz.just_code.customviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.favoriteClick = {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

       /* binding.toolbar.title = "New toolbar title"
        binding.toolbar.showFavoriteButton = true*/
    }


}