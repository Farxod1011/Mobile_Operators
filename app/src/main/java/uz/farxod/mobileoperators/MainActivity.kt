package uz.farxod.mobileoperators

import android.opengl.Visibility
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionController
import androidx.constraintlayout.motion.widget.MotionLayout
import uz.farxod.mobileoperators.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragManager = supportFragmentManager.beginTransaction()
        fragManager.add(R.id.fragment_blank, MotionFragment()).commit()

    }
}