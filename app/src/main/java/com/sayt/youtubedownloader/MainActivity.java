package com.sayt.youtubedownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize views from the layout
        final EditText urlContainer = findViewById(R.id.content_url);
        Button downloadBtn = findViewById(R.id.download_btn);
        Button pasteBtn = findViewById(R.id.paste_btn);


        //When the past button is clicked
        pasteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check the android version and
                // see if it has api version greater than 23
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    //Check if clipboard data exist at all
                    ClipData clipData = Objects.requireNonNull(getSystemService(ClipboardManager.class)).getPrimaryClip();
                    //If the clipboad exist and its not empty....
                    if (clipData!=null){
                        //Get Clipboard value and save it in String Value
                        String clipText = clipData.getItemAt(0).getText().toString();
                        //Set the text into the editText view
                        urlContainer.setText(clipText);
                    }
                }
            }
        });



        //When the download button is clicked
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Just toast 'Download'
                Toast.makeText(MainActivity.this, "Download", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
