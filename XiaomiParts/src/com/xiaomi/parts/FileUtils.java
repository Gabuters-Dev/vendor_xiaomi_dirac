/*
 * Copyright (C) 2018 The Asus-SDM660 Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.xiaomi.parts;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import android.util.Log;
import java.lang.Runtime;

public class FileUtils {

    private static final String TAG = "FileUtils";

    static boolean fileWritable(String filename) {
        return fileExists(filename) && new File(filename).canWrite();
    }

    private static boolean fileExists(String filename) {
        if (filename == null) {
            return false;
        }
        return new File(filename).exists();
    }

    static void setValue(String path, int value) {
        if (fileWritable(path)) {
            if (path == null) {
                return;
            }
            try {
                FileOutputStream fos = new FileOutputStream(new File(path));
                fos.write(Integer.toString(value).getBytes());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void setValue(String path, boolean value) {
        if (fileWritable(path)) {
            if (path == null) {
                return;
            }
            try {
                FileOutputStream fos = new FileOutputStream(new File(path));
                fos.write((value ? "1" : "0").getBytes());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void setValue(String path, double value) {
        if (fileWritable(path)) {
            if (path == null) {
                return;
            }
            try {
                FileOutputStream fos = new FileOutputStream(new File(path));
                fos.write(Long.toString(Math.round(value)).getBytes());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void setValue(String path, String value) {
        if (fileWritable(path)) {
            if (path == null) {
                return;
            }
            try {
                FileOutputStream fos = new FileOutputStream(new File(path));
                fos.write(value.getBytes());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readLine(String filename) {
        if (filename == null) {
            return null;
        }
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(filename), 1024);
            line = br.readLine();
        } catch (IOException e) {
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
        return line;
    }

    static boolean getFileValueAsBoolean(String filename, boolean defValue) {
        String fileValue = readLine(filename);
        if (fileValue != null) {
            return !fileValue.equals("0");
        }
        return defValue;
    }
}
