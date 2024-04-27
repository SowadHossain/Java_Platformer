package utils;

import main.Game;

import java.awt.geom.Rectangle2D;

public class HelpMethods {
    public static boolean CanMoveHere(float x,float y,float width, float height, int [][] lvlData){
        if(!isSolid(x,y,lvlData)){
            if(!isSolid(x+width ,y+height,lvlData))
                if (!isSolid(x+width,y,lvlData))
                    if(!isSolid(x,y+height,lvlData))
                        return true;
        }
        return false;
    }

    private static boolean isSolid(float x,float y, int[][] lvlData){
        if(x<0 || x >= Game.GAME_WIDTH)
            return true;
        if(y<0 || y >= Game.GAME_HEIGHT)
            return true;

        float xIndex = x/Game.TILES_SIZE;
        float yIndex = y/Game.TILES_SIZE;

        int value = lvlData[(int)yIndex][(int)xIndex];
        if(value >= 48 || value < 0 || value != 11)
            return true;
        else return false;
    }
    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
        int currentTile= (int)hitbox.x / Game.TILES_SIZE;
        if(xSpeed > 0){
            //right
            int tileXPos = currentTile * Game.TILES_SIZE;
            int xOffset = (int)(Game.TILES_SIZE - hitbox.width);
            return  tileXPos + xOffset -1;
        }else {
            //left
            return currentTile * Game.TILES_SIZE;

        }
    }

}
