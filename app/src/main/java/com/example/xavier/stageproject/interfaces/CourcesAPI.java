package com.example.xavier.stageproject.interfaces;

import com.example.xavier.stageproject.Classes.Courses;
import com.example.xavier.stageproject.Classes.Global;

import java.util.ArrayList;
import java.util.List;

import retrofit.http.GET;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Query;

/**
 * Created by xavier on 4/03/2016.
 */
public interface CourcesAPI {
    @GET(Global.Cources)
    public Call<Courses> getBooks(@Query("student_id") String student_id);
}
