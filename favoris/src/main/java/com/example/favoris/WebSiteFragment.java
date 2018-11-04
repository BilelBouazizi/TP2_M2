package com.example.favoris;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebSiteFragment extends Fragment {

private WebView webView;
    private String url;

    public static WebSiteFragment newInstance(String link) {
        WebSiteFragment fragment = new WebSiteFragment();
        Bundle args = new Bundle();
        args.putString("website", link);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString("website");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_web_site, container, false);
        webView=view.findViewById(R.id.webview);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            // Fonction qui permet l'affichage de la page lorsque tout est chargé (événement onPageFinished)

            public void onPageFinished(WebView view, String url) {
               webView.setVisibility(View.VISIBLE);
            }
        });
        return  view;
    }



}
