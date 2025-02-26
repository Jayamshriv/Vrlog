package com.example.vrlog.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vrlog.core.utils.Resource
import com.example.vrlog.domain.usecase.BlogsPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogsPostViewModel @Inject constructor(
    private val useCase: BlogsPostUseCase
) : ViewModel(){

    private val TAG ="BlogsPostViewModel"

    private val _blogPosts = mutableStateOf(BlogsPostState())
    val blogPosts : State<BlogsPostState> =  _blogPosts

    fun getBlogsPost(perPage: Int, page: Int) {
        viewModelScope.launch {
            useCase.getBlogsPost(perPage, page).collect { response ->
                when (response) {
                    is Resource.Success -> {

                        _blogPosts.value = _blogPosts.value.copy(
                            isLoading = false,
                            post = response.data ?: emptyList(),
                            error = ""
                        )

                    }

                    is Resource.Error -> {

                        _blogPosts.value = _blogPosts.value.copy(
                            isLoading = false,
                            error = response.message ?: "  Error"
                        )
                    }
                    is Resource.Loading -> {
                        _blogPosts.value = _blogPosts.value.copy(
                            isLoading = true
                        )


                    }
                }
            }
        }
    }


}