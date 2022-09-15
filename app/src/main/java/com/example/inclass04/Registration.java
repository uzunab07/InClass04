package com.example.inclass04;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Registration extends Fragment {
    EditText editTextName,editTextEmail,editTextId;
    String name,email,id,department,te="ttt";
    TextView textViewDepartment;

    public Registration() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        editTextName = view.findViewById(R.id.editTextTextPersonName);
        editTextEmail = view.findViewById(R.id.editTextTextEmailAddress);
        editTextId = view.findViewById(R.id.editTextId);
        textViewDepartment = view.findViewById(R.id.textViewDepartment);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Registration");

        view.findViewById(R.id.buttonSelect_registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    getActivity().getSupportFragmentManager()
                            .beginTransaction().replace(R.id.containerView,new Department())
                            .addToBackStack(null)
                            .commit();
            }
        });

        view.findViewById(R.id.buttonSubmit_registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editTextName.getText().toString();
                email = editTextEmail.getText().toString();
                id = editTextId.getText().toString();

                if(name.isEmpty() || email.isEmpty() || id.isEmpty() || department==null || department.isEmpty()){
                    Toast.makeText(getActivity(), "Please Insert The required Values", Toast.LENGTH_SHORT).show();
                }else{

                    User user  = new User(name,email,id,department);

                    getActivity().getSupportFragmentManager()
                            .beginTransaction().replace(R.id.containerView,Profile.newInstance(user))
                            .addToBackStack(null)
                            .commit();

                }
            }
        });


        return view;
    }
//    Retrieving the department from the MainActivity
    public void setDepartment(String department){
        this.department = department;
    }
//Setting the TextViewDept to the value retrieved from the MainActivity
    @Override
    public void onResume() {
        super.onResume();
        textViewDepartment.setText(this.department);

    }
}