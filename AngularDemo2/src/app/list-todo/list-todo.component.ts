import { Component } from '@angular/core';
import { TodoService } from '../services/todo.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list-todo',
  imports: [FormsModule,CommonModule],
  templateUrl: './list-todo.component.html',
  styleUrl: './list-todo.component.css'
})
export class ListTodoComponent {
  localItems: string[]=[]

  constructor(private service:TodoService){
    this.localItems=this.service.getItem()
  }
}
