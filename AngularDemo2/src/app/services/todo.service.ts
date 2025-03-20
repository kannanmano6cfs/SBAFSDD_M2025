import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  
  private items: string[]=[]

  constructor() { }

  addItem(item: string){
    this.items.push(item)
    console.log(this.items);
  }

  getItem(): string[]{
    return this.items;
  }
}
