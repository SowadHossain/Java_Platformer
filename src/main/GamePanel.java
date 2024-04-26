package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.*;
import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;


public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game){

        mouseInputs = new MouseInputs(this);
        this.game = game;


        setPanelSize();
        addKeyListener(new KeybordInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }




    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }




    public void updateGame() {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }
    public Game getGame(){
        return game;
    }

}
