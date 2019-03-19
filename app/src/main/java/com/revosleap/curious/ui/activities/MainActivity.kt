package com.revosleap.curious.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.revosleap.curious.R
import com.revosleap.curious.models.categories.Category
import com.revosleap.curious.ui.fragments.FragmentFixes
import com.revosleap.curious.utilities.retrofit.VenximaApi
import com.revosleap.curious.utilities.runtime.Constants
import com.revosleap.simpleadapter.SimpleAdapter
import com.revosleap.simpleadapter.SimpleCallbacks
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import org.jetbrains.anko.warn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SimpleCallbacks, AnkoLogger {
    private var simpleAdapter: SimpleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        simpleAdapter = SimpleAdapter(R.layout.home_item, this)
        setUpRecyclerView()
        getCategories()

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            recyclerViewHome.visibility = View.VISIBLE
        } else super.onBackPressed()
    }

    private fun setUpRecyclerView() {

        recyclerViewHome.apply {
            adapter = simpleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()

        }

    }

    private fun getCategories() {
        val venximaUrls = VenximaApi.getUrl()
        venximaUrls.getCategories().enqueue(object : Callback<MutableList<Category>> {
            override fun onFailure(call: Call<MutableList<Category>>, t: Throwable) {
                warn(t)
            }

            override fun onResponse(call: Call<MutableList<Category>>, response: Response<MutableList<Category>>) {
                if (response.isSuccessful) {
                    simpleAdapter?.addManyItems(response.body()!!.toMutableList())
                } else warn(response.message())
            }
        })

    }

    override fun bindView(view: View, item: Any, position: Int) {
        item as Category
        val title = view.findViewById<TextView>(R.id.textViewItemTitle)
        val info = view.findViewById<TextView>(R.id.textViewShortInfo)
        val picture = view.findViewById<CircleImageView>(R.id.civ_item)

        title.text = item.name
        info.text = item.description

    }

    override fun onViewClicked(view: View, item: Any, position: Int) {
        item as Category
        val fixes=FragmentFixes()
        val fragBundle= Bundle()
        fragBundle.putInt(Constants.CATEGORY_BUNDLE,item.id)
        fixes.arguments= fragBundle
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentHolder, fixes)
            .addToBackStack(null)
            .commit()
        recyclerViewHome.visibility = View.GONE

    }

    override fun onViewLongClicked(it: View?, item: Any, position: Int) {

    }
}
