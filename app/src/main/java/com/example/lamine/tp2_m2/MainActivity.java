package com.example.lamine.tp2_m2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.Progress);

        // On récupère l'instance via l'activité
        webView = (WebView) findViewById(R.id.WebView);
        // Puis on charge le contenu, soit distant, soit local
        webView.loadUrl("http://mastersid.univ-rouen.fr");

        // On modifie l'activité de telle sorte qu'elle que
        // chaque lien soit ouvert dans le webView

        // alors juste avec cette ligne on peut le réaliser
        webView.setWebViewClient(new WebViewClient());

    }

    // La gestion du bouton retour pour pouvoir naviger dans l'historique
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // Verifie  que l’evenement  concerne  le  bouton  ’retour ’
        // et s’il y a un  historique  de  pages
        if ((keyCode == KeyEvent.KEYCODE_BACK) &&
                this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }
        // S’il ne s’agit  pas du  bouton  ’retour ’ ou qu’il n’y a
        // pas  encore d’historique , on  declenche  le  comportement
        // par  defaut (e.g. fermer l’activite)
        return super.onKeyDown(keyCode, event);
    }
    // Progress BAR

    /***********************************************************************/
    private class MyWebChrome extends WebChromeClient {
        private MainActivity parent;

        public MyWebChrome(MainActivity parent) {
            this.parent = parent;
        }

        @Override
        public void onProgressChanged(WebView view, int progress) {
            parent.progressBar.setProgress(progress);
            if (progress == 100) {
                parent.setTitle(view.getTitle());
            }
        }

    }
}
