import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { of } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[] =[
    {id:1, name:'Angular', description: 'Intro to Angular', instructor:'Kannan'},
    {id:2, name:'Advanced Angular', description: 'Intro to Angular', instructor:'Anil Kumar'},
    {id:3, name:'Angular with Spring Boot', description: 'Intro to Angular', instructor:'Suraj'},
    {id:4, name:'Angular with .net', description: 'Intro to Angular', instructor:'kishor'}
  ];
  constructor() { }

  getCourses(){
    return of(this.courses);
  }
}
