// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_14c.api.errors

import com.configure_me_yolken_test_14c.api.core.JsonValue
import com.configure_me_yolken_test_14c.api.core.http.Headers

abstract class YolkenTest14cServiceException
protected constructor(message: String, cause: Throwable? = null) :
    YolkenTest14cException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
