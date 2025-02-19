// Generated by view binder compiler. Do not edit!
package com.example.tesla.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tesla.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentNewEmployeeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView allText;

  @NonNull
  public final ImageButton backToHome;

  @NonNull
  public final Button btnSaveEmployee;

  @NonNull
  public final EditText etAddress;

  @NonNull
  public final EditText etDesignation;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etName;

  @NonNull
  public final EditText etPhone;

  @NonNull
  public final EditText etSalary;

  private FragmentNewEmployeeBinding(@NonNull LinearLayout rootView, @NonNull TextView allText,
      @NonNull ImageButton backToHome, @NonNull Button btnSaveEmployee, @NonNull EditText etAddress,
      @NonNull EditText etDesignation, @NonNull EditText etEmail, @NonNull EditText etName,
      @NonNull EditText etPhone, @NonNull EditText etSalary) {
    this.rootView = rootView;
    this.allText = allText;
    this.backToHome = backToHome;
    this.btnSaveEmployee = btnSaveEmployee;
    this.etAddress = etAddress;
    this.etDesignation = etDesignation;
    this.etEmail = etEmail;
    this.etName = etName;
    this.etPhone = etPhone;
    this.etSalary = etSalary;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentNewEmployeeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentNewEmployeeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_new_employee, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentNewEmployeeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.all_text;
      TextView allText = ViewBindings.findChildViewById(rootView, id);
      if (allText == null) {
        break missingId;
      }

      id = R.id.backToHome;
      ImageButton backToHome = ViewBindings.findChildViewById(rootView, id);
      if (backToHome == null) {
        break missingId;
      }

      id = R.id.btnSaveEmployee;
      Button btnSaveEmployee = ViewBindings.findChildViewById(rootView, id);
      if (btnSaveEmployee == null) {
        break missingId;
      }

      id = R.id.etAddress;
      EditText etAddress = ViewBindings.findChildViewById(rootView, id);
      if (etAddress == null) {
        break missingId;
      }

      id = R.id.etDesignation;
      EditText etDesignation = ViewBindings.findChildViewById(rootView, id);
      if (etDesignation == null) {
        break missingId;
      }

      id = R.id.etEmail;
      EditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.etName;
      EditText etName = ViewBindings.findChildViewById(rootView, id);
      if (etName == null) {
        break missingId;
      }

      id = R.id.etPhone;
      EditText etPhone = ViewBindings.findChildViewById(rootView, id);
      if (etPhone == null) {
        break missingId;
      }

      id = R.id.etSalary;
      EditText etSalary = ViewBindings.findChildViewById(rootView, id);
      if (etSalary == null) {
        break missingId;
      }

      return new FragmentNewEmployeeBinding((LinearLayout) rootView, allText, backToHome,
          btnSaveEmployee, etAddress, etDesignation, etEmail, etName, etPhone, etSalary);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
