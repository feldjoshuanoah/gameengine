package com.feldjoshuanoah.gamengine.util;

import com.feldjoshuanoah.gameengine.Application;
import com.feldjoshuanoah.gameengine.entity.Entity;
import com.feldjoshuanoah.gameengine.entity.component.SpriteComponent;
import com.feldjoshuanoah.gameengine.render.Camera;
import com.feldjoshuanoah.gameengine.render.Shader;
import com.feldjoshuanoah.gameengine.render.Transform;
import com.feldjoshuanoah.gameengine.render.scene.AbstractScene;
import org.joml.Vector2f;
import org.joml.Vector4f;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SceneTest extends AbstractScene {

    public SceneTest() throws URISyntaxException, IOException {
        super(new Camera(-1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f), new Shader(Files.readString(Paths.get(SceneTest.class.getClassLoader().getResource("shader/default_v.glsl").toURI())),
                Files.readString(Paths.get(SceneTest.class.getClassLoader().getResource("shader/default_f.glsl").toURI()))));
    }

    @Override
    public void update() {
        getCamera().setPosition(getCamera().getPosition().add(Application.getInstance().getDeltaTime() * 0.1f, 0, 0));
    }

    @Override
    public void create() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                final Entity entity = new Entity(new Transform(new Vector2f(0.01f * i, 0.01f * j), new Vector2f(0.01f, 0.01f)));
                entity.addComponent(new SpriteComponent(new Vector4f(0.01f * i, 0.01f * j, 1, 1)));
                addEntity(entity);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
