package com.example.sbs.insta;

import android.os.Bundle;

import android.view.Menu;

import com.example.sbs.insta.R;
import com.example.sbs.insta.databinding.ActivityMainBinding;
import com.example.sbs.insta.databinding.AppBarMainBinding;

import com.example.sbs.insta.databinding.NavHeaderMainBinding;
import com.example.sbs.insta.ui.MainViewModel;
import com.google.android.material.snackbar.Snackbar;


import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import androidx.appcompat.app.AppCompatActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);



        MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setMainVm(vm);
        setContentView(binding.getRoot());



        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.nav_header_main, binding.navView, false);
        navHeaderMainBinding.setLifecycleOwner(this);
        navHeaderMainBinding.setMainVm(vm);
        binding.navView.addHeaderView(navHeaderMainBinding.getRoot());

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(binding.drawerLayout)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}