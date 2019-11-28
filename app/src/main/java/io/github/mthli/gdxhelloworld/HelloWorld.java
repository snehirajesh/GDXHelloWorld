package io.github.mthli.gdxhelloworld;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.RenderListener;
import com.badlogic.gdx.backends.jogl.JoglApplication;

public class HelloWorld implements RenderListener {
    public static void main(String[] argv) {
        JoglApplication app = new JoglApplication("Hello World", 480, 320);
        app.addRenderListener(new HelloWorld());
    }

    @Override
    public void setup(Application arg0) {

    }

    @Override
    public void render(Application arg0) {

    }


    @Override
    public void dispose(Application arg0) {

    }
}
