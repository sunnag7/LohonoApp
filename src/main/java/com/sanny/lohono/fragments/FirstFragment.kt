package com.sanny.lohono.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sanny.lohono.R
import com.sanny.lohono.databinding.FragmentFirstBinding
import android.content.Intent
import com.sanny.lohono.activities.Search_activity
import com.sanny.lohono.utils.LocaleUtils
import com.sanny.lohono.utils.LocaleUtils.LocaleDef.SUPPORTED_LOCALES


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var mLanguageIndex = 0
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.button.setOnClickListener{
            val intent = Intent(activity, Search_activity::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener{
            if (++mLanguageIndex >= LocaleUtils.LocaleDef.SUPPORTED_LOCALES.size) {
                mLanguageIndex = 0
            }

            LocaleUtils.setLocale(activity, mLanguageIndex);
           // LocaleUtils.initialize(activity, LocaleUtils.LocaleDef.SUPPORTED_LOCALES.get(mLanguageIndex));

            //val intent = activity?.intent
            //activity?.finish()
            //startActivity(intent)
              setupUi();
        }
    }

    private fun setupUi() {
        binding.button2.setText(R.string.switched_language)
        binding.buttonFirst.setText(R.string.next)
        binding.button.setText(R.string.search_city)
        binding.textviewFirst.setText(R.string.hello_first_fragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}