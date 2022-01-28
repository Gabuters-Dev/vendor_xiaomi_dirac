package org.lineageos.settings;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.collapsingtoolbar.R;

public class DeviceSettingsActivity extends CollapsingToolbarBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fragment = getFragmentManager().findFragmentById(R.id.content_frame);
        DeviceSettings deviceSettingsFragment;
        if (fragment == null) {
            deviceSettingsFragment = new DeviceSettings();
            getFragmentManager().beginTransaction()
                    .add(R.id.content_frame, deviceSettingsFragment)
                    .commit();
        }
    }
}
