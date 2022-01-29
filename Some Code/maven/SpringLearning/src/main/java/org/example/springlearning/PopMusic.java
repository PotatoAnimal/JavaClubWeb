package org.example.springlearning;

import java.util.Arrays;
import java.util.List;

public class PopMusic implements Music{
    List<String> songs = Arrays.asList(new String[] {"My Heart Will Go ON", "Always Love You", "Prayer"});

    public List<String> getSong() {
        return songs;
    }
}
