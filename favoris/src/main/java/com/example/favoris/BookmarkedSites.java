package com.example.favoris;


import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class BookmarkedSites {
    String txt;
    ArrayList<String> links;

    public ArrayList<String> getdata(Context context) {

        try {
            InputStream inputStream = context.getAssets().open("url.txt");
            int result = inputStream.available();
            byte[] bytes = new byte[result];
            inputStream.read(bytes);
            inputStream.close();
            txt = new String(bytes);
            links = new ArrayList<>(Arrays.asList(txt.split("\\n")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }

}
