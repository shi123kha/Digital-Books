package com.example.artivatic.reddit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by artivatic on 28/3/17.
 */

public class LoadAdapter  extends BaseAdapter{

       // ArrayList<GroupList.Group> groupFriend;
        Context context;
        private LayoutInflater inflater=null;
    ArrayList<DetailModel> detailModels;
    private int lastPosition = -1;



        public LoadAdapter(MainActivity shareActivity, ArrayList<DetailModel> response) {
            this.detailModels = response;
            this.context=shareActivity;
        }

        @Override
        public int getCount() {
            return detailModels.size();
        }

        @Override
        public Object getItem(int i) {
            return detailModels.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup)
        {
            final LoadAdapter.ViewHolder holder;

            if (view == null) {

                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.row, null);
                holder = new LoadAdapter.ViewHolder(view);
                view.setTag(holder);
            } else {
                holder = (LoadAdapter.ViewHolder) view.getTag();
            }
            final DetailModel detail=(DetailModel)this.getItem(position);
            holder.title.setText(detailModels.get(position).getTitle());
            holder.description.setText(detailModels.get(position).getDescription());
            String imgUrl=detail.getImage().replace("localhost","10.0.2.2");
            ImageLoader.downloadImage(context,imgUrl,holder. postImage);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(context,detail.getTitle(),Toast.LENGTH_SHORT).show();
                    Bundle bundle= new Bundle();
                    bundle.putString("describe", detailModels.get(position).getDescription());
                    Intent i1=new Intent(context,DetailScreen.class);
                    i1.putExtras(bundle);
                    context.startActivity(i1);
                }
            });


            Animation animation = AnimationUtils.loadAnimation(context, (position> lastPosition) ? R.anim.zoom : R.anim.zoom);
            view.startAnimation(animation);
            lastPosition = position;


          return  view;

        }

        private class ViewHolder {
            ImageView postImage;
            TextView title,description;
            public ViewHolder(View view) {
                title=(TextView)view.findViewById(R.id.title);
                description=(TextView)view.findViewById(R.id.description);
                postImage=(ImageView)view.findViewById(R.id.post_images);

            }
        }


}
