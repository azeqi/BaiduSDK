package com.example.okgo.baidusdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class MainActivity extends AppCompatActivity {
public LocationClient locationClient=null;
    private MyLocationListener myLocationListener=new MyLocationListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationClient=new LocationClient(this);
        locationClient.registerLocationListener(myLocationListener);
        LocationClientOption option=new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//        option.setCoorType("bd0911");
//        option.setScanSpan(1000);
        option.setIsNeedAddress(true);
//可选，是否需要地址信息，默认为不需要，即参数为false
//如果开发者需要获得当前点的地址信息，此处必须为true
        locationClient.setLocOption(option);
        locationClient.start();

    }


}

