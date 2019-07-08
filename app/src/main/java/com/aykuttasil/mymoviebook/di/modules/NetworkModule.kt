package com.aykuttasil.mymoviebook.di.modules

import com.aykuttasil.mymoviebook.BuildConfig
import com.aykuttasil.mymoviebook.util.LiveDataCallAdapterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class NetworkModule {

    private fun getBaseUrl() = "https://api.github.com"

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()

                val request = original.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .method(original.method(), original.body())
                    .build()

                return@addInterceptor chain.proceed(request)
            }
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        return httpClientBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message ->
            Timber.d(message)
        }.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

}
