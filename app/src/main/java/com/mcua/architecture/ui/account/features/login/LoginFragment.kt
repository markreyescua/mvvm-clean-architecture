package com.mcua.architecture.ui.account.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.transition.TransitionInflater
import com.mcua.architecture.core.base.BaseFragment
import com.mcua.architecture.core.data.model.server.Resource
import com.mcua.architecture.core.util.SafeLog
import com.mcua.architecture.core.util.ext.showToast
import com.mcua.architecture.databinding.FragmentLoginBinding
import com.mcua.architecture.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

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
                dismissKeyboard()
                viewModel.login(
                    editTextUsername.text.toString().trim(),
                    editTextPassword.text.toString().trim()
                )
            }
        }

        viewModel.user.observe(viewLifecycleOwner, { resource ->
            when (resource) {
                is Resource.Error -> {
                    SafeLog.e(resource.error)
                }
                is Resource.Loading -> {
                    SafeLog.e("Resource loading")
                }
                is Resource.Success -> {
                    activity?.let { context ->
                        showToast("Successfully signed in")
                        startActivity(MainActivity.getIntent(context))
                    }
                }
                is Resource.NetworkError -> {
                    showToast("Network error")
                }
            }
        })
    }

    private fun goToRegisterAccount() {
        val action = LoginFragmentDirections.actionGoToReset()
        Navigation.findNavController(binding.root).navigate(action)
    }

}