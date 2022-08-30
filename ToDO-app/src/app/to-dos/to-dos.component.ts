import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Todo } from '../Todo';

@Component({
  selector: 'app-to-dos',
  templateUrl: './to-dos.component.html',
  styleUrls: ['./to-dos.component.css']
})
export class ToDosComponent implements OnInit {

  ToDos: Todo[];
  DoneTodos: Todo[];
  NumofTodos: number;
  NumofDones: number;
  newTitle: string;
  newDesc: string;

  postId: any;

  constructor(private httpClient : HttpClient) 
  {
    this.ToDos = [
      {
        num: 0,
        title: "Add todo",
        desc: "Enter Title and Description of your Todo item",
        isComplete: false
      },
    ]
    this.DoneTodos = [];
    this.NumofTodos = this.ToDos.length;
  }

  ngOnInit(): void {
  }

  DeleteItem(todo: Todo) {
    const index = this.ToDos.indexOf(todo);

    this.httpClient.post<any>('http://localhost:8080/todo/delete',
      { "id":todo.num, "title":todo.title, "desc":todo.desc, "isDone":todo.isComplete }).subscribe(
        data => {this.postId = data.id;}
      )

    this.ToDos.splice(index, 1);
  }

  AddItem() {
    if(this.newTitle && this.newDesc) {
      let item = new Todo();
      item.title = this.newTitle;
      item.desc = this.newDesc;
      item.isComplete = false;
      item.num = this.ToDos.length + 1;
      this.ToDos.push(item);
      this.newTitle = '';
      this.newDesc = '';

      this.httpClient.post<any>('http://localhost:8080/todo/add',
        { "id":item.num, "title":item.title, "desc":item.desc, "isDone":item.isComplete }).subscribe(
          data => {this.postId = data.id;}
        )

    } else {
      alert("Please Input the Fields");
    }
  }

  DoneItem(todo: Todo) {
    todo.isComplete = true;
    console.log(todo);
    this.DoneTodos.push(todo);

    this.httpClient.post<any>('http://localhost:8080/todo/complete',
      { "id":todo.num, "title":todo.title, "desc":todo.desc, "isDone":todo.isComplete }).subscribe(
        data => {this.postId = data.id;}
      )

    const index = this.ToDos.indexOf(todo);
    this.ToDos.splice(index, 1);
  }

}
