package com.miu.mdp.sporty.Pages.Sports
import android.content.Context
import com.miu.mdp.sporty.R





import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.miu.mdp.sporty.Adapters.BaseFragment
import com.miu.mdp.sporty.Pages.Sports.Model.Sport

class SportsFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rubriqueAdapter: RubriqueAdapter
    private lateinit var sportList: MutableList<Sport> // Make sure to initialize this list

    override fun openDialog() {
        val dialoag = SportDialogFragment()
        dialoag.callback = this
        dialoag.show(parentFragmentManager, "Add Sport")
    }

    override fun onDataReturned(data: Any) {
        sportList.add(data as Sport)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sports, container, false)
        recyclerView = view.findViewById(R.id.sport_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
         recyclerView.layoutManager = layoutManager
        sportList = createSampleData()
        rubriqueAdapter = RubriqueAdapter(requireContext(), sportList)
        recyclerView.adapter = rubriqueAdapter
    }

    private fun createSampleData(): MutableList<Sport> {
        val sports = mutableListOf<Sport>()

        sports.add(Sport("Measure", "Track & Field", "In track and field, athletes compete in various events such as sprinting, jumping, throwing, and distance running. You win by achieving the fastest time in sprinting events, the longest distance or height in jumping events, or by throwing the farthest in throwing events."))
        sports.add(Sport("Measure", "Car Racing", "Car racing involves competing in races using specially designed vehicles. Whether it's Formula 1, NASCAR, or rally racing, the objective is to complete the race distance in the shortest time possible. Drivers must navigate through turns, straights, and varying track conditions to emerge victorious."))
        sports.add(Sport("Precision", "Pistol Shooting", "Pistol shooting requires exceptional precision and focus. Competitors aim to hit targets with handguns from various distances. The goal is to achieve the highest score by hitting the center of the target with each shot."))
        sports.add(Sport("Precision", "Archery", "Archery is an ancient sport that demands immense concentration and control. Participants use bows to shoot arrows at targets set at different distances. The winner is determined by accuracy, with points awarded based on the proximity of arrow placements to the center of the target."))
        sports.add(Sport("Combat", "Judo", "Judo is a martial art and combat sport that emphasizes grappling techniques and throws. Competitors aim to score points by executing throws or immobilizing their opponents on the ground. The objective is to demonstrate superior technique and control over the opponent."))
        sports.add(Sport("Play", "Basketball", "Basketball is a fast-paced team sport played on a rectangular court. Teams aim to score points by shooting the ball through the opponent's hoop while preventing the opposing team from doing the same. It requires teamwork, skillful ball-handling, and strategic play."))
        sports.add(Sport("Play", "Football", "Football, also known as soccer in some countries, is the world's most popular sport. Players use their feet to kick a ball and score goals by getting it into the opponent's net. It's a game of strategy, skill, and teamwork, played by millions around the globe."))
        sports.add(Sport("Play", "Baseball", "Baseball is a bat-and-ball game played between two teams of nine players each. The objective is to score runs by hitting a thrown ball and running around four bases arranged in a diamond shape. It's a sport rich in tradition and strategy, with a long history in American culture."))
        sports.add(Sport("Play", "Rugby", "Rugby is a high-energy team sport played with an oval-shaped ball. Players aim to score points by carrying, passing, or kicking the ball into the opponent's goal area. It's a physical and dynamic game that requires strength, speed, and tactical prowess."))
        return sports
    }

    inner class RubriqueAdapter(private val context: Context, private val rubriques: List<Sport>) :
        RecyclerView.Adapter<RubriqueAdapter.RubriqueViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RubriqueViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport_layout, parent, false)
            return RubriqueViewHolder(view)
        }

        override fun onBindViewHolder(holder: RubriqueViewHolder, position: Int) {
            val rubrique = rubriques[position]
            holder.bind(rubrique)
        }

        override fun getItemCount(): Int {
            return rubriques.size
        }

        inner class RubriqueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val sportTypeTextView: TextView = itemView.findViewById(R.id.text_sport_type)
            private val sportNameTextView: TextView = itemView.findViewById(R.id.text_sport_name)
            private val instructionTextView: TextView = itemView.findViewById(R.id.text_instruction)

            fun bind(rubrique: Sport) {
                sportTypeTextView.text = rubrique.sportType
                sportNameTextView.text = rubrique.sportName
                instructionTextView.text = rubrique.instruction
            }
        }
    }
}
