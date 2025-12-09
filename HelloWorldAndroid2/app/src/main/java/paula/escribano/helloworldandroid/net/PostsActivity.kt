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

class PostsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostsBinding
    private lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@PostsActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
