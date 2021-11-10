package appx.a.learn.music.models;

public class Song {
    private int idImageSong, idRawSong;
    private String nameSong, singer;
    private boolean isFavorite;

    public Song(int idImageSong, int idRawSong, String nameSong, String singer, boolean isFavorite) {
        this.idImageSong = idImageSong;
        this.idRawSong = idRawSong;
        this.nameSong = nameSong;
        this.singer = singer;
        this.isFavorite = isFavorite;
    }

    public int getIdImageSong() {
        return idImageSong;
    }

    public void setIdImageSong(int idImageSong) {
        this.idImageSong = idImageSong;
    }

    public int getIdRawSong() {
        return idRawSong;
    }

    public void setIdRawSong(int idRawSong) {
        this.idRawSong = idRawSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
