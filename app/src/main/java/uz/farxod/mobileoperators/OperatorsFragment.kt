package uz.farxod.mobileoperators

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import uz.farxod.mobileoperators.databinding.FragmentNewsBinding
import uz.farxod.mobileoperators.databinding.FragmentOperatorsBinding


class OperatorsFragment : Fragment() {

    private var _binding: FragmentOperatorsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOperatorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    // В активности, принимающей данные:
        val args = this.arguments
        val inputDate = args?.getString("key")

        if (inputDate != null)
            select(inputDate.toString())
        else
            webView("https://beeline.uz/uz/events/category/news")

    }
    private fun select(key: String){
        when(key){
            "tarif" -> {webView("https://beeline.uz/uz/products/tariffs")}
            "xizmatlar" -> {webView("https://beeline.uz/uz/products/services")}
            "internet" -> {webView("https://beeline.uz/uz/products/packages")}

            else -> {webView("https://beeline.uz")}
        }
    }
    private fun webView(str: String){
        val webView: WebView = binding.webView
        webView.webViewClient = WebViewClient() //Это позволяет обрабатывать переходы по ссылкам внутри WebView.

        webView.loadUrl(str) //"https://beeline.uz/uz/events/category/news"

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

