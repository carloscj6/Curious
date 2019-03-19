package com.revosleap.curious.models.posts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostsItems{
    var posts:MutableList<Post>?=null
}

class About {

    @SerializedName("href")
    @Expose
    var href: String? = null

}

class Author {

    @SerializedName("embeddable")
    @Expose
    var isEmbeddable: Boolean = false
    @SerializedName("href")
    @Expose
    var href: String? = null

}

class Collection {

    @SerializedName("href")
    @Expose
    var href: String? = null

}

class Content {

    @SerializedName("rendered")
    @Expose
    var rendered: String? = null
    @SerializedName("protected")
    @Expose
    var isProtected: Boolean = false

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

class Excerpt {

    @SerializedName("rendered")
    @Expose
    var rendered: String? = null
    @SerializedName("protected")
    @Expose
    var isProtected: Boolean = false

}

class Guid {

    @SerializedName("rendered")
    @Expose
    var rendered: String? = null

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
    @SerializedName("author")
    @Expose
    var author: List<Author>? = null
    @SerializedName("replies")
    @Expose
    var replies: List<Reply>? = null
    @SerializedName("version-history")
    @Expose
    var versionHistory: List<VersionHistory>? = null
    @SerializedName("predecessor-version")
    @Expose
    var predecessorVersion: List<PredecessorVersion>? = null
    @SerializedName("wp:featuredmedia")
    @Expose
    var wpFeaturedmedia: List<WpFeaturedmedium>? = null
    @SerializedName("wp:attachment")
    @Expose
    var wpAttachment: List<WpAttachment>? = null
    @SerializedName("wp:term")
    @Expose
    var wpTerm: List<WpTerm>? = null
    @SerializedName("curies")
    @Expose
    var curies: List<Cury>? = null

}

class Meta {

    @SerializedName("sharing_disabled")
    @Expose
    var isSharingDisabled: Boolean = false
    @SerializedName("spay_email")
    @Expose
    var spayEmail: String? = null
    @SerializedName("jetpack_publicize_message")
    @Expose
    var jetpackPublicizeMessage: String? = null

}

class Post {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("date_gmt")
    @Expose
    var dateGmt: String? = null
    @SerializedName("guid")
    @Expose
    var guid: Guid? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null
    @SerializedName("modified_gmt")
    @Expose
    var modifiedGmt: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("title")
    @Expose
    var title: Title? = null
    @SerializedName("content")
    @Expose
    var content: Content? = null
    @SerializedName("excerpt")
    @Expose
    var excerpt: Excerpt? = null
    @SerializedName("author")
    @Expose
    var author: Int = 0
    @SerializedName("featured_media")
    @Expose
    var featuredMedia: Int = 0
    @SerializedName("comment_status")
    @Expose
    var commentStatus: String? = null
    @SerializedName("ping_status")
    @Expose
    var pingStatus: String? = null
    @SerializedName("sticky")
    @Expose
    var isSticky: Boolean = false
    @SerializedName("template")
    @Expose
    var template: String? = null
    @SerializedName("format")
    @Expose
    var format: String? = null
    @SerializedName("meta")
    @Expose
    var meta: Meta? = null
    @SerializedName("categories")
    @Expose
    var categories: List<Int>? = null
    @SerializedName("tags")
    @Expose
    var tags: List<Int>? = null
    @SerializedName("jetpack_featured_media_url")
    @Expose
    var jetpackFeaturedMediaUrl: String? = null
    @SerializedName("jetpack_publicize_connections")
    @Expose
    var jetpackPublicizeConnections: List<Any>? = null
    @SerializedName("jetpack_shortlink")
    @Expose
    var jetpackShortlink: String? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}

class PredecessorVersion {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("href")
    @Expose
    var href: String? = null

}

class Reply {

    @SerializedName("embeddable")
    @Expose
    var isEmbeddable: Boolean = false
    @SerializedName("href")
    @Expose
    var href: String? = null

}

class Self {

    @SerializedName("href")
    @Expose
    var href: String? = null

}

class Title {

    @SerializedName("rendered")
    @Expose
    var rendered: String? = null

}

class VersionHistory {

    @SerializedName("count")
    @Expose
    var count: Int = 0
    @SerializedName("href")
    @Expose
    var href: String? = null

}

class WpAttachment {

    @SerializedName("href")
    @Expose
    var href: String? = null

}

class WpFeaturedmedium {

    @SerializedName("embeddable")
    @Expose
    var isEmbeddable: Boolean = false
    @SerializedName("href")
    @Expose
    var href: String? = null

}

class WpTerm {

    @SerializedName("taxonomy")
    @Expose
    var taxonomy: String? = null
    @SerializedName("embeddable")
    @Expose
    var isEmbeddable: Boolean = false
    @SerializedName("href")
    @Expose
    var href: String? = null

}