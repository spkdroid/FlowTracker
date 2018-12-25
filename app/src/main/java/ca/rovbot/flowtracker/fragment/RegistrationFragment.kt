package ca.rovbot.flowtracker.fragment

import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import ca.rovbot.flowtracker.R
import ca.rovbot.flowtracker.viewmodel.RegistrationViewModel
import kotlinx.android.synthetic.main.registration_fragment.*
import java.util.*




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

            val validFlag = Integer.parseInt(viewModel.checkSelectedDateValid(view!!.context,dateinputtext.text.toString()));
            if(validFlag>-1) {
                viewModel.registerUser(daysinputtext.text.toString(), dateinputtext.text.toString(), this!!.context!!)

                if (viewModel.validateUser(view!!.context)) {
                    Navigation.findNavController(it).navigate(R.id.action_registrationFragment_to_hubFragment)
                } else {
                    Toast.makeText(view!!.context, "Registartion Failed", Toast.LENGTH_LONG).show()
                }

            } else {
                Toast.makeText(view!!.context,"Please Pick a valid date",Toast.LENGTH_LONG).show()
            }

        }

    }
}
