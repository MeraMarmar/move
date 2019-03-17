package com.example.allinone.moveapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.allinone.moveapp.R;
import com.example.allinone.moveapp.adpter.recyle_adpter;
import com.example.allinone.moveapp.models.move;
import com.example.allinone.moveapp.volley.volleySinglton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class mvies_frag extends Fragment {

    RecyclerView recycle_movies;
    recyle_adpter recyleAdpter;
    ArrayList<move>data;
   // private mvies_frag.OnFragmentInteractionListener mListener;
    public mvies_frag() {
        // Required empty public constructor
    }
  //  @Override
   // public void onAttach(Context context) {
      // super.onAttach(context);
       // if (context instanceof mvies_frag.OnFragmentInteractionListener) {
         //  mListener = (mvies_frag.OnFragmentInteractionListener) context;
        //} else {
         //   throw new RuntimeException(context.toString()
          //          + " must implement OnFragmentInteractionListener");
      //  }
    //}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_mvies_frag, container, false);
        recycle_movies=view.findViewById(R.id.recycle_movies);
        getdatafragmentapi();
        return view;
    }
    String url="https://api.themoviedb.org/3/movie/popular?api_key=33e06a19d1fe4848f134449f721c08fe";
    public void getdatafragmentapi(){
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    data=parsing_json(response + "");
                    recyleAdpter =new recyle_adpter(data,getActivity());
                    recycle_movies.setAdapter(recyleAdpter);
                    RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
                    recycle_movies.setLayoutManager(layoutManager);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        volleySinglton.getInstance(getContext()).addToRequestQueue(request);
    }

    public ArrayList<move> parsing_json(String Json) throws JSONException {
        ArrayList<move>moves=new ArrayList<>();
        JSONObject root=new JSONObject(Json);
        JSONArray results=root.getJSONArray("results");
        for(int i=0 ;i<results.length();i++){
            String id; String title; String imagepath; String overview; String date; String rate; String type;
            JSONObject move=results.getJSONObject(i);
            move newmove=new move(
                    move.getString("id")
                    ,move.getString("original_title"),
                    move.getString("poster_path"),
                    move.getString("overview"),
                    move.getString("release_date"),
                    move.getString("vote_average"),
                    move.getString("adult")

            );
            moves.add(newmove);
        }
        return moves;

    }
}
