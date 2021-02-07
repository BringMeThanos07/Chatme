package com.example.todoapporiginal

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

const val dbname="todo.db"

class TaskActivity : AppCompatActivity(), View.OnClickListener {

    private val labels = arrayListOf("Personal", "Business", "Insurance", "Shopping", "Banking","Education","very very Important")

    val db by lazy {
        Appdatabase.getDatabase(this)
    }

    var finalDate = 0L
    var finalTime = 0L

    lateinit var mycalender:Calendar
    lateinit var datesetlistener:DatePickerDialog.OnDateSetListener
    lateinit var timeSetListener: TimePickerDialog.OnTimeSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        dateEdt.setOnClickListener(this)
        timeEdt.setOnClickListener(this)
        saveBtn.setOnClickListener(this)

        setUpSpinner()
    }

    private fun setUpSpinner() {
        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, labels)

        labels.sort()

        spinnerCategory.adapter = adapter
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.dateEdt->{
               setlistener()
            }
            R.id.timeEdt->{
                timesetlistener()
            }
            R.id.saveBtn -> {
                saveTodo()
            }
        }
    }

    private fun saveTodo() {
        val category = spinnerCategory.selectedItem.toString()
        val title = titleInpLay.editText?.text.toString()
        val description = taskInpLay.editText?.text.toString()

        GlobalScope.launch(Dispatchers.Main) {
            val id = withContext(Dispatchers.IO) {
                return@withContext db.todoDao().insertTask(
                    TodoModel(
                        title,
                        description,
                        category,
                        finalDate,
                        finalTime
                    )
                )
            }
            finish()
        }
    }

    private fun timesetlistener() {
        mycalender= Calendar.getInstance()
        
        timeSetListener=TimePickerDialog.OnTimeSetListener { _: TimePicker, hourOfDay: Int, min: Int ->
            mycalender.set(Calendar.HOUR_OF_DAY, hourOfDay)
            mycalender.set(Calendar.MINUTE, min)
            updateTime()
        }
        val timePickerDialog = TimePickerDialog(
            this, timeSetListener, mycalender.get(Calendar.HOUR_OF_DAY),
            mycalender.get(Calendar.MINUTE), false
        )
        timePickerDialog.show()
    }

    private fun updateTime() {
        //Mon, 5 Jan 2020
        val myformat = "h:mm a"
        val sdf = SimpleDateFormat(myformat)
        finalTime = mycalender.time.time
        timeEdt.setText(sdf.format(mycalender.time))
    }

    private fun setlistener() {
        mycalender= Calendar.getInstance()

        datesetlistener=DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            mycalender.set(Calendar.YEAR, year)
            mycalender.set(Calendar.MONTH, month)
            mycalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDate()

        }
        val datePickerDialog = DatePickerDialog(
            this, datesetlistener, mycalender.get(Calendar.YEAR),
            mycalender.get(Calendar.MONTH), mycalender.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.minDate=System.currentTimeMillis()
        datePickerDialog.show()

    }

    private fun updateDate() {
        //Mon, 5 Jan 2020
        val myformat = "EEE, d MMM yyyy"
        val sdf = SimpleDateFormat(myformat)
        finalDate = mycalender.time.time
        dateEdt.setText(sdf.format(mycalender.time))

        timeInptLay.visibility = View.VISIBLE

    }

}