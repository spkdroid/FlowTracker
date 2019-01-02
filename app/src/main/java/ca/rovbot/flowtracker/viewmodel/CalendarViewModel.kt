package ca.rovbot.flowtracker.viewmodel

import android.content.Context
import ca.rovbot.flowtracker.R
import ca.rovbot.flowtracker.base.BaseViewModel
import com.applandeo.materialcalendarview.EventDay
import java.util.*
import kotlin.collections.ArrayList

class CalendarViewModel : BaseViewModel() {


    fun fetchEvent(context: Context?): MutableList<EventDay> {

        val editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        val remdays = editor.getString("date", "date").toInt()

        var events = ArrayList<EventDay>()
        var count = 0
        for(i in 1..20) {
            val calendar = Calendar.getInstance()
            if(i==1){
                calendar.add(Calendar.DATE,remdays-getDayCount(context).toInt())
                count = remdays-getDayCount(context).toInt()
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
        return events
    }
}
