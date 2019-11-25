package honeycomb.platform.android.fragment.app

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import honeycomb.android.R
import honeycomb.platform.android.content.DimensionService


class AlertDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            val contentView = inflater.inflate(R.layout.view_dialog_progress,null)
            contentView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            builder.setView(contentView)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }


    override fun onResume() {
        super.onResume()

        val window = dialog!!.window
        val layoutParams = window!!.attributes
        layoutParams.width = DimensionService.get200Dp(context!!)
        layoutParams.height = DimensionService.get150Dp(context!!)
        window.attributes = layoutParams
    }


    companion object{
        private const val FRAGMENT_TAG = "AlertDialogFragment"

        fun present(fragmentManager: FragmentManager): AlertDialogFragment {
            val fragment = AlertDialogFragment()
            fragment.show(fragmentManager, FRAGMENT_TAG)
            return fragment
        }
    }
}