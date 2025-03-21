import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ListcourseComponent } from './listcourse/listcourse.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ListcourseComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'demoAng4';
}
