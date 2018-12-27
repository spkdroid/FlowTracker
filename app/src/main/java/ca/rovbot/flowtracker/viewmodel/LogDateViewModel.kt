package ca.rovbot.flowtracker.viewmodel

import android.arch.lifecycle.ViewModel;
import android.content.Context
import android.text.Editable
import ca.rovbot.flowtracker.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class LogDateViewModel : ViewModel() {
    fun getLastPeriodDate(context: Context?): String {

        var editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
         return editor.getString("freq","freq").toString()
    }

    fun getDays(context: Context?): String {
        var editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        return editor.getString("date","date").toString()
    }


    fun checkSelectedDateValid(context: Context?,selectedCalendarDate:String):String {
        val editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        val formatter: DateFormat
        var date: Date
        formatter = SimpleDateFormat("dd-MM-yyyy")
        date = formatter.parse(selectedCalendarDate)
        var currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        var currentDay: Date
        currentDay = formatter.parse(currentDate)
        val v = daysBetween(date,currentDay)
        return v.toString();
    }

    fun daysBetween(d1: Date, d2: Date): Long {
        return ((d2.time - d1.time) / (1000 * 60 * 60 * 24)) as Long
    }

    fun updateNewPeriodDate(lastperioddate: String, freqperioddays: String, ctx: Context) {
        val editor = ctx.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE).edit()
        editor.putString("date", freqperioddays)
        editor.putString("freq",lastperioddate)
        editor.apply()
    }

    fun checkSelectedDateValid(context: Context?,selectedCalendarDate:String,selectedDayCount:String):String {
        val editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        val formatter: DateFormat
        var date: Date
        formatter = SimpleDateFormat("dd-MM-yyyy")
        date = formatter.parse(selectedCalendarDate)
        var currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        var currentDay: Date
        currentDay = formatter.parse(currentDate)
        val v = daysBetween(date,currentDay)

        if(v>Integer.parseInt(selectedDayCount) || v<0)
            return "-1"

        return v.toString()
    }



}
