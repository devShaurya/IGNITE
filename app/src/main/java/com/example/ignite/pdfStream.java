package com.example.ignite;

import android.os.AsyncTask;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class pdfStream extends AsyncTask<String,Void, InputStream>{
    PDFView pdfView;
    public pdfStream(PDFView pdfView){
        this.pdfView=pdfView;
    }
    @Override
    protected void onPostExecute(InputStream inputStream) {
        pdfView.fromStream(inputStream).load();
    }

    @Override
    protected InputStream doInBackground(String... strings) {
        InputStream inputStream=null;
        try {
            URL url=new URL(strings[0]);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            if(httpURLConnection.getResponseCode()==200){
                inputStream=new BufferedInputStream(httpURLConnection.getInputStream());
            }
        } catch (IOException e) {
            Log.d("msg",e.toString());
            return null;
        }
        return inputStream;
    }
}