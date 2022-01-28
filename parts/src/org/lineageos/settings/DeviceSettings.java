package org.lineageos.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;

import org.lineageos.settings.R;
import androidx.preference.PreferenceFragment;

import org.lineageos.settings.doze.DozeSettingsActivity;
import org.lineageos.settings.dirac.DiracActivity;
import org.lineageos.settings.kcal.KcalSettingsActivity;

public class DeviceSettings extends PreferenceFragment {

    private static final String PREF_DOZE = "doze_settings";
    private static final String PREF_DIRAC = "dirac_settings";
    private static final String PREF_KCAL = "kcal_settings";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.parts_settings);

        Preference dozeSettings = findPreference(PREF_DOZE);
        dozeSettings.setOnPreferenceClickListener(preference -> {
            Intent intent = new Intent(getContext(), DozeSettingsActivity.class);
            startActivity(intent);
            return true;
        });

        Preference diracSettings = findPreference(PREF_DIRAC);
        diracSettings.setOnPreferenceClickListener(preference -> {
            Intent intent = new Intent(getContext(), DiracActivity.class);
            startActivity(intent);
            return true;
        });

        Preference kcalSettings = findPreference(PREF_KCAL);
        kcalSettings.setOnPreferenceClickListener(preference -> {
            Intent intent = new Intent(getActivity().getApplicationContext(), KcalSettingsActivity.class);
            startActivity(intent);
            return true;
        });
    }



}

