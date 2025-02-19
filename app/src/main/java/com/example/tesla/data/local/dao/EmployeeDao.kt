package com.example.tesla.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.tesla.data.models.Employees

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployee(employees: Employees)

    @Update
    suspend fun updateEmployee(employees: Employees)

    @Query("DELETE FROM employees WHERE Id = :employeeId")
    suspend fun deleteEmployeeById(employeeId: Int)

    @Query("DELETE FROM employees")
    suspend fun deleteAllEmployees()

    @Query("SELECT * FROM employees WHERE ID = :employeeId")
    suspend fun getEmployeeById(employeeId: Int): Employees?


    @Query("SELECT * FROM employees ORDER BY Id ASC")
    suspend fun getAllEmployees(): List<Employees>

}