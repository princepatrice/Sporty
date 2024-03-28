package com.miu.mdp.historicalActivityy.Pages.HistoricalActivity


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.sporty.Adapters.BaseFragment
import com.miu.mdp.sporty.Pages.HistoricalActivity.HistoricalActivityDialogFragment
import com.miu.mdp.sporty.Pages.HistoricalActivitys.Model.HistoricalActivity
import com.miu.mdp.sporty.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoricalActivityFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rubriqueAdapter: RubriqueAdapter
    private lateinit var historicalActivityList: MutableList<HistoricalActivity> // Make sure to initialize this list

    override fun openDialog() {
        val dialoag = HistoricalActivityDialogFragment()
        dialoag.callback = this
        dialoag.show(parentFragmentManager, "Add new HistoricalActivity")
    }

    override fun onDataReturned(data: Any) {
        historicalActivityList.add(data as HistoricalActivity)
        rubriqueAdapter.notifyDataSetChanged()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_historical_activity, container, false)
        recyclerView = view.findViewById(R.id.historical_activity_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
         recyclerView.layoutManager = layoutManager
        historicalActivityList = createSampleData()
        rubriqueAdapter = RubriqueAdapter(requireContext(), historicalActivityList)
        recyclerView.adapter = rubriqueAdapter
    }

    private fun createSampleData(): MutableList<HistoricalActivity> {
        val historicalActivitys = mutableListOf<HistoricalActivity>()
       historicalActivitys.add(
            HistoricalActivity(
                name = "Birthday Party",
                description = "Celebrate John's birthday with friends and family.",
                date = "2024-04-10"
            ))
        historicalActivitys.add(
            HistoricalActivity(
                name = "Conference",
                description = "Attend the annual tech conference.",
                date = "2024-05-15"
            ))
        historicalActivitys.add(
            HistoricalActivity(
                name = "Meeting with Client",
                description = "Discuss project requirements with the client.",
                date = "2024-04-20"
            ))
        historicalActivitys.add(
            HistoricalActivity(
                name = "Team Building Activity",
                description = "Engage in team-building exercises.",
                date = "2024-04-30"
            ))
        historicalActivitys.add(
            HistoricalActivity(
                name = "Product Launch",
                description = "Launch the new product line.",
                date = "2024-06-01"
            ))
        return historicalActivitys
        }

    inner class RubriqueAdapter(private val context: Context, private val rubriques: List<HistoricalActivity>) :
        RecyclerView.Adapter<RubriqueAdapter.RubriqueViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RubriqueViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_historical_activity_layout, parent, false)
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
            private val historicalActivityNameTextView: TextView = itemView.findViewById(R.id.text_historical_activity_name)
            private val historicalActivityDescrptionTextView: TextView = itemView.findViewById(R.id.text_historical_activity_description)
            private val historicalActivityDateTextView: TextView = itemView.findViewById(R.id.text_historical_activity_date)
        
            fun bind(rubrique: HistoricalActivity) {
                val formatter = SimpleDateFormat("MMMM, dd yyyy", Locale.getDefault())
                val formattedDate: String = formatter.format(Date(rubrique.date))
                historicalActivityNameTextView.text = rubrique.name
                historicalActivityDateTextView.text = formattedDate
                historicalActivityDescrptionTextView.text = rubrique.description
            }
        }
    }
}
