package org.example.springlearning;


import java.util.List;
import java.util.Random;


public class MusicPlayer {

    private List<Music> musicList;
    private int volume;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MusicPlayer() {
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String playMusic(Genres genre) {

       return "Playing: " + musicList.get(new Random().nextInt(3)).getSong().get(new Random().nextInt(3));

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
