package sample;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.FileInputStream;

public class musiquePlayer {
    private AdvancedPlayer player;
    private int pausedOnFrame = 0;
    //
    private String chemin;
    //
    public musiquePlayer(String chemin) {
        //start music
        startPlayer(chemin);
        this.chemin = chemin;
    }

    //play/ pause the music
    public void playState(boolean state) {
        if (!state)
            player.stop();
        else
            startPlayer(this.chemin);
    }

    //music player controller
    private void startPlayer(String chemin) {
        //init a new thread in order to avoid app crashes
        //since both the GUI and Player will run on the same thread, that will cause the music to play but we'll have
        // a non responsive window
        //having the GUI and player on separate threads
        new Thread(() -> {
            try {
                //get music file
                FileInputStream fileInputStrem = new FileInputStream(chemin);
                player = new AdvancedPlayer(fileInputStrem);
                player.setPlayBackListener(new PlaybackListener() {
                    @Override
                    public void playbackFinished(PlaybackEvent event) { // on music stop
                        //save the frame where the music stopped at
                        pausedOnFrame = event.getFrame();
                    }
                });
                //.play(start, end);
                //play the music
                player.play(pausedOnFrame, 99999999);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
