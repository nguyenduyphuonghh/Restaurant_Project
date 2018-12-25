package com.example.nguye.restaurant_project.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.nguye.restaurant_project.R;
import com.example.nguye.restaurant_project.fragment.DoanhThuTheoNhanVienFragment;
import com.example.nguye.restaurant_project.fragment.HoatDongTrongNgayFragment;

public class ThongKeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke2);
        addControls();



    }

    @SuppressLint("RestrictedApi")
    private void addControls() {
        drawLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView= (NavigationView) findViewById(R.id.navigation_tk);
        toolbar= (Toolbar) findViewById(R.id.toolbar_tk);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager=getSupportFragmentManager();

        FragmentTransaction transactionHDtrongngay=fragmentManager.beginTransaction();
        HoatDongTrongNgayFragment hoatDongTrongNgayFragment=new HoatDongTrongNgayFragment();
        transactionHDtrongngay.replace(R.id.contentTK,hoatDongTrongNgayFragment);
        transactionHDtrongngay.commit();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////        MenuItem menuItem=menu.add(1,R.menu.menu_thongke,1,"Thống kê");
////        menuItem.setIcon(R.drawable.thongke);
////        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
//        getMenuInflater().inflate(R.menu.menu_thongke, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return true;
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.HDtrongngay:
                FragmentTransaction transactionHDtrongngay=fragmentManager.beginTransaction();
                HoatDongTrongNgayFragment hoatDongTrongNgayFragment=new HoatDongTrongNgayFragment();
                transactionHDtrongngay.replace(R.id.contentTK,hoatDongTrongNgayFragment);
                transactionHDtrongngay.commit();
                break;
            case R.id.doanhthuNV:
                FragmentTransaction transactionDoanhThuNV=fragmentManager.beginTransaction();
                DoanhThuTheoNhanVienFragment doanhThuTheoNhanVienFragment=new DoanhThuTheoNhanVienFragment();
                transactionDoanhThuNV.replace(R.id.contentTK,doanhThuTheoNhanVienFragment);
                transactionDoanhThuNV.commit();
                break;
            case R.id.SLkhach:
//                Intent intent = new Intent(ThongKeActivity.this, DangKyActivity.class);
//                startActivity(intent);
                break;
        }
        return false;
}
}
