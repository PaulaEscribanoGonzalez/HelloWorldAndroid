package paula.escribano.helloworldandroid.net

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import paula.escribano.helloworldandroid.databinding.ActivityPostsBinding
import paula.escribano.helloworldandroid.net.ApiClient
import paula.escribano.helloworldandroid.net.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import paula.escribano.helloworldandroid.R
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class PostsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostsBinding
    private lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.title_network)
        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.recyclerPosts.layoutManager = LinearLayoutManager(this)

        loadPosts()
    }

    private fun loadPosts() {
        ApiClient.apiService.getPosts().enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body() ?: emptyList()
                    adapter = PostsAdapter(posts)
                    binding.recyclerPosts.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) { Toast.makeText(this@PostsActivity, getString(R.string.error_message, t.message), Toast.LENGTH_SHORT).show() }
        })
    }
}
