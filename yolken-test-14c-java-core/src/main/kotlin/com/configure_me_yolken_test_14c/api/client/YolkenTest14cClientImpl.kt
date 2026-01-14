// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_14c.api.client

import com.configure_me_yolken_test_14c.api.core.ClientOptions
import com.configure_me_yolken_test_14c.api.core.getPackageVersion
import com.configure_me_yolken_test_14c.api.services.blocking.PetService
import com.configure_me_yolken_test_14c.api.services.blocking.PetServiceImpl
import com.configure_me_yolken_test_14c.api.services.blocking.StoreService
import com.configure_me_yolken_test_14c.api.services.blocking.StoreServiceImpl
import com.configure_me_yolken_test_14c.api.services.blocking.UserService
import com.configure_me_yolken_test_14c.api.services.blocking.UserServiceImpl
import java.util.function.Consumer

class YolkenTest14cClientImpl(private val clientOptions: ClientOptions) : YolkenTest14cClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: YolkenTest14cClientAsync by lazy {
        YolkenTest14cClientAsyncImpl(clientOptions)
    }

    private val withRawResponse: YolkenTest14cClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pets: PetService by lazy { PetServiceImpl(clientOptionsWithUserAgent) }

    private val store: StoreService by lazy { StoreServiceImpl(clientOptionsWithUserAgent) }

    private val users: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): YolkenTest14cClientAsync = async

    override fun withRawResponse(): YolkenTest14cClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): YolkenTest14cClient =
        YolkenTest14cClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun pets(): PetService = pets

    override fun store(): StoreService = store

    override fun users(): UserService = users

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        YolkenTest14cClient.WithRawResponse {

        private val pets: PetService.WithRawResponse by lazy {
            PetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val store: StoreService.WithRawResponse by lazy {
            StoreServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): YolkenTest14cClient.WithRawResponse =
            YolkenTest14cClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun pets(): PetService.WithRawResponse = pets

        override fun store(): StoreService.WithRawResponse = store

        override fun users(): UserService.WithRawResponse = users
    }
}
