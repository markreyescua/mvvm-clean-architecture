package com.mcua.architecture.ui.account.features.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.mcua.architecture.R
import com.mcua.architecture.base.BaseFragment
import com.mcua.architecture.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.timeout.observe(viewLifecycleOwner, { timeout ->
            if (timeout) {
                goToLogin()
            }
        })
        viewModel.startSplashScreenTimeout()
    }

    private fun goToLogin() {
        val extras = FragmentNavigatorExtras(
            binding.imageViewLogo to "imageView"
        )
        findNavController().navigate(R.id.actionGoToLogin, null, null, extras)
    }

}