package com.example.todolist

data class Todo(
        val id: Int = 0,
        val todo: String = "",
        val completed: Boolean = false
)