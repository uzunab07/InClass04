package com.example.inclass04;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {
    TextView textViewName,textViewEmail,textViewId,textViewDept;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PROFILE_KEY = "PROFILE";

    // TODO: Rename and change types of parameters
    private User user;


    public Profile() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(User user) {
        Profile fragment = new Profile();
        Bundle args = new Bundle();
        args.putSerializable(PROFILE_KEY, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user =(User) getArguments().getSerializable(PROFILE_KEY);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        textViewName =  view.findViewById(R.id.textViewName);
        textViewEmail =  view.findViewById(R.id.textViewEmail);
        textViewId =  view.findViewById(R.id.textViewId);
        textViewDept =  view.findViewById(R.id.textViewDepte);

        textViewName.setText(user.getName());
        textViewDept.setText(user.getDepartment());
        textViewId.setText(user.getId());
        textViewEmail.setText(user.getEmail());


        return view;
    }
}