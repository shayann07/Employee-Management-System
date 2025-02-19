package com.example.tesla.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "employees")
data class Employees(
    @PrimaryKey(autoGenerate = true) val Id: Int = 0,
    val name: String = "",
    val email: String? = null,
    val phone: String? = null,
    val address: String? = null,
    val salary: String? = null,
    val designation: String? = null
) : Parcelable
