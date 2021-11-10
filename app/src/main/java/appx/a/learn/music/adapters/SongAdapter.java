package appx.a.learn.music.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import appx.a.learn.music.R;
import appx.a.learn.music.models.Song;


public class SongAdapter extends BaseAdapter {

    private List<Song> listData;
    private Context context;

    public SongAdapter(List<Song> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (listData == null)
            return 0;
        return listData.size();
    }

    @Override
    public Song getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.view_song, null);
            holder = new ViewHolder();
            holder.ivSong = convertView.findViewById(R.id.iv_song);
            holder.tvSong = convertView.findViewById(R.id.tv_song);
            holder.tvSinger = convertView.findViewById(R.id.tv_singer);
            holder.isFavorite = convertView.findViewById(R.id.iv_is_favorite);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.isFavorite.setImageResource(getItem(position).isFavorite() ? R.drawable.ic_favorite : R.drawable.ic_unfavorite);
        holder.ivSong.setImageResource(getItem(position).getIdImageSong());
        holder.tvSong.setText(getItem(position).getNameSong());
        holder.tvSinger.setText(getItem(position).getSinger());
        return convertView;
    }

    static class ViewHolder {
        ImageView ivSong;
        TextView tvSong;
        TextView tvSinger;
        ImageView isFavorite;
    }
}
