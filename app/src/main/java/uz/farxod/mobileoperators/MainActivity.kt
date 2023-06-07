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
import androidx.fragment.app.Fragment
import uz.farxod.mobileoperators.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavLayout.visibility = View.GONE
        supportFragmentManager.beginTransaction().add(R.id.fragment_blank, MotionFragment()).commit()

        Handler().postDelayed({

            binding.bottomNavLayout.visibility = View.VISIBLE
            replaceFragment(MainFragment()) //asosiy oyna

            binding.bottomNavigationView.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.home -> replaceFragment(MainFragment())
                    R.id.news -> replaceFragment(NewsFragment())
                    R.id.operators -> replaceFragment(OperatorsFragment())
                    R.id.settings -> replaceFragment(SettingsFragment())

                    else -> {}
                }
                true
            }
        }, 4500)

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_blank, fragment).commit()
    }
}