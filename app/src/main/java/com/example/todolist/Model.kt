package com.example.todolist

import androidx.compose.runtime.internal.composableLambda
import kotlinx.coroutines.delay

// データのやり取りや、それに関するビジネスロジック
// データのやり取りが必要ならRepositoryとかに切り出しても良い
class Model {
    suspend fun loadTodoData(): List<Todo>{
        delay(1000)
        return FakeData
    }
}

val FakeData = listOf(
    Todo(
        id = 1,
        todo = "タスク１",
        completed = false
    ),
    Todo(
        id = 2,
        todo = "タスク2",
        completed = false
    ),
    Todo(
        id = 3,
        todo = "タスク3",
        completed = false
    ),

)