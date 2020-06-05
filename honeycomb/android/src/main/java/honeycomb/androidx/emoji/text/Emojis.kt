package honeycomb.androidx.emoji.text

import androidx.emoji.text.EmojiCompat

enum class Emojis(val nameOfEmoji: String, val value: String) {
    NEUTRAL_FACE("neutral face", "\uD83D\uDE10");

    val valueCompat = EmojiCompat.get().process(value)
}