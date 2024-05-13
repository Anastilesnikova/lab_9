package com.topic3.android.reddit.screens

import androidx.compose.runtime.Composable
import com.topic3.android.reddit.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val posts: List<PostModel> by viewModel.allPosts.observeAsState(listOf())

    LazyColumn(
        modifier = Modifier.background(color = MaterialTheme.colors.secondary)) {
        items(posts) {
            if (it.type == PostType.TEXT) {
                TextPost(it)
            } else {
                ImagePost(it)
            }
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}