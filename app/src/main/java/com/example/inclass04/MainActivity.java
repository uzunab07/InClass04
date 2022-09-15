package com.example.inclass04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Department.DepChooser {

    String department;
    Registration fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("djd");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.containerView,new Main())
                .addToBackStack(null)
                .commit();




    }

    @Override
    public void setDepartment(String value) {
        this.department = value;
        Log.d("test", "The department selected is : " + this.department);
        Log.d("too", "onCreate: here is the department "+department);
        Registration registration = (Registration) getSupportFragmentManager().findFragmentByTag("fragment");
        registration.setDepartment(department);

    }

}