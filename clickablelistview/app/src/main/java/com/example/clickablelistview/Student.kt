package com.example.clickablelistview

import java.util.*

class  Student(var name: String, var course: String, var rollno:String) {

    companion object {
        @JvmStatic
        fun get10StudentrandomName(): ArrayList<Student> {
            val student = ArrayList<Student>()
            student.add(Student("a","b","1"))
            student.add(Student("c","p","2"))
            student.add(Student("d","q","3"))
            student.add(Student("e","br","4"))
            student.add(Student("g","bd","5"))
            student.add(Student("f","bs","6"))
            student.add(Student("h","bg","7"))
            student.add(Student("i","bh","8"))
            student.add(Student("j","bj","9"))
            student.add(Student("h","bk","10"))
            student.add(Student("m","bi","11"))
            student.add(Student("n","bt","12"))
            student.add(Student("o","bp","13"))

            return student
        }
    }
}