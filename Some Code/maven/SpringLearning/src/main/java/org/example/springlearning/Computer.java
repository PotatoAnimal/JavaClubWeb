package org.example.springlearning;


public class Computer {
    private int id;
    private MusicPlayer musicPlayer;


    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id + " "
                 + musicPlayer.playMusic(Genres.CLASSICALMUSIC) +
                '}';
    }
}
