package uz.farxod.mobileoperators

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.farxod.mobileoperators.databinding.FragmentMainBeelineBinding

class BeelineMainFragment : Fragment() {


    private var _binding: FragmentMainBeelineBinding? = null
    private val binding get() = _binding!!
    private var increment = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBeelineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val fragment = OperatorsFragment()  // Фрагментдан объект оламиз
        val bundle = Bundle()               // Создание нового объекта Bundle

        binding.tarif.setOnClickListener {
    //regionBundle

            bundle.putString("key", "tarif")  // Добавление данных в Bundle

            fragment.arguments = bundle       // Обьектга аргумент сифатида bundle ни узлаштирамиз

    //endregion
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_blank, fragment)
                .addToBackStack(BeelineMainFragment().toString())
                .commit()
        }
        binding.xizmatlar.setOnClickListener {

            bundle.putString("key", "xizmatlar")  // Добавление данных в Bundle

            fragment.arguments = bundle         // В активности отправляющей данные

            //endregion
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_blank, fragment)
                .addToBackStack(BeelineMainFragment().toString())
                .commit()
        }
        binding.internetPaket.setOnClickListener {

            bundle.putString("key", "internet")  // Добавление данных в Bundle

            fragment.arguments = bundle         // В активности отправляющей данные

            //endregion
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_blank, fragment)
                .addToBackStack(BeelineMainFragment().toString())
                .commit()
        }

        binding.btnNextLogo.setOnClickListener {
            if (increment<4){
                increment++
            }else {
                increment = 0
            }
        }
    }
    private fun nextFon(){
        when(increment){
            0 -> {
                binding.imgLogo.setImageResource(R.drawable.ucell)

            }
            1 -> {

            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}