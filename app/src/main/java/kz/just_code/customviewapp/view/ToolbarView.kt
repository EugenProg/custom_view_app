package kz.just_code.customviewapp.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import kz.just_code.customviewapp.R
import kz.just_code.customviewapp.databinding.ViewToolbarBinding

class ToolbarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: ViewToolbarBinding =
        ViewToolbarBinding.inflate(LayoutInflater.from(context), this)

    var backClick: (() -> Unit)? = null
    var favoriteClick: (() -> Unit)? = null

    init {
        setAttrs(attrs, R.styleable.ToolbarView) {
            binding.title.text = it.getString(R.styleable.ToolbarView_toolbar_title)
            binding.favoriteBtn.isVisible =
                it.getBoolean(R.styleable.ToolbarView_toolbar_favorite_visibility, false)

            val titleColor = it.getColor(
                R.styleable.ToolbarView_toolbar_title_color,
                ContextCompat.getColor(context, R.color.black)
            )
            val backButtonColor = it.getColor(
                R.styleable.ToolbarView_toolbar_back_color,
                ContextCompat.getColor(context, R.color.black)
            )
            binding.title.setTextColor(titleColor)
            binding.backBtn.setColorFilter(backButtonColor)
            binding.favoriteBtn.setImageResource(
                it.getResourceId(R.styleable.ToolbarView_toolbar_end_icon, R.drawable.ic_favorite)
            )
        }

        binding.backBtn.setOnClickListener {
            backClick?.invoke()
        }

        binding.favoriteBtn.setOnClickListener {
            binding.favoriteBtn.setColorFilter(ContextCompat.getColor(context, R.color.red))
            favoriteClick?.invoke()
        }
    }

    var title: String
        get() = binding.title.text.toString()
        set(value) {
            binding.title.text = value
        }

    var showFavoriteButton: Boolean
        get() = binding.favoriteBtn.isVisible
        set(value) {
            binding.favoriteBtn.isVisible = value
        }

    enum class Style() {
        WHITE, BLACK, RED, BLUE
    }
}

inline fun View.setAttrs(
    attrs: AttributeSet?,
    styleable: IntArray,
    crossinline body: (TypedArray) -> Unit
) {
    context.theme.obtainStyledAttributes(attrs, styleable, 0, 0)
        .apply {
            try {
                body.invoke(this)
            } finally {
                recycle()
            }
        }
}