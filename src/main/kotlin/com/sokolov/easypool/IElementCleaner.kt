package com.sokolov.easypool

interface IElementCleaner<E> {
    fun clear(e: E): E
}