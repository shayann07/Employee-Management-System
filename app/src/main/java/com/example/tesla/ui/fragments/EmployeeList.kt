package com.example.tesla.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tesla.R
import com.example.tesla.adapter.EmployeeAdapter
import com.example.tesla.data.models.Employees
import com.example.tesla.databinding.FragmentEmployeeListBinding
import com.example.tesla.databinding.FragmentNewEmployeeBinding
import com.example.tesla.ui.viewmodel.EmployeeViewmodel

class EmployeeList : Fragment(), EmployeeAdapter.OnItemClickListener {

    private var _binding: FragmentEmployeeListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: EmployeeViewmodel
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createEmployeeFab.setOnClickListener {
            findNavController().navigate(R.id.employeeListFragment_to_newEmployeeFragment)
        }

        initViewModel()

        setupUI()

        observeEmployees()


    }

    override fun onPause() {
        super.onPause()
        viewModel.fetchAllEmployees()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchAllEmployees()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity())[EmployeeViewmodel::class.java]
        viewModel.fetchAllEmployees()
    }

    private fun setupUI() {
        binding.employeeRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            employeeAdapter = createTaskAdapter()
            adapter = employeeAdapter
        }
    }

    private fun observeEmployees() {
        viewModel.allEmployees.observe(viewLifecycleOwner) { allEmployees ->
            employeeAdapter.submitList(allEmployees)
            binding.employeeRecyclerView.visibility =
                if (allEmployees.isNullOrEmpty()) View.GONE else View.VISIBLE
            binding.noEmployeesTV.visibility =
                if (allEmployees.isNullOrEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onItemClick(employees: Employees) {
        val bundle = Bundle().apply { putParcelable("employees", employees) }
        findNavController().navigate(R.id.employeeDetailsFragment, bundle)
    }

    private fun createTaskAdapter(): EmployeeAdapter {
        return EmployeeAdapter(itemClickListener = this,
            deleteClickListener = object : EmployeeAdapter.OnDeleteClickListener {
                override fun onDeleteClick(employees: Employees) {
                    // Build and show the confirmation dialog
                    androidx.appcompat.app.AlertDialog.Builder(
                        requireContext(), R.style.RoundedAlertDialog
                    ).setTitle("Delete Employee")
                        .setMessage("Are you sure you want to delete this employee?")
                        .setPositiveButton("Yes") { dialog, _ ->
                            viewModel.deleteEmployee(employees)
                            context?.shortToast("Employee deleted")
                            dialog.dismiss()
                        }.setNegativeButton("No") { dialog, _ ->
                            dialog.dismiss()
                        }.show()
                }
            })
    }
}

fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
