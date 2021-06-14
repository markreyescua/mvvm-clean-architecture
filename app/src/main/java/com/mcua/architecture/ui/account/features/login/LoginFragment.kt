package com.mcua.architecture.ui.account.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.transition.TransitionInflater
import com.mcua.architecture.core.base.BaseFragment
import com.mcua.architecture.core.data.model.server.Resource
import com.mcua.architecture.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        viewModel =
            ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel::class.java)
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
                    Timber.e(resource.error)
                }
                is Resource.Loading -> {
                    Timber.e("Resource loading")
                }
                is Resource.Success -> {
                    Timber.e(resource.data.toJsonString())
                }
                is Resource.NetworkError -> {
                    Timber.e("Network error")
                }
            }
        })
    }

    private fun goToRegisterAccount() {
        val action = LoginFragmentDirections.actionGoToReset()
        Navigation.findNavController(binding.root).navigate(action)
    }

}