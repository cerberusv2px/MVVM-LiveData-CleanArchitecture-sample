package com.rosia.delivery.exceptions

import java.io.IOException

class FailedResponseException(val status: Int, override val message: String) : IOException(message)

class NetworkNotAvailableException : IOException()
