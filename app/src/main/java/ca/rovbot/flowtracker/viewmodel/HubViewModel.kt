package ca.rovbot.flowtracker.viewmodel

import android.arch.lifecycle.ViewModel;
import android.content.Context
import ca.rovbot.flowtracker.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*



class HubViewModel : ViewModel() {


    fun getDayCount(context: Context?):String {
        val editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        val formatter: DateFormat
        var date: Date
        formatter = SimpleDateFormat("dd-MM-yyyy")
        date = formatter.parse(editor.getString("freq", "freq").toString())
        var currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        var currentDay: Date
        currentDay = formatter.parse(currentDate)
        val v = daysBetween(date,currentDay)
        return v.toString()
    }

    fun daysBetween(d1: Date, d2: Date): Long {
        return ((d2.time - d1.time) / (1000 * 60 * 60 * 24))
    }

    fun getCurrentProgress(currentDayNumber:String,context: Context?):Float{
        val editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        val maxDate = editor.getString("date", "date").toString()
        var percentage = (currentDayNumber.toFloat()/maxDate.toFloat())*100;
        return percentage
    }

}
