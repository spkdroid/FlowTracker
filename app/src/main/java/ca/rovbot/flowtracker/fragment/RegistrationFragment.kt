package ca.rovbot.flowtracker.fragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.rovbot.flowtracker.R
import ca.rovbot.flowtracker.viewmodel.RegistrationViewModel
import kotlinx.android.synthetic.main.registration_fragment.*
import android.widget.DatePicker
import java.util.*
import android.widget.Toast
import android.view.View.OnFocusChangeListener




class RegistrationFragment : Fragment() {

    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.registration_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegistrationViewModel::class.java)
        // TODO: Use the ViewModel

        daysinputtext.setText("28")

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

        addImage.setOnClickListener{
            val result = (Integer.parseInt(daysinputtext.text.toString())+1).toString();
            daysinputtext.setText(result)
        }

        minusImage.setOnClickListener{
            val result = (Integer.parseInt(daysinputtext.text.toString())-1).toString();
            daysinputtext.setText(result)
        }

        submitregistration.setOnClickListener{
            viewModel.registerUser(daysinputtext.text.toString(),dateinputtext.text.toString())
        }

    }
}
