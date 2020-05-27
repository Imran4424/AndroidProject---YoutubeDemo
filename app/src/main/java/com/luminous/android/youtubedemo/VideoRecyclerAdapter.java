package com.luminous.android.youtubedemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.ViewHolder> {

    private final Context context;
    private final LayoutInflater layoutInflater;
    private final List<String> titles;
    private final List<String> links;

    public VideoRecyclerAdapter(Context context, List<String> titles, List<String> links) {
        this.context = context;
        this.layoutInflater =  LayoutInflater.from(context);
        this.titles = titles;
        this.links = links;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_video_preview, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(titles.get(position));
        holder.currentPosition = position;


        

        holder.thumbnail.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = links.get(position);
                youTubePlayer.cueVideo(videoId, 0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;
        public final YouTubePlayerView thumbnail;
        public int currentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textView);
            thumbnail = (YouTubePlayerView) itemView.findViewById(R.id.youtube_thumbnail);
//            getLifecycle().addObserver(thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent youtubePlayerIntent = new Intent(context, YoutubePlayer.class);
                    YoutubePlayer.youtubeVideoId = links.get(currentPosition);

                    context.startActivity(youtubePlayerIntent);
                }
            });
        }
    }
}
