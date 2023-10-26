package kz.just_code.customviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.just_code.customviewapp.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.backClick = {
            finish()
        }
    }
}