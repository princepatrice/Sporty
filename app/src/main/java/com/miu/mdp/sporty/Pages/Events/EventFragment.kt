package com.miu.mdp.eventy.Pages.Events


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.sporty.Adapters.BaseFragment
import com.miu.mdp.sporty.Pages.Events.EventDialogFragment
import com.miu.mdp.sporty.Pages.Events.Model.Event
import com.miu.mdp.sporty.R

class EventFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rubriqueAdapter: RubriqueAdapter
    private lateinit var eventList: MutableList<Event> // Make sure to initialize this list

    override fun openDialog() {
        val dialoag = EventDialogFragment()
        dialoag.callback = this
        dialoag.show(parentFragmentManager, "Add new Event")
    }

    override fun onDataReturned(data: Any) {
        eventList.add(data as Event)
        rubriqueAdapter.notifyDataSetChanged()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        recyclerView = view.findViewById(R.id.event_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
         recyclerView.layoutManager = layoutManager
        eventList = createSampleData()
        rubriqueAdapter = RubriqueAdapter(requireContext(), eventList)
        recyclerView.adapter = rubriqueAdapter
    }

    private fun createSampleData(): MutableList<Event> {
        val events = mutableListOf<Event>()
        events.add(
            Event(
                "Birthday Party",
                "Celebrate John's birthday with friends and family.",
                "Mar, 5 2024"
            )
        )
        events.add(
            Event(
                "Conference",
                "Attend the annual tech conference.",
                "Apr, 10 2024"
            )
        )
        events.add(
            Event(
                "Meeting with Client",
                "Discuss project requirements with the client.",
                "Apr, 15 2024"
            )
        )
        events.add(
            Event(
                "Team Building Activity",
                "Engage in team-building exercises.",
                "Apr, 20 2024"
            )
        )
        events.add(
            Event(
                "Product Launch",
                "Launch the new product line.",
                "May, 1 2024"
            )
        )

        return events
        }

    inner class RubriqueAdapter(private val context: Context, private val rubriques: List<Event>) :
        RecyclerView.Adapter<RubriqueAdapter.RubriqueViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RubriqueViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event_layout, parent, false)
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
            private val eventNameTextView: TextView = itemView.findViewById(R.id.text_event_name)
            private val eventDescrptionTextView: TextView = itemView.findViewById(R.id.text_event_description)
            private val eventDateTextView: TextView = itemView.findViewById(R.id.text_event_date)
        
            fun bind(rubrique: Event) {
                eventNameTextView.text = rubrique.name
                eventDateTextView.text = rubrique.date
                eventDescrptionTextView.text = rubrique.description
            }
        }
    }
}
