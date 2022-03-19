package com.my.first_android_app

import com.my.first_android_app.API.Article
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(private val list: ArrayList<Article>): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            with(itemView) {
                itemView.findViewById<TextView>(R.id.articleTitle).text = article.title
                itemView.findViewById<TextView>(R.id.articleContent).text = article.content
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)

        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}