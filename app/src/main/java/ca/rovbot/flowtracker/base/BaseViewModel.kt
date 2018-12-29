package ca.rovbot.flowtracker.base

import android.arch.lifecycle.ViewModel
import android.content.Context
import ca.rovbot.flowtracker.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

open class BaseViewModel: ViewModel() {

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
        return v.toString();
    }

     fun daysBetween(d1: Date, d2: Date): Long {
        return ((d2.time - d1.time) / (1000 * 60 * 60 * 24)) as Long
    }


    fun registerUser(lastPeriodDate:String,numberOfDays:String,ctx: Context) {
        val editor = ctx.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE).edit()
        editor.putString("date", lastPeriodDate)
        editor.putString("freq",numberOfDays)
        editor.apply()
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


    fun validateUser(it: Context?): Boolean {

        val editor = it!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)

        val date = editor.getString("date","date").toString()
        val freq = editor.getString("freq","freq").toString()

        if(date == "date" && freq == "freq") {
            return true
        }
        return false
    }


}