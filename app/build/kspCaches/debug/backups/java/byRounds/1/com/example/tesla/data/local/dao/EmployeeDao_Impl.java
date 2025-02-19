package com.example.tesla.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.tesla.data.models.Employees;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class EmployeeDao_Impl implements EmployeeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Employees> __insertionAdapterOfEmployees;

  private final EntityDeletionOrUpdateAdapter<Employees> __updateAdapterOfEmployees;

  private final SharedSQLiteStatement __preparedStmtOfDeleteEmployeeById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllEmployees;

  public EmployeeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEmployees = new EntityInsertionAdapter<Employees>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `employees` (`Id`,`name`,`email`,`phone`,`address`,`salary`,`designation`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Employees entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAddress());
        }
        if (entity.getSalary() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSalary());
        }
        if (entity.getDesignation() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDesignation());
        }
      }
    };
    this.__updateAdapterOfEmployees = new EntityDeletionOrUpdateAdapter<Employees>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `employees` SET `Id` = ?,`name` = ?,`email` = ?,`phone` = ?,`address` = ?,`salary` = ?,`designation` = ? WHERE `Id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Employees entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAddress());
        }
        if (entity.getSalary() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSalary());
        }
        if (entity.getDesignation() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDesignation());
        }
        statement.bindLong(8, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteEmployeeById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM employees WHERE Id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllEmployees = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM employees";
        return _query;
      }
    };
  }

  @Override
  public Object insertEmployee(final Employees employees,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEmployees.insert(employees);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateEmployee(final Employees employees,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfEmployees.handle(employees);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteEmployeeById(final int employeeId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteEmployeeById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, employeeId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteEmployeeById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllEmployees(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllEmployees.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllEmployees.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getEmployeeById(final int employeeId,
      final Continuation<? super Employees> $completion) {
    final String _sql = "SELECT * FROM employees WHERE ID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, employeeId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Employees>() {
      @Override
      @Nullable
      public Employees call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
          final int _cursorIndexOfDesignation = CursorUtil.getColumnIndexOrThrow(_cursor, "designation");
          final Employees _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpSalary;
            if (_cursor.isNull(_cursorIndexOfSalary)) {
              _tmpSalary = null;
            } else {
              _tmpSalary = _cursor.getString(_cursorIndexOfSalary);
            }
            final String _tmpDesignation;
            if (_cursor.isNull(_cursorIndexOfDesignation)) {
              _tmpDesignation = null;
            } else {
              _tmpDesignation = _cursor.getString(_cursorIndexOfDesignation);
            }
            _result = new Employees(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpAddress,_tmpSalary,_tmpDesignation);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllEmployees(final Continuation<? super List<Employees>> $completion) {
    final String _sql = "SELECT * FROM employees ORDER BY Id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Employees>>() {
      @Override
      @NonNull
      public List<Employees> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
          final int _cursorIndexOfDesignation = CursorUtil.getColumnIndexOrThrow(_cursor, "designation");
          final List<Employees> _result = new ArrayList<Employees>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Employees _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpSalary;
            if (_cursor.isNull(_cursorIndexOfSalary)) {
              _tmpSalary = null;
            } else {
              _tmpSalary = _cursor.getString(_cursorIndexOfSalary);
            }
            final String _tmpDesignation;
            if (_cursor.isNull(_cursorIndexOfDesignation)) {
              _tmpDesignation = null;
            } else {
              _tmpDesignation = _cursor.getString(_cursorIndexOfDesignation);
            }
            _item = new Employees(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpAddress,_tmpSalary,_tmpDesignation);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
