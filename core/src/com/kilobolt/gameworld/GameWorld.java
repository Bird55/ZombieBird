package com.kilobolt.gameworld;

import com.kilobolt.gameobjects.Bird;
import com.kilobolt.gameobjects.ScrollHandler;
import com.kilobolt.zbHelpers.AssetLoader;

public class GameWorld {

    private Bird bird;
    private ScrollHandler scroller;

    private boolean isAlive;

    public GameWorld(int midPointY) {
        // инициализируйте Bird тут
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        scroller.update(delta);
        bird.update(delta);

        if (isAlive && scroller.collides(bird)) {
            // Clean up on game over
            scroller.stop();
            AssetLoader.dead.play();
            isAlive = false;
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
