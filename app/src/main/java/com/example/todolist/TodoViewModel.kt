package com.example.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// Modelから受けとった値をViewに渡すために整形する
// Viewに渡すコールバックも必要なら作成する
class TodoViewModel: ViewModel() {
    private val TodoModel = Model()
    private val _UiState = MutableStateFlow(FakeData)
    val uiState: StateFlow<List<Todo>> = _UiState.asStateFlow()
//    init {
//        viewModelScope.launch {
//            _UiState.value = TodoModel.loadTodoData()
//        }
//    }


    fun stateUpdate(id: Int){
        // MutableStateFlowのupdateでスレッドセーフに実行できる
        _UiState.update { currentState ->
            currentState.map{ todo ->
                if(todo.id == id){
                    todo.copy(completed = !todo.completed)
                }else{
                    todo
                }
            }
        }
    }
}