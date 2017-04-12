package com.example.artivatic.reddit;

import com.squareup.picasso.Downloader;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/**
 * Created by artivatic on 30/3/17.
 */

public interface ApiService {


  //  http://localhost/first_project/myFirstPhp/PredictFilter.php?uid=1

    @GET("myFirstPhp/PredictFilter.php")
    Call<BookResponse> downloadBooks(@Query("uid") String uid);
}
// This is response of api that i made in php in my local server apache.
//{
//        "status": 1,
//        "info": [
//        {
//        "tilte": "Digital Marketing: Strategy, Implementation and Practice",
//        "description": "Now in its fifth edition, Digital Marketing (previously Internet Marketing) provides comprehensive, practical guidance on how companies can get the most out of digital media to meet their marketing goals. Digital Marketing links marketing theory with practical business experience through case studies and interviews from cutting edge companies such as eBay and Facebook, to help students understand digital marketing in the real world.",
//        "status": "1",
//        "image": "https://images-na.ssl-images-amazon.com/images/I/51aYydjvjAL._SX365_BO1,204,203,200_.jpg"
//        },
//        {
//        "tilte": "The Power of Visual Storytelling",
//        "description": "The Power of Visual Storytelling: How to Use Visuals, Videos and Social Media to Market Your Brand uses many examples that help illustrate the power of pictures over mere words.\nIn this connected infocentric world, the authors explain that, consumers are assaulted by a phenomenon they call infobesity: an overload of information from marketers trying to capture their attention. With so much information coming in from all sides, people have developed filters to keep out irrelevant info and advertisers and marketers have to find new ways to get the attention of their target audience.",
//        "status": "1",
//        "image": "http://ecx.images-amazon.com/images/I/51tbbYr2UZL._SY498_BO1,204,203,200_.jpg"
//        },
//        {
//        "tilte": "Convert!: Designing Web Sites to Increase Traffic and Conversion",
//        "description": "When web design expert Ben Hunt set out to quantify the difference between an ordinary web site and a great one, he expected to find the key in design simplicity. But when his team more than doubled the conversion rates for a wide range of sites, they identified simple yet powerful solutions involving design, copy, appropriate analysis, classic optimization techniques, and targeted testing.",
//        "status": "1",
//        "image": "http://ecx.images-amazon.com/images/I/51gwwQeZXiL._SX396_BO1,204,203,200_.jpg"
//        },
//        {
//        "tilte": "Global Content Marketing",
//        "description": "Technology has virtually erased national borders, forever transforming the way we reach and engage customers, as well as the way we search for and consumecontent. Global Content Marketing takes you step-by-step through the process of creating and refining your strategies to meet this new reality.",
//        "status": "1",
//        "image": "http://ecx.images-amazon.com/images/I/51LurW6%2B1tL._SX331_BO1,204,203,200_.jpg"
//        },
//        {
//        "tilte": "All Marketers Tell Stories:",
//        "description": "All marketers tell stories. And if they do it right, we believe them. We believe that wine tastes better in a $20 glass than a $1 glass. We believe that an $80,000 Porsche Cayenne is vastly superior to a $36,000 VW Touareg, even if it is virtually the same car. We believe that $225 Pumas will make our feet feel better--and look cooler--than $20 no names. . . and believing it makes it true.",
//        "status": "1",
//        "image": "https://upload.wikimedia.org/wikipedia/en/thumb/8/8f/All_Marketers_Are_Liars.jpg/220px-All_Marketers_Are_Liars.jpg"
//        },
//        {
//        "tilte": "Youtility",
//        "description": "If you're wondering how to make your products seem more exciting online, you're asking the wrong question. You're not competing for attention only against other similar products. You're competing against your customer's friends and family and viral videos and cute puppies. To win attention these days you must ask a different question: Jay Baer's utility offers a new approach that cuts through the clutter, marketing that is truly, inherently useful.",
//        "status": "1",
//        "image": "http://ecx.images-amazon.com/images/I/41lDjFWSKBL._SX329_BO1,204,203,200_.jpg"
//        }
//        ]
//        }