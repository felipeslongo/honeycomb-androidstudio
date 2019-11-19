package honeycomb.android.ui.drawable

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable

class AnimationDrawableService {
    companion object {
        fun startAnimationDrawable(drawable: Drawable) {
            (drawable as AnimationDrawable).start()
        }

        fun startAnimationDrawable(
            drawable: Drawable,
            beforeAnimationStart: (animationDrawable: AnimationDrawable) -> Unit) {
            val animationDrawable = drawable as AnimationDrawable
            beforeAnimationStart(animationDrawable)
            startAnimationDrawable(animationDrawable)
        }
    }
}
