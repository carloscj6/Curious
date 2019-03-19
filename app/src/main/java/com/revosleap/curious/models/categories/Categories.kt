package com.revosleap.curious.models.categories

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Category {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("count")
    @Expose
    var count: Int = 0
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("taxonomy")
    @Expose
    var taxonomy: String? = null
    @SerializedName("parent")
    @Expose
    var parent: Int = 0
    @SerializedName("meta")
    @Expose
    var meta: List<Any>? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}

class Collection {

    @SerializedName("href")
    @Expose
    var href: String? = null

}

class Cury {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("href")
    @Expose
    var href: String? = null
    @SerializedName("templated")
    @Expose
    var isTemplated: Boolean = false

}

class Links {

    @SerializedName("self")
    @Expose
    var self: List<Self>? = null
    @SerializedName("collection")
    @Expose
    var collection: List<Collection>? = null
    @SerializedName("about")
    @Expose
    var about: List<About>? = null
    @SerializedName("wp:post_type")
    @Expose
    var wpPostType: List<WpPostType>? = null
    @SerializedName("curies")
    @Expose
    var curies: List<Cury>? = null

}

class About {

    @SerializedName("href")
    @Expose
    var href: String? = null

}

class Self {

    @SerializedName("href")
    @Expose
    var href: String? = null

}


class WpPostType {

    @SerializedName("href")
    @Expose
    var href: String? = null

}