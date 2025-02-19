package com.example.tesla.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.tesla.R
import com.example.tesla.data.models.Employees
import com.example.tesla.databinding.FragmentNewEmployeeBinding
import com.example.tesla.ui.viewmodel.EmployeeViewmodel
import com.google.android.material.snackbar.Snackbar

class NewEmployee : Fragment() {

    private var _binding: FragmentNewEmployeeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EmployeeViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewEmployeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backToHome.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnSaveEmployee.setOnClickListener {
            handleAddTask()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun View.showSnackbar(message: String) {
        Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
    }


    private fun handleAddTask() {
        val eName = binding.etName.text.toString().trim()
        val eEmail = binding.etEmail.text.toString().trim()
        val ePhone = binding.etPhone.text.toString().trim()
        val eAddress = binding.etAddress.text.toString().trim()
        val eSalary = binding.etSalary.text.toString().trim()
        val eDesignation = binding.etDesignation.text.toString().trim()

        if (eName.isEmpty() || eEmail.isEmpty() || ePhone.isEmpty() || eAddress.isEmpty() || eSalary.isEmpty() || eDesignation.isEmpty()) {
            binding.root.showSnackbar("All fields are required.")
            return
        }

        viewModel.saveEmployee(
            Employees(
                name = eName,
                email = eEmail,
                phone = ePhone,
                address = eAddress,
                salary = eSalary,
                designation = eDesignation
            )
        )

        binding.root.showSnackbar("Employee added successfully.")
        findNavController().navigateUp()
    }
}