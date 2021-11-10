package appx.a.learn.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import appx.a.learn.music.adapters.SongAdapter;
import appx.a.learn.music.models.Song;

public class MainActivity extends AppCompatActivity {

    private int currentSong = -1;
    private MediaPlayer mediaPlayer = null;
    private View oldView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Song> songs = new ArrayList<>();
        songs.add(new Song(R.drawable.lactroi, R.raw.lactroi, "Lạc trôi", "Sơn Tùng MTP", true));
        songs.add(new Song(R.drawable.huong, R.raw.huong, "Hương", "Văn Mai Hương", false));
        songs.add(new Song(R.drawable.muoinam, R.raw.muoinam, "Mười năm", "Đen Vâu", true));
        songs.add(new Song(R.drawable.muonroimasaocon, R.raw.muonroimasaocon, "Muộn rồi mà sao còn", "Sơn Tùng MTP", false));
        songs.add(new Song(R.drawable.songgio, R.raw.songgio, "Sóng gió", "Jack & K-ICM", false));
        songs.add(new Song(R.drawable.trontim, R.raw.trontim, "Trốn tìm", "Đen Vâu", true));
        ListView lvViewSong = findViewById(R.id.lv_view_song);
        SongAdapter adapter = new SongAdapter(songs, this);
        lvViewSong.setAdapter(adapter);

        lvViewSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentSong == position) {
                    if (mediaPlayer.isPlaying())
                        mediaPlayer.pause();
                    else
                        mediaPlayer.start();
                } else {
                    if (mediaPlayer != null)
                        mediaPlayer.stop();
                    if (oldView != null) {
                        TextView tvSong = oldView.findViewById(R.id.tv_song);
                        tvSong.setTextColor(getResources().getColor(R.color.color_name_song));
                    }
                    oldView = view;
                    currentSong = position;
                    TextView tvSong = oldView.findViewById(R.id.tv_song);
                    tvSong.setTextColor(getResources().getColor(R.color.color_name_song_playing));
                    mediaPlayer = MediaPlayer.create(MainActivity.this, songs.get(position).getIdRawSong());
                    mediaPlayer.start();
                }
                TextView tvSong = view.findViewById(R.id.tv_song);
                tvSong.setTextColor(getResources().getColor(R.color.color_name_song_playing));
            }
        });
    }
}