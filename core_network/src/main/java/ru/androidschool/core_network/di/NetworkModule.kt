package ru.androidschool.core_network.di
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    @NetworkScope
    fun provideClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @Provides
    @NetworkScope
    fun provideMoviesService(client: OkHttpClient, url: String): MovieApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(MovieApiInterface::class.java)
    }

    @Provides
    fun provideBaseUrl() = "https://api.themoviedb.org/3/"
}