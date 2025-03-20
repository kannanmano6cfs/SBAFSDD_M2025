import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TodoService } from '../services/todo.service';

@Component({
  selector: 'app-add-todo',
  imports: [FormsModule],
  templateUrl: './add-todo.component.html',
  styleUrl: './add-todo.component.css'
})
export class AddTodoComponent {
  
  constructor(private service:TodoService){}

  onSubmit(data:any){
    console.log(data.value.item)
    this.service.addItem(data.value.item)
    data.reset()
  }
}
