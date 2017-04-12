package com.example.artivatic.reddit;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by artivatic on 31/3/17.
 */

public class ImageLoader {
    public static void downloadImage(Context c, String imgUrl, ImageView img)
    {
        if(!imgUrl.isEmpty() && imgUrl!=null )
        {
            Log.e("image_urrllll",""+imgUrl);
            Picasso.with(c).load(imgUrl).into(img);

        }
        else
        {
            Log.e("image_urrllll",""+imgUrl);
            Picasso.with(c).load(R.drawable.london).into(img);
        }

    }
}
