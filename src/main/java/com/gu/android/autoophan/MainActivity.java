package com.gu.android.autoophan;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import static android.content.Intent.ACTION_SEND;
import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends Activity {

    private static final Uri OPHAN_URI = Uri.parse("http://dashboard.ophan.co.uk/summary");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (ACTION_SEND.equals(intent.getAction()) && "text/plain".equals(intent.getType())) {
            String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
            if (sharedText != null) {
                Uri uri = OPHAN_URI.buildUpon().appendQueryParameter("url", sharedText).build();
                startActivity(new Intent(ACTION_VIEW, uri));
                finish();
            }
        }
    }

}
