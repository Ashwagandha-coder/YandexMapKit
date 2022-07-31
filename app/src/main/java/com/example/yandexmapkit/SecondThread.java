package com.example.yandexmapkit;

import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;

import java.util.List;

public class SecondThread extends Thread {


    @Override
    public void run() {
        super.run();


        try {

            Thread.sleep(2000);

        }
        catch (Exception e) {

            e.printStackTrace();
        }
        finally {

            PermissionListener permissionlistener = new PermissionListener() {
                @Override
                public void onPermissionGranted() {
                    Toast.makeText(new WelcomeActivity(), "Permission Granted", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPermissionDenied(List<String> deniedPermissions) {
                    Toast.makeText(new WelcomeActivity(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                }


            };


        }


    }
}
