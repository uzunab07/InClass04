package com.example.inclass04;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Department extends Fragment {

    RadioGroup radioGroupDept;
    RadioButton checkedRadioButton;

    public Department() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_department, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Department");

        view.findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewD) {
                radioGroupDept = view.findViewById(R.id.radioGroupeDept);
                int checkedRadioButtonId = radioGroupDept.getCheckedRadioButtonId();
                checkedRadioButton = view.findViewById(checkedRadioButtonId);
                if(checkedRadioButton!=null){
                    String department = checkedRadioButton.getText().toString();

                    getActivity().getSupportFragmentManager().popBackStack();
                    depChooser.setDepartment(department);

                }else{
                    Toast.makeText(getActivity(), "Please select a department", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().popBackStack();

            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof DepChooser){
            depChooser = (DepChooser) context;
        }else{
            throw  new RuntimeException(context.toString()+" Must Implement DepChooser");
        }

    }

    DepChooser depChooser;

//Interface to send the data to the MainActivity
    public interface DepChooser{
        void setDepartment(String value);
    }
}