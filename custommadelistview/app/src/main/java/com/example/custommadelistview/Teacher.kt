package com.example.custommadelistview

import java.util.*

class Teacher(var name: String, var course: String) {

    companion object {
        @JvmStatic
        fun get10TeacherrandomName(): ArrayList<Teacher> {
            val teachers = ArrayList<Teacher>()
            teachers.add(Teacher("yash", "science"))
            teachers.add(Teacher("ash", "smae"))
            teachers.add(Teacher("rah", "wxcrfnce"))
            teachers.add(Teacher("yaxercsh", "sciebsaibcnce"))
            teachers.add(Teacher("yahsabxicsh", "sciexz i nce"))
            teachers.add(Teacher("ysadash", "sciemneijnfoiweoince"))
            teachers.add(Teacher("ynouash", "scisnxence"))
            teachers.add(Teacher("yjiash", "scidsncence"))
            teachers.add(Teacher("yainish", "scsience"))
            return teachers
        }
    }
}