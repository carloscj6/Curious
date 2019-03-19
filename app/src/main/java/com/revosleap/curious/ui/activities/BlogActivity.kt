package com.revosleap.curious.ui.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebSettings
import com.google.gson.reflect.TypeToken
import com.revosleap.curious.R
import com.revosleap.curious.models.posts.Post
import com.revosleap.curious.utilities.runtime.Constants
import kotlinx.android.synthetic.main.activity_blog.*
import kotlinx.android.synthetic.main.content_blog.*
import java.lang.reflect.Type


class BlogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Saved!!", Snackbar.LENGTH_LONG)
                .setAction("Undo", null).show()
        }
        setUpViews()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUpViews() {
        val type: Type = object : TypeToken<Post>() {}.type
        val postBundle = intent?.extras!!.getString(Constants.POST_BUNDLE)
        val post = Constants.GSON.fromJson<Post>(postBundle, type)
        val data = "<div>${post.content?.rendered}</div>"
        val htmlData = "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />" + getHtmlData(data)
        webView.loadDataWithBaseURL("file:///android_asset/style.css", htmlData, "text/html", "UTF-8", null)
        webView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
        supportActionBar?.title = post.title?.rendered
    }

    private fun getHtmlData(bodyHTML: String): String {
        val head = "<head><style>img{max-width: 100%; width:auto; height: auto;}</style></head>"
        return "<html>$head<body>$bodyHTML</body></html>"
    }
}
