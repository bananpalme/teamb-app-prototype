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
            Apparat("Opvaskemaskine 1", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine 2", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine 3", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine 4", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine 5", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine 6", R.drawable.opvaskemaskine),
            Apparat("Opvaskemaskine 7", R.drawable.opvaskemaskine),
            Apparat("Tørretumbler", R.drawable.tumbler),
            Apparat("Tørretumbler", R.drawable.tumbler),
            Apparat("Tørretumbler", R.drawable.tumbler)
        )
    )
    val apparater: StateFlow<List<Apparat>> = _apparater
}

//test