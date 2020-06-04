package honeycomb.platform.android.content.res

import android.annotation.SuppressLint
import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat

class ThemeAttrService {
    companion object {

        /**
         * Resolve color theme attribute
         * https://stackoverflow.com/questions/33050999/programmatically-set-text-color-to-primary-android-textview
         */
        @SuppressLint("ResourceAsColor")
        @ColorInt
        fun getThemeAttrColor(context: Context, @AttrRes attrRes: Int): Int {
            val resolvedAttr = resolveThemeAttr(context, attrRes)
            val colorRes = resolvedAttr.run { if (resourceId != 0) resourceId else data }
            return ContextCompat.getColor(context, colorRes)
        }

        /**
         * Retrieve the referenced resource id of an attribute in the Theme.
         * If Value came from a resource, this holds the corresponding resource id.
         *
         * https://stackoverflow.com/questions/17277618/get-color-value-programmatically-when-its-a-reference-theme
         *
         * @return ResourceId Integer
         * @throws
         */
        fun getThemeAttrResourceId(context: Context, @AttrRes attrRes: Int): Int {
            val resolvedAttr = resolveThemeAttr(context, attrRes)
            return resolvedAttr.resourceId
        }

        /**
         * Retrieve the value of an attribute in the Theme.
         */
        fun resolveThemeAttr(context: Context, @AttrRes attrRes: Int): TypedValue {
            val typedValue = TypedValue()
            val theme = context.theme
            val found = theme.resolveAttribute(attrRes, typedValue, true)
            if (!found)
                throw IllegalArgumentException("Attribute not found")
            return typedValue
        }
    }
}