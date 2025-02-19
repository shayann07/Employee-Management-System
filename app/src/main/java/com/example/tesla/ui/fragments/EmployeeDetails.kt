package com.example.tesla.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tesla.R
import com.example.tesla.data.models.Employees
import com.example.tesla.databinding.FragmentEmployeeDetailsBinding
import com.example.tesla.ui.viewmodel.EmployeeViewmodel

class EmployeeDetails : Fragment() {

    private var _binding: FragmentEmployeeDetailsBinding? = null
    private val binding get() = _binding!!

    private var currentEmployee: Employees? = null
    private lateinit var viewModel: EmployeeViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[EmployeeViewmodel::class.java]

        binding.backToHome.setOnClickListener {
            findNavController().navigateUp()
        }

        // Observe updateStatus with one-time consumption
        viewModel.updateStatus.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { updated ->
                if (updated) {
                    Toast.makeText(
                        requireContext(), "Employee updated successfully", Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigateUp()
                } else {
                    Toast.makeText(requireContext(), "Update failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Retrieve the employee from arguments
        currentEmployee = arguments?.getParcelable("employees")
        if (currentEmployee != null) {
            bindEmployeeDetails(currentEmployee!!)
        } else {
            showEmployeeNotAvailableMessage()
        }

        binding.btnUpdateEmployee.setOnClickListener {
            updateEmployeeDetails()
        }
    }

    private fun bindEmployeeDetails(employee: Employees) = with(binding) {
        tvName.setText(employee.name.naIfBlank())
        tvEmail.setText(employee.email.naIfBlank())
        tvPhone.setText(employee.phone.naIfBlank())
        tvAddress.setText(employee.address.naIfBlank())
        tvSalary.setText(employee.salary.naIfBlank())
        tvDesignation.setText(employee.designation.naIfBlank())
    }

    private fun showEmployeeNotAvailableMessage() = with(binding) {
        tvName.setText(getString(R.string.not_available))
        tvEmail.setText(getString(R.string.not_available))
        tvPhone.setText(getString(R.string.not_available))
        tvAddress.setText(getString(R.string.not_available))
        tvSalary.setText(getString(R.string.not_available))
        tvDesignation.setText(getString(R.string.not_available))
    }

    private fun updateEmployeeDetails() {
        currentEmployee?.let { oldEmployee ->
            val updatedEmployee = Employees(
                Id = oldEmployee.Id,  // Preserve the original ID
                name = binding.tvName.text.toString().trim(),
                email = binding.tvEmail.text.toString().trim(),
                phone = binding.tvPhone.text.toString().trim(),
                address = binding.tvAddress.text.toString().trim(),
                salary = binding.tvSalary.text.toString().trim(),
                designation = binding.tvDesignation.text.toString().trim()
            )
            viewModel.updateEmployee(updatedEmployee)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

// Extension functions
private fun String?.naIfNull(): String = this ?: "N/A"
private fun String?.naIfBlank(): String = if (this.isNullOrBlank()) "N/A" else this