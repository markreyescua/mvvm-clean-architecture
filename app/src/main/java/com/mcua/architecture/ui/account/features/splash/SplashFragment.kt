package com.mcua.architecture.ui.account.features.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.mcua.architecture.base.BaseFragment
import com.mcua.architecture.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.startSplashScreenTimeout()
        viewModel.timeout.observe(viewLifecycleOwner, Observer { timeout ->
            if (timeout) {
                goToLogin()
            }
        })
    }

    private fun goToLogin() {
        val action = SplashFragmentDirections.actionGoToLogin()
        Navigation.findNavController(binding.root).navigate(action)
    }

}