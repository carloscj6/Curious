package com.revosleap.curious.ui.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.gson.Gson
import com.revosleap.curious.R
import com.revosleap.curious.models.FixModel
import com.revosleap.curious.models.posts.Post
import com.revosleap.curious.ui.activities.BlogActivity
import com.revosleap.curious.ui.activities.MainActivity
import com.revosleap.curious.utilities.retrofit.VenximaApi
import com.revosleap.curious.utilities.runtime.Constants
import com.revosleap.simpleadapter.SimpleAdapter
import com.revosleap.simpleadapter.SimpleCallbacks
import kotlinx.android.synthetic.main.fragment_fixes.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentFixes : Fragment(), SimpleCallbacks,AnkoLogger {
    private var mainActivity: MainActivity? = null
    private var simpleAdapter: SimpleAdapter? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        simpleAdapter = SimpleAdapter(R.layout.fix_item, this)
        return inflater.inflate(R.layout.fragment_fixes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        getPosts()
    }

    private fun setupRecyclerView() {
        recyclerViewFixes.apply {
            adapter = simpleAdapter
            layoutManager = LinearLayoutManager(mainActivity)
            hasFixedSize()
        }
    }

    private fun getPosts(){
        val id= arguments?.getInt(Constants.CATEGORY_BUNDLE)
        val venximaUrls= VenximaApi.getUrl()
        venximaUrls.getPostsByCategory(id!!).enqueue(object : Callback<MutableList<Post>> {
            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Post>>, response: Response<MutableList<Post>>) {
                if (response.isSuccessful){
                    simpleAdapter?.addManyItems(response.body()!!.toMutableList())
                }
            }
        })
    }

    override fun bindView(view: View, item: Any, position: Int) {
        item as Post
        val title= view.findViewById<TextView>(R.id.textViewItem)
        title.text= item.title?.rendered
    }

    override fun onViewClicked(view: View, item: Any, position: Int) {
        item as Post
        val gson= Gson()
        val post= gson.toJson(item)
        mainActivity?.startActivity<BlogActivity>(Constants.POST_BUNDLE to post)
    }

    override fun onViewLongClicked(it: View?, item: Any, position: Int) {

    }
}