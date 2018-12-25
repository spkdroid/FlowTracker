package ca.rovbot.flowtracker.viewmodel

import android.arch.lifecycle.ViewModel;
import android.content.Context
import ca.rovbot.flowtracker.R
import com.applandeo.materialcalendarview.EventDay
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CalendarViewModel : ViewModel() {


    fun fetchEvent(context: Context?): MutableList<EventDay> {

        val editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        val remdays = editor.getString("date", "date").toInt()

        var events = ArrayList<EventDay>()
        var count = 0;
        for(i in 1..20) {
            val calendar = Calendar.getInstance()
            if(i==1){
                calendar.add(Calendar.DATE,remdays-getDayCount(context).toInt());
                count = remdays-getDayCount(context).toInt();
                events.add(EventDay(calendar, R.drawable.blood))
            } else {

                for(j in -1..2) {
                    val calendar1 = Calendar.getInstance()
                    calendar1.add(Calendar.DATE, count+j)
                    events.add(EventDay(calendar1, R.drawable.blood))
                }
                count += remdays
            }
        }
        return events;
    }

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

    // TODO: Implement the ViewModel
}
