package PlusWorld;
import org.junit.Test;
import static org.junit.Assert.*;

import byowTools.TileEngine.TERenderer;
import byowTools.TileEngine.TETile;
import byowTools.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of plus shaped regions.
 */
public class PlusWorld {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;

    public static void addPlus(int size) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // bottom
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < (3 * size); x++) {
                if (x >= size && x <= (2*size-1)) {
                    world[x][y] = Tileset.FLOWER;
                } else {
                    world[x][y] = Tileset.NOTHING;
                }
            }
        }

        // middle
        for (int y = size; y < (size + size); y++) {
            for (int x = 0; x < (3 * size); x++) {
                world[x][y] = Tileset.FLOWER;
            }
        }

        // top
        for (int y = (size * 2); y < (3 * size); y++) {
            for (int x = 0; x < (3 * size); x++) {
                if (x >= size && x <= (2*size-1)) {
                    world[x][y] = Tileset.FLOWER;
                } else {
                    world[x][y] = Tileset.NOTHING;
                }
            }
        }
        ter.renderFrame(world);
    }
    public static void main(String[] args) {
        addPlus(5);
    }
}
