package com.mikelop.applicastertest.common

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
    object NetworkConnection: Failure()
    object ServerError : Failure()
    object NoResponse : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure: Failure()
}