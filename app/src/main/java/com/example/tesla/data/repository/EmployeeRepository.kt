package com.example.tesla.data.repository

import android.content.Context
import com.example.tesla.data.local.AppDatabase
import com.example.tesla.data.local.dao.EmployeeDao
import com.example.tesla.data.models.Employees
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmployeeRepository(context: Context) {

    private val employeeDao = AppDatabase.getInstance(context).employeeDao()


    suspend fun updateEmployee(employees: Employees): Result<Boolean> = withContext(Dispatchers.IO) {
        try {
            employeeDao.updateEmployee(employees)
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    suspend fun saveEmployee(employees: Employees): Result<Boolean> = withContext(Dispatchers.IO) {
        try {
            val existingEmployee = employeeDao.getEmployeeById(employees.Id)
            if (existingEmployee == null) {
                employeeDao.insertEmployee(employees)
                Result.success(true)
            } else {
                Result.failure(Exception("Employee with ID ${employees.Id} already exists"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getAllEmployees(): List<Employees> = withContext(Dispatchers.IO) {
        employeeDao.getAllEmployees()
    }

    suspend fun deleteEmployee(employeeId: Int) = withContext(Dispatchers.IO) {
        employeeDao.deleteEmployeeById(employeeId)
    }
}