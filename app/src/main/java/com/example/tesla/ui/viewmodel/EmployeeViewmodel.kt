package com.example.tesla.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tesla.data.models.Employees
import com.example.tesla.data.repository.EmployeeRepository
import com.example.tesla.util.Event
import kotlinx.coroutines.launch

class EmployeeViewmodel(application: Application) : AndroidViewModel(application) {

    private val repository = EmployeeRepository(application)

    val taskCreationStatus = MutableLiveData<Boolean>()
    val allEmployees = MutableLiveData<List<Employees>>()

    // Use Event wrapper to post one-time update events
    val updateStatus = MutableLiveData<Event<Boolean>>()

    fun fetchAllEmployees() {
        fetchEmployeeData(
            fetcher = { repository.getAllEmployees() }, liveData = allEmployees, label = "all"
        )
    }

    fun saveEmployee(employee: Employees) {
        viewModelScope.launch {
            try {
                repository.saveEmployee(employee)
                taskCreationStatus.postValue(true)
            } catch (e: Exception) {
                taskCreationStatus.postValue(false)
                logError("Failed to save employee", e)
            }
        }
    }

    fun updateEmployee(employee: Employees) {
        viewModelScope.launch {
            try {
                val result = repository.updateEmployee(employee)
                if (result.isSuccess) {
                    updateStatus.postValue(Event(true))
                    fetchAllEmployees() // Refresh the list if needed
                } else {
                    updateStatus.postValue(Event(false))
                }
            } catch (e: Exception) {
                updateStatus.postValue(Event(false))
                logError("Failed to update employee", e)
            }
        }
    }

    fun deleteEmployee(employee: Employees) {
        viewModelScope.launch {
            try {
                repository.deleteEmployee(employee.Id)
                fetchAllEmployees()
            } catch (e: Exception) {
                logError("Failed to delete employee", e)
            }
        }
    }

    private fun logError(message: String, e: Exception) {
        Log.e("EmployeeViewModel", "$message: ${e.message}")
    }

    private suspend fun <T> handleRepositoryCall(
        call: suspend () -> T, onSuccess: (T) -> Unit
    ) {
        try {
            val result = call()
            onSuccess(result)
        } catch (e: Exception) {
            logError("Error during repository call", e)
        }
    }

    private fun <T> fetchEmployeeData(
        fetcher: suspend () -> T, liveData: MutableLiveData<T>, label: String
    ) {
        viewModelScope.launch {
            handleRepositoryCall(fetcher) {
                liveData.postValue(it)
            }
        }
    }
}