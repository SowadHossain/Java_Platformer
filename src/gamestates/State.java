package gamestates;

import main.Game;
import ui.MenuButtons;

import java.awt.event.MouseEvent;

public class State {
    protected Game game;
    public State(Game game) {
        this.game = game;
    }

    public boolean isIn(MouseEvent e, MenuButtons mb){
        return mb.getBounds().contains(e.getX(),e.getY());
    }

    public Game getGame(){
        return game;
    }
}
