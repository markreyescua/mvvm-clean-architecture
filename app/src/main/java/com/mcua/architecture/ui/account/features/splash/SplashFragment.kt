package com.mcua.architecture.ui.account.features.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.mcua.architecture.R
import com.mcua.architecture.core.base.BaseFragment
import com.mcua.architecture.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SplashViewModel by viewModels()

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