package com.sujin.mvvmsamplearchitecture.data.mapper

/**
 * Interface for model mapper.It provides helper methods that facilitate retrieving of models from other layers
 *
 * @param <E> is the model of the current layer
 * @param <D> is the model of other layer
 */
interface Mapper<E, D> {

    fun mapFromLocal(type: E): D
    fun mapToLocal(type: D): E
}