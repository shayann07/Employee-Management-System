package com.example.tesla.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tesla.R
import com.example.tesla.data.models.Employees
import com.example.tesla.databinding.RecyclerItemsBinding

class EmployeeAdapter(
    private val itemClickListener: OnItemClickListener,
    private val deleteClickListener: OnDeleteClickListener
) : ListAdapter<Employees, EmployeeAdapter.EmployeeViewHolder>(EmployeeDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding =
            RecyclerItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employees = getItem(position)
        val isLastItem = (position == itemCount - 1)
        holder.bind(employees, itemClickListener, deleteClickListener, isLastItem)

        // Debug log for item binding
        Log.d("EmployeeAdapter", "Task bound: ${employees.name}")
    }

    class EmployeeViewHolder(private val binding: RecyclerItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            employees: Employees,
            itemClickListener: OnItemClickListener,
            deleteClickListener: OnDeleteClickListener,
            isLastItem: Boolean
        ) {
            binding.apply {
                // Name
                fetchedEmployeeName.text = employees.name

                // Time display & color
                if (!employees.designation.isNullOrBlank()) {
                    fetchedEmployeeDesignation.text = employees.designation
                    fetchedEmployeeDesignation.setTextColor(
                        ContextCompat.getColor(root.context, R.color.light_blue)
                    )
                } else {
                    fetchedEmployeeDesignation.text = root.context.getString(R.string.not_available)
                    fetchedEmployeeDesignation.setTextColor(
                        ContextCompat.getColor(root.context, R.color.orange)
                    )
                }

                // Divider visibility
                recyclerViewDivider.visibility = if (isLastItem) View.GONE else View.VISIBLE

                // Click listeners
                deleteEmployee.setOnClickListener {
                    deleteClickListener.onDeleteClick(employees)
                }
                root.setOnClickListener {
                    itemClickListener.onItemClick(employees)
                }
            }
        }
    }

    class EmployeeDiffCallback : DiffUtil.ItemCallback<Employees>() {
        override fun areItemsTheSame(oldItem: Employees, newItem: Employees): Boolean =
            oldItem.Id == newItem.Id

        override fun areContentsTheSame(oldItem: Employees, newItem: Employees): Boolean =
            oldItem == newItem
    }

    interface OnItemClickListener {
        fun onItemClick(task: Employees)
    }

    interface OnDeleteClickListener {
        fun onDeleteClick(task: Employees)
    }
}