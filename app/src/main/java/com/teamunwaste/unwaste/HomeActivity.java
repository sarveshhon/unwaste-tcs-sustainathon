package com.teamunwaste.unwaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.teamunwaste.unwaste.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tlHomeAct.addTab(binding.tlHomeAct.newTab().setText("Home"));
        binding.tlHomeAct.addTab(binding.tlHomeAct.newTab().setText("Exchange"));
        binding.tlHomeAct.addTab(binding.tlHomeAct.newTab().setText("Explore"));

        binding.vpHomeAct.setAdapter(new HomeVPAdapter(getSupportFragmentManager(), getLifecycle()));
        binding.vpHomeAct.setUserInputEnabled(false);


        // Tab onClick
        binding.tlHomeAct.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.vpHomeAct.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // ViewPager On Callback
        binding.vpHomeAct.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                binding.tlHomeAct.selectTab(binding.tlHomeAct.getTabAt(position));
            }
        });


    }
}