package honeycomb.platform.android.fragment.app

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import honeycomb.android.databinding.ViewDialogStatusBinding
import honeycomb.platform.android.lifecycle.getViewModel

class StatusDialogFragment : DialogFragment() {
    private lateinit var _binding: ViewDialogStatusBinding
    private lateinit var _viewModel: StatusDialogViewModel

    private fun initViewBindings() {
        activity?.let {
            _binding = ViewDialogStatusBinding.inflate(it.layoutInflater)
            _binding.lifecycleOwner = this
            _binding.viewModel = _viewModel
            _binding.executePendingBindings()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun initViewModels() {
        _viewModel = activity!!.getViewModel()
        _viewModel.isVisible.observe(this, Observer {
            if (it)
                return@Observer
            dismiss()
        })
    }

    private fun createDialog(): AlertDialog {
        return MaterialAlertDialogBuilder(context!!)
            //val dialog = AlertDialog.Builder(context!!)
            .setView(_binding.root)
            .setPositiveButton(_viewModel.buttonTextValue) { dialogInterface, i: Int ->
                _viewModel.notifyOnUserPositiveButtonClick()
            }
            .setOnCancelListener { _viewModel.notifyOnDialogCancel() }
            .setOnDismissListener { _viewModel.notifyOnDialogDismissed() }
            .create()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initViewModels()
        initViewBindings()
        return createDialog()
    }

    companion object {
        private const val FRAGMENT_TAG =
            "honeycomb.platform.android.fragment.app.StatusDialogFragment"

        fun present(fragmentManager: FragmentManager): StatusDialogFragment {
            val fragment = StatusDialogFragment()
            fragment.show(fragmentManager, FRAGMENT_TAG)
            return fragment
        }
    }
}