package com.example.m4l1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.m4l1.R
import com.example.m4l1.data.models.User
import com.example.m4l1.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
    }

    private fun setUpListener() {
        binding.btnSend.setOnClickListener {
            val user = User(binding.inputLayoutUsername.editText?.text.toString(),
                binding.inputLayoutEmail.editText?.text.toString(),
                binding.inputLayoutPassword.editText?.text.toString().toInt())

            findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment(user
            ))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}