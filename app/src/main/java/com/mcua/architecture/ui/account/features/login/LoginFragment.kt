package com.mcua.architecture.ui.account.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.transition.TransitionInflater
import com.mcua.architecture.base.BaseFragment
import com.mcua.architecture.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonRegister.setOnClickListener {
                goToRegisterAccount()
            }

            buttonSignIn.setOnClickListener {

            }
        }
    }

    private fun goToRegisterAccount() {
        val action = LoginFragmentDirections.actionGoToReset()
        Navigation.findNavController(binding.root).navigate(action)
    }

}