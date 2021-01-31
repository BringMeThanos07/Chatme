package com.example.clickablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    public static final String TAG="list";

    ArrayList<Student> teachers= Student.get10StudentrandomName();
    ListView lvTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvTeacher=findViewById(R.id.lvTeacher);
        TeacherAdapter teacherAdapter=new TeacherAdapter();
        lvTeacher.setAdapter(teacherAdapter);

    }

    class TeacherAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return teachers.size();
        }

        @Override
        public Student getItem(int i) {
            return teachers.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {

            Log.d(TAG,"getView"+convertView);
            CourseViewHolder holder;
            if(convertView==null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.info,
                        viewGroup,
                        false
                );
                holder=new CourseViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder=(CourseViewHolder)convertView.getTag();
            }

            holder. tvName.setText(getItem(i).getName());
            holder. tvCourse.setText(getItem(i).getCourse());
            holder. tvRollno.setText(getItem(i).getRollno());


            return convertView;
        }
        class CourseViewHolder {
            TextView tvName,tvCourse;
            TextView tvRollno;
            CourseViewHolder(View convertView)
            {
                tvName=convertView.findViewById(R.id.name);
                tvCourse=convertView.findViewById(R.id.course);
                tvRollno=convertView.findViewById(R.id.rollno);
            }
        }
    }
}