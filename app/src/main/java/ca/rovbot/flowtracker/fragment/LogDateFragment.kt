package ca.rovbot.flowtracker.fragment

import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.rovbot.flowtracker.viewmodel.LogDateViewModel
import ca.rovbot.flowtracker.R
import kotlinx.android.synthetic.main.log_date_fragment.*
import java.util.*


class LogDateFragment : Fragment() {

    companion object {
        fun newInstance() = LogDateFragment()
    }

    private lateinit var viewModel: LogDateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.log_date_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LogDateViewModel::class.java)
        // TODO: Use the ViewModel
        dateinputtext.setText(viewModel.getLastPeriodDate(context))
        daysinputtext.setText(viewModel.getDays(context))

        addImage.setOnClickListener{
            val result = (Integer.parseInt(daysinputtext.text.toString())+1).toString();
            daysinputtext.setText(result)
        }

        minusImage.setOnClickListener{
            val result = (Integer.parseInt(daysinputtext.text.toString())-1).toString();
            daysinputtext.setText(result)
        }

        dateperiodicon.setOnClickListener {
            var c = Calendar.getInstance();
            var mYear = c.get(Calendar.YEAR);
            var mMonth = c.get(Calendar.MONTH);
            var mDay = c.get(Calendar.DAY_OF_MONTH);

            val datePickerDialog = DatePickerDialog(
                context,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    dateinputtext.setText(
                        dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year
                    )
                },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
        }
    }
}
