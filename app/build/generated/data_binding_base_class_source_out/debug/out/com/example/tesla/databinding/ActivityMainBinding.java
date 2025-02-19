// Generated by view binder compiler. Do not edit!
package com.example.tesla.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.example.tesla.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final FragmentContainerView rootView;

  @NonNull
  public final FragmentContainerView navHostFragment;

  private ActivityMainBinding(@NonNull FragmentContainerView rootView,
      @NonNull FragmentContainerView navHostFragment) {
    this.rootView = rootView;
    this.navHostFragment = navHostFragment;
  }

  @Override
  @NonNull
  public FragmentContainerView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    FragmentContainerView navHostFragment = (FragmentContainerView) rootView;

    return new ActivityMainBinding((FragmentContainerView) rootView, navHostFragment);
  }
}
