package com.mcua.architecture.ui.account.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
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
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            activity?.moveTaskToBack(true)
        }
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
        viewModel.clearUser()
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
                is Resource.Loading -> {
                    SafeLog.e("Resource loading")
                }
                is Resource.Success -> {
                    showToast("Successfully signed in")
                    activity?.let { context ->
                        startActivity(MainActivity.getIntent(context))
                    }
                }
                is Resource.Error -> {
                    showToast(resource.error!!)
                }
                is Resource.NetworkError -> {
                    showToast(resource.error!!)
                }
                is Resource.Empty -> {
                    binding.apply {
                        editTextUsername.setText("")
                        editTextPassword.setText("")
                    }
                }
            }
        })
    }

    private fun goToRegisterAccount() {
        val action = LoginFragmentDirections.actionGoToReset()
        Navigation.findNavController(binding.root).navigate(action)
    }

}