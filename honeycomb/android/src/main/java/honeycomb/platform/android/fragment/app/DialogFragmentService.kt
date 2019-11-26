package honeycomb.platform.android.fragment.app

import androidx.fragment.app.DialogFragment

class DialogFragmentService {
    companion object {
        fun preventUserCancellation(fragment: DialogFragment) {
            fragment.isCancelable = false
            fragment.dialog?.let {
                it.setCancelable(false)
                it.setCanceledOnTouchOutside(false)
            }
        }
    }
}