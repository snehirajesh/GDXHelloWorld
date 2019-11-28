package ogllib;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Window;
import android.view.WindowManager;

import ogllib.render.OGLRenderer;

public class OGLGamePanel extends GLSurfaceView {

    private OGLRenderer oglRenderer;
    private boolean RENDER_DONE = false;

    public OGLGamePanel(Context context) {
        super(context);
        init(context);
    }

    public OGLGamePanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * Intilize
     *
     * @param context
     */
    private void init(Context context) {
        // Full screen UI
        expandFullScreen(context);

        // start rendering
        initRender();
    }

    private void initRender() {

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        oglRenderer = new OGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(oglRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        RENDER_DONE = true;
    }

    /**
     * Full Screen UI
     * @param context
     */
    private void expandFullScreen(Context context) {
        if (context instanceof Activity) {
            try {
                Activity activity = (Activity) context;
                activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
                activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } catch (Exception e) {

            }

        }
    }


    @Override
     public  void setBackground(Drawable background) {

          if(oglRenderer != null){
              if (background instanceof BitmapDrawable) {
                  BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
                  if(bitmapDrawable.getBitmap() != null) {
                      Bitmap bitmap = bitmapDrawable.getBitmap();
                      oglRenderer.setBackground(bitmap);
                  }
              }

          }
    }


    @Override
    public  void setBackgroundColor(int color) {
        if(oglRenderer !=null){
            oglRenderer.setBackgroundColor(color);
        }
    }

    public void drawImageAt(Bitmap bitmap, int i, int i1) {

        if(RENDER_DONE){

        }
    }
}
