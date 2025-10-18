package com.example.todolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.todolist.ui.theme.TodoListTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun TodoScreen(modifier: Modifier){
    val vm = TodoViewModel()
    val uiState by vm.uiState.collectAsStateWithLifecycle()
    Column{
        uiState.map{
            TodoItem(it, vm::stateUpdate)
        }
    }
}

@Composable
fun TodoItem(todo: Todo, onChange:(Int)->Unit){
    Row{
        Text(todo.todo)
        Checkbox(
            checked = todo.completed,
            onCheckedChange = {onChange(todo.id)}
        )
    }

}

@Preview
@Composable
fun TodoItemPreview(){
    TodoListTheme {
        TodoItem(Todo(
            todo = "test",
        ),{})
    }
}