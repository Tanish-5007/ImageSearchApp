package com.example.imagesearchapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.imagesearchapp.api.UnsplashApi
import com.example.imagesearchapp.data.model.UnsplashPhoto
import retrofit2.HttpException
import java.io.IOException

class UnsplashPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String
): PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {

        try {

            val position = params.key ?: 1
            val response = unsplashApi.searchPhoto(query, position, params.loadSize)
            val photos = response.results

            return LoadResult.Page(
                data = photos,
                prevKey = if(position == 1) null else position - 1, // Only paging forward.
                nextKey = if(photos.isEmpty()) null else position + 1
            )

        }
        catch (e: IOException){
            return LoadResult.Error(e)
        }
        catch (e: HttpException){
            return LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashPhoto>): Int? {
        TODO("Not yet implemented")
    }

}