package com.mystic.layer7.entity;

import org.springframework.data.annotation.Id;

public class Playlist
{
    @Id
    private String id;

    private String playlistLink;
    private String genre;

    Playlist(){}

    public Playlist(String playlistLink, String genre)
    {
        this.playlistLink = playlistLink;
        this.genre = genre;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPlaylistLink()
    {
        return playlistLink;
    }

    public void setPlaylistLink(String playlistLink)
    {
        this.playlistLink = playlistLink;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    @Override
    public String toString()
    {
        return "Playlist{" +
                "id='" + id + '\'' +
                ", playlistLink='" + playlistLink + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
