package uz.farxod.mobileoperators

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.FragmentActivity
import uz.farxod.mobileoperators.databinding.FragmentMotionBinding
import uz.farxod.mobileoperators.databinding.FragmentNewsBinding
import java.lang.Math.log

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val webView: WebView = binding.webView
        webView.webViewClient = WebViewClient() //Это позволяет обрабатывать переходы по ссылкам внутри WebView.

        webView.loadUrl("https://beeline.uz/uz/events/category/news") //"https://beeline.uz/uz/events/category/news"

        binding.backWeb.setOnClickListener { webView.goBack() }     //oldingi adresga qaytishi un
        binding.refreshWeb.setOnClickListener {
            webView.reload()                                        //obnovleniye
            val rotate = AnimationUtils.loadAnimation(requireContext(), R.anim.anim)
            binding.refreshWeb.startAnimation(rotate)               //anim
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

