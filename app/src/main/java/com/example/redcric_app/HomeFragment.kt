import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.redcric_app.CricketGame
import com.example.redcric_app.CricketGameAdapter
import com.example.redcric_app.ItemOffsetDecoration
import com.example.redcric_app.R

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cricketGameAdapter: CricketGameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.videoRV)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Fetch your list of games and create adapter
        val cricketGamesList = getCricketGamesList()
        cricketGameAdapter = CricketGameAdapter(cricketGamesList)

        // Set the adapter to RecyclerView
        recyclerView.adapter = cricketGameAdapter

        // Add item decoration to adjust spacing between cards (optional)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_between_cards)
        recyclerView.addItemDecoration(ItemOffsetDecoration(spacingInPixels))

        // Inflate the custom ActionBar layout
        val actionBar = (activity as AppCompatActivity?)?.supportActionBar
        actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        actionBar?.setDisplayShowCustomEnabled(true)
        actionBar?.setCustomView(R.layout.custom_actionbar_layout)

        // Handle clicks on ActionBar elements if needed
        val logoImageView = actionBar?.customView?.findViewById<ImageView>(R.id.logo)
        val notificationImageView = actionBar?.customView?.findViewById<ImageView>(R.id.notification_icon)
        val walletImageView = actionBar?.customView?.findViewById<ImageView>(R.id.wallet_icon)

        // Set click listeners or other actions for the icons if required

        return view
    }

    private fun getCricketGamesList(): List<CricketGame> {
        // Generating sample CricketGame objects
        val game1 = CricketGame(
            "T20 World Cup", "England", "IND",
            R.drawable.engflag, R.drawable.indflag, "MEGA", "50 Crore"
        )
        val game2 = CricketGame(
            "Another Tournament", "Team A", "Team B",
            R.drawable.engflag, R.drawable.indflag, "Some Text", "Some Amount"
        )

        // Add the generated CricketGame objects to the list
        return listOf(game1, game2)
        // You can add more CricketGame objects similarly
    }
}

