import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = verticalSpaceHeight // Устанавливаем отступ снизу для каждого элемента
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = verticalSpaceHeight // Добавляем отступ сверху только для первого элемента
        }
    }
}
