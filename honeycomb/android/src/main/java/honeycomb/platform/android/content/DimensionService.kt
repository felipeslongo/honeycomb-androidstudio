package honeycomb.platform.android.content

import android.content.Context
import androidx.annotation.DimenRes
import honeycomb.android.R

class DimensionService {
    companion object {
        private fun getDpResource(context: Context, @DimenRes id: Int) = context!!.resources.getDimensionPixelSize(id)

        fun get100Dp(context : Context) = getDpResource(context, R.dimen._100dp)
        fun get150Dp(context : Context) = getDpResource(context, R.dimen._150dp)
        fun get200Dp(context : Context) = getDpResource(context, R.dimen._200dp)
    }
}
