package io.github.mthli.gdxhelloworld;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;

import com.badlogic.gdx.backends.android.AndroidApplication;

import ogllib.OGLApplication;
import ogllib.OGLGamePanel;

public class MainActivity extends OGLApplication {

    private OGLGamePanel oglGamePanel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oglGamePanel = new OGLGamePanel(this);
        setContentView(oglGamePanel);

        oglGamePanel.setBackground(ContextCompat.getDrawable(this,R.drawable.ic_launcher_background));
        //oglGamePanel.setBackgroundColor(Color.BLUE);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background);
        oglGamePanel.drawImageAt(bitmap,0,0);
    }


}