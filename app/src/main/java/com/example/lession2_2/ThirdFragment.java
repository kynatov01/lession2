package com.example.lession2_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ThirdFragment extends Fragment {

    private final String admin = "admin";
    private EditText email, password;
    private Button btn_input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = view.findViewById(R.id.et_email_third);
        password = view.findViewById(R.id.et_password_third);
        btn_input = view.findViewById(R.id.btn_third_fragment);

        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = email.getText().toString().trim();
                String pasword = password.getText().toString();

                if (!name.equals(admin)||!pasword.equals(admin)){
                    if (!name.equals(admin)){
                        email.setError("Не правильный email !");
                    }else if (!pasword.equals(admin)){
                        password.setError("Не правильный пароль");
                    }
                }else {
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_view,new FirstFragment())
                            .addToBackStack(ThirdFragment.class.getName())
                            .commit();
                }
            }
        });
    }
}