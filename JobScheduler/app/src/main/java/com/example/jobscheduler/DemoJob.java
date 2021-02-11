package com.example.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class DemoJob extends JobService {  //add service to manifest
    @Override
    public boolean onStartJob(JobParameters params) {//members

        Toast.makeText(this, "Hello Job", Toast.LENGTH_SHORT).show();

        //jobFinished(params,false);   if true

        return false;  //false can be also be there but true means task is still going on   ASYNC TASK
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
