import androidx.lifecycle.ViewModel
import com.example.teamb_app_prototype.R
import com.example.teamb_app_prototype.data.Apparat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ApparatViewModel : ViewModel() {

    private val _apparater = MutableStateFlow(
        listOf(
            Apparat("Tilføj", R.drawable.plus),
            Apparat("Vaskemaskine", R.drawable.vaskemaskine),
            Apparat("Opvaskemaskine", R.drawable.opvaskemaskine),
            Apparat("Tørretumbler", R.drawable.tumbler),
            Apparat("Vaskemaskine 2", R.drawable.vaskemaskine),
            Apparat("Opvaskemaskine", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine", R.drawable.opvaskemaskine)
        )
    )
    val apparater: StateFlow<List<Apparat>> = _apparater
}
