package com.example.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int JOB_ID = 123;

    //https://medium.com/google-developers/scheduling-jobs-like-a-pro-with-jobscheduler-286ef8510129
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sjob(View view) {

        JobScheduler jobScheduler =
                (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

        JobInfo jobInfo= new JobInfo.Builder(JOB_ID,new ComponentName(this,DemoJob.class)).setPeriodic(120000)
                .setPersisted(true).setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED).setRequiresCharging(true).build();

        jobScheduler.schedule(jobInfo);

    }
}