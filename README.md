# Employee Management System

Offline Kotlin Android app for creating, viewing, updating, and deleting employee records stored in a local Room database.

## Overview

This project is a compact employee CRUD application built with XML layouts, View Binding, Jetpack Navigation, ViewModel, LiveData, coroutines, and Room. The employee list is the start screen, with routes to add a record or edit an existing employee's details.

Each record contains a generated local ID plus name, email, phone, address, salary, and designation. The application has no server, account system, department model, or cloud synchronization.

## Features

- Create employee records with six required fields
- Display all employees in a RecyclerView
- Empty-state message when no records exist
- Open an employee detail/edit screen
- Update employee fields in Room
- Delete employees after a confirmation dialog
- Automatic Room primary-key generation
- List updates after create, edit, or delete operations
- Parcelable employee records passed between fragments

## Tech Stack

- Kotlin
- Android SDK and XML layouts
- View Binding
- Jetpack Navigation
- Android ViewModel and LiveData
- Kotlin coroutines
- Room with KSP code generation
- RecyclerView and `ListAdapter`
- Material Components

## Architecture

The app follows a small MVVM-style structure:

1. `EmployeeList` renders Room records and handles add, open, and delete actions.
2. `NewEmployee` validates required fields and requests an insert.
3. `EmployeeDetails` displays editable fields and requests an update.
4. `EmployeeViewmodel` performs coroutine-based repository calls and publishes list/update state.
5. `EmployeeRepository` moves Room operations to `Dispatchers.IO`.
6. `EmployeeDao` defines insert, update, delete, and query operations.

## Project Structure

```text
app/src/main/java/com/example/tesla/
|-- adapter/          # RecyclerView ListAdapter and diffing
|-- data/
|   |-- local/        # Room database and DAO
|   |-- models/       # Employee entity
|   `-- repository/   # Coroutine-based Room access
|-- ui/
|   |-- fragments/    # List, create, and detail/edit screens
|   |-- viewmodel/    # Employee state and actions
|   `-- MainActivity.kt
`-- utils/            # One-time event wrapper
```

## Getting Started

### Prerequisites

- Android Studio with a JDK compatible with Android Gradle Plugin 8.8.1
- Android SDK 35
- An Android 7.0 (API 24) or newer device or emulator

### Build

```bash
git clone https://github.com/shayann07/Employee-Management-System.git
cd Employee-Management-System
./gradlew assembleDebug
```

On Windows PowerShell, use `./gradlew.bat assembleDebug`. No backend or API setup is required.

## Current Status and Limitations

- Data is local to one device and is not backed up to an application server.
- There is no employee search, filtering, department field, role assignment, authentication, or import/export.
- Email, phone, and salary fields are checked only for emptiness, not format or numeric validity.
- The create screen immediately reports success and navigates back without observing whether the repository insert succeeded.
- Database version changes use destructive migration fallback and can erase stored employees.
- The Android app label is `Tesla`, which does not match the repository purpose.
- Machine-specific `local.properties` and extensive Gradle cache files are tracked.
- Only generated example unit and instrumentation tests are present.
- No license file is included.
