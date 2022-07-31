package com.example.yandexmapkit;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.Intent;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

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


                    Intent intent = new Intent(new WelcomeActivity(),MainActivity.class);

                    ContextWrapper contextWrapper = new WelcomeActivity();

                    contextWrapper.startActivity(intent);

                }

                @Override
                public void onPermissionDenied(List<String> deniedPermissions) {
                    Toast.makeText(new WelcomeActivity(), "Доступ запрещен" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                }


            };

            TedPermission.create()
                    .setPermissionListener(permissionlistener)
                    .setDeniedMessage(R.string.deniedMessage_permissions)
                    .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                    .check();


        }


    }
}
