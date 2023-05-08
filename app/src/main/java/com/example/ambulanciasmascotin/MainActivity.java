package com.example.ambulanciasmascotin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.ambulanciasmascotin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.irRegistro.setBackgroundColor(Color.YELLOW);
        binding.irRegistro.setTextColor(Color.BLACK);
        binding.irEmergencia.setBackgroundColor(Color.RED);
        binding.irHistorial.setBackgroundColor(Color.GREEN);




        binding.irRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.irRegistro.setVisibility(View.GONE);
                binding.irEmergencia.setVisibility(View.GONE);
                binding.irHistorial.setVisibility(View.GONE);



                replaceFragment(new FragmentoRegistro());




            }
        });
        binding.irEmergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.irRegistro.setVisibility(View.GONE);
                binding.irEmergencia.setVisibility(View.GONE);
                binding.irHistorial.setVisibility(View.GONE);
                replaceFragment(new FragmentoEmergencia());
            }
        });

        binding.irHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.irRegistro.setVisibility(View.GONE);
                binding.irEmergencia.setVisibility(View.GONE);
                binding.irHistorial.setVisibility(View.GONE);
                replaceFragment(new FragmentoHistorial());
            }
        });



    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}