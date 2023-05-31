package com.app.modelo;

import android.content.Context;

import java.io.File;

public class limpiar {
    public limpiar() {
    }

    public void clearCache(Context context) {
        try {
            File cacheDir = new File(context.getCacheDir(), "http-cache");
            if (cacheDir.exists() && cacheDir.isDirectory()) {
                deleteDir(cacheDir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (String child : children) {
                boolean success = deleteDir(new File(dir, child));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

}
