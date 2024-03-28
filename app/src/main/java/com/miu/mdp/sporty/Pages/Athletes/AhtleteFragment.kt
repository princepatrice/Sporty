package com.miu.mdp.athletey.Pages.Athletes
import android.content.Context
import com.miu.mdp.sporty.R





import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.miu.mdp.sporty.Adapters.BaseFragment
import com.miu.mdp.sporty.Pages.Athletes.Model.Athlete
import com.miu.mdp.sporty.Pages.Athletes.AthleteDialogFragment
import com.squareup.picasso.Picasso

class AthleteFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rubriqueAdapter: RubriqueAdapter
    private lateinit var athleteList: MutableList<Athlete> // Make sure to initialize this list

    override fun openDialog() {
        val dialoag = AthleteDialogFragment()
        dialoag.callback = this
        dialoag.show(parentFragmentManager, "Add new Athlete")
    }

    override fun onDataReturned(data: Any) {
        athleteList.add(data as Athlete)
        rubriqueAdapter.notifyDataSetChanged()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_athlete, container, false)
        recyclerView = view.findViewById(R.id.athlete_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
         recyclerView.layoutManager = layoutManager
        athleteList = createSampleData()
        rubriqueAdapter = RubriqueAdapter(requireContext(), athleteList)
        recyclerView.adapter = rubriqueAdapter
    }

    private fun createSampleData(): MutableList<Athlete> {
        val athletes = mutableListOf<Athlete>()
        athletes.add(
        Athlete(
            "Usain Bolt",
            "Athletics",
            "Bolt is widely considered the greatest sprinter of all time. He has won numerous Olympic and World Championship titles in the 100m and 200m events.",
            "Jamaica",
            "Gold",
            "Usain Bolt holds the world record for the fastest time in both the 100m and 200m sprint events."
        )
    )

    athletes.add(
        Athlete(
            "Michael Phelps",
            "Swimming",
            "Phelps is the most decorated Olympian of all time, winning a total of 28 Olympic medals, including 23 gold medals.",
            "United States",
            "Gold",
            "Michael Phelps' dominance in the pool has solidified his status as one of the greatest athletes in Olympic history."
        )
    )

    athletes.add(
        Athlete(
            "Simone Biles",
            "Gymnastics",
            "Biles is considered one of the greatest gymnasts of all time. She has won numerous Olympic and World Championship titles.",
            "United States",
            "Gold",
            "Simone Biles' gravity-defying routines have redefined what is possible in gymnastics."
        )
    )

    athletes.add(
        Athlete(
            "Serena Williams",
            "Tennis",
            "Williams is one of the most successful tennis players of all time, with multiple Grand Slam titles to her name.",
            "United States",
            "Gold",
            "Serena Williams' powerful and dominant style of play has made her a legend in the world of tennis."
        )
    )

    athletes.add(
        Athlete(
            "Katie Ledecky",
            "Swimming",
            "Ledecky is a dominant force in distance swimming, holding multiple world records and winning numerous Olympic gold medals.",
            "United States",
            "Gold",
            "Katie Ledecky's incredible endurance and technique make her nearly unbeatable in long-distance swimming events."
        )
    )

    athletes.add(
        Athlete(
            "Nadia Comăneci",
            "Gymnastics",
            "Comăneci is a Romanian gymnast who achieved the first perfect score of 10.0 in Olympic history at the 1976 Montreal Olympics.",
            "Romania",
            "Gold",
            "Nadia Comăneci's perfect 10 performances made her an icon in the world of gymnastics."
        )
    )

    athletes.add(
        Athlete(
            "Jesse Owens",
            "Athletics",
            "Owens was a track and field athlete who won four gold medals at the 1936 Berlin Olympics, disproving Nazi theories of Aryan supremacy.",
            "United States",
            "Gold",
            "Jesse Owens' historic victories at the 1936 Olympics were a powerful statement against racism and discrimination."
        )
    )

    athletes.add(
        Athlete(
            "Nadia Comăneci",
            "Gymnastics",
            "Comăneci is a Romanian gymnast who achieved the first perfect score of 10.0 in Olympic history at the 1976 Montreal Olympics.",
            "Romania",
            "Gold",
            "Nadia Comăneci's perfect 10 performances made her an icon in the world of gymnastics."
        )
    )
        return athletes
        }

    inner class RubriqueAdapter(private val context: Context, private val rubriques: List<Athlete>) :
        RecyclerView.Adapter<RubriqueAdapter.RubriqueViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RubriqueViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_athlete_layout, parent, false)
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
            private val athleteNameTextView: TextView = itemView.findViewById(R.id.text_athlete_name)
            private val athleteSportTextView: TextView = itemView.findViewById(R.id.text_athlete_sport)
            private val athleteCountryTextView: TextView = itemView.findViewById(R.id.text_athlete_country)
            private val athletePerformanceTextView: TextView = itemView.findViewById(R.id.text_athlete_performance)
            private val athleteMedalsNameView: TextView = itemView.findViewById(R.id.text_athlete_medals)
            private val athleteFactsTextView: TextView = itemView.findViewById(R.id.text_athlete_facts)

            fun bind(rubrique: Athlete) {
                athleteNameTextView.text = rubrique.name
                athleteCountryTextView.text = rubrique.country
                athleteSportTextView.text = rubrique.sport
                athletePerformanceTextView.text = rubrique.performance
                athleteMedalsNameView.text = rubrique.medal
                athleteFactsTextView.text = rubrique.facts

            }
        }
    }
}
