package com.miu.mdp.newsy.Pages.News
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
import com.miu.mdp.sporty.Pages.News.Model.News
import com.miu.mdp.sporty.Pages.News.NewsDialogFragment
import com.squareup.picasso.Picasso

class NewsFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rubriqueAdapter: RubriqueAdapter
    private lateinit var newsList: MutableList<News> // Make sure to initialize this list

    override fun openDialog() {
        val dialoag = NewsDialogFragment()
        dialoag.callback = this
        dialoag.show(parentFragmentManager, "Add new News")
    }

    override fun onDataReturned(data: Any) {
        newsList.add(data as News)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        recyclerView = view.findViewById(R.id.news_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
         recyclerView.layoutManager = layoutManager
        newsList = createSampleData()
        rubriqueAdapter = RubriqueAdapter(requireContext(), newsList)
        recyclerView.adapter = rubriqueAdapter
    }

    private fun createSampleData(): MutableList<News> {
        val newss = mutableListOf<News>()

        newss.add(
            News(
                "https://www.sporcle.com/blog/wp-content/uploads/2020/07/1-10.jpg",
                "Olympic Sport",
                "Every few years, the top athletes from around the world come together to flex on the rest of us. There’s just something about watching the best of the best compete that seems to draw us in. But here’s something we’ve all probably thought of at least a little bit while watching: what makes an Olympic sport in the first place? And how do Olympic sports get considered?"
            )
        )
        newss.add(
            News(
                "https://theindianface.com/cdn/shop/articles/5.jpg?v=1646659145",
                "Tennis French Open",
                "The red clay courts of Paris are synonymous with European spring and early summer, but this year Roland Garros has been moved to late September. Here’s what to expect."
            )
        )

        newss.add(
            News(
                "https://imageio.forbes.com/specials-images/imageserve/f8daa0af7e434237bdce15dd97e2cff0/0x0.jpg?format=jpg&height=900&width=1600&fit=bounds",
                "The Decline Of Football Is Real And It’s Accelerating",
                "In 2014 former Kansas City Chief Michael Oriard asked, “is football dying?” At the time, it might have seemed like a ridiculous question. After all, the previous fall, National Football League games occupied the top 34 of 35 most-watched television programs. Attendance at college football games had just hit an all-time high, reaching more than 44 million attendees, and more than 2.2 million boys from 6 years old through high school were playing the game.5"
            )
        )
        return newss
        }

    inner class RubriqueAdapter(private val context: Context, private val rubriques: List<News>) :
        RecyclerView.Adapter<RubriqueAdapter.RubriqueViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RubriqueViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_layout, parent, false)
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
            private val newsImageView: ImageView = itemView.findViewById(R.id.image_news_view)
            private val newsNameTextView: TextView = itemView.findViewById(R.id.text_news_name)
            private val descriptionTextView: TextView = itemView.findViewById(R.id.text_news_instruction)

            fun bind(rubrique: News) {
                newsNameTextView.text = rubrique.newsName
                descriptionTextView.text = rubrique.description
                Picasso.get().load(rubrique.newsUrl).into(newsImageView)
            }
        }
    }
}
