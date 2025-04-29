import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamb_app_prototype.data.StroemPriserHåndtering
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MinStroemViewModel : ViewModel() {
    private val StroemPriserHåndtering = StroemPriserHåndtering()
    var currentPrices: String by mutableStateOf("yohoo")
        private set

    fun fetchPrices() {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO) {
                    currentPrices = StroemPriserHåndtering.getNewPrices().date
                }
            } catch (e: Exception) {
                currentPrices = e.message.toString()
            }
        }
    }
}