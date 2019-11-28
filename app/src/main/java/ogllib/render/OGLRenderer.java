package ogllib.render;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OGLRenderer implements GLSurfaceView.Renderer {

    private Bitmap backgroundImage;
    private int backgroundColor;


    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        if (backgroundColor != 0) {
            // Set the background frame color
            float fAlpha = (float) (backgroundColor >> 24) / 0xFF;
            float fRed = (float) ((backgroundColor >> 16) & 0xFF) / 0xFF;
            float fGreen = (float) ((backgroundColor >> 8) & 0xFF) / 0xFF;
            float fBlue = (float) (backgroundColor & 0xFF) / 0xFF;
            GLES20.glClearColor(fRed, fGreen, fBlue, fAlpha);
        }

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {

    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        if (backgroundColor != 0) {
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        }
    }


    public void setBackground(Bitmap bitmap) {
        this.backgroundImage = bitmap;
    }

    public void setBackgroundColor(int color) {
        this.backgroundColor = color;
    }
}
