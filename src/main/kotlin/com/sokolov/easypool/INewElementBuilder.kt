package com.sokolov.easypool

interface INewElementBuilder<E> {

    fun number(n: Int): INewElementBuilder<E>

    fun build(): E
}