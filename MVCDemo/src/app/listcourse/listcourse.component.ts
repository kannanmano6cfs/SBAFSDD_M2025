import { Component, OnInit } from '@angular/core';
import { Course } from '../models/course';
import { CourseService } from '../services/course.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listcourse',
  imports: [CommonModule],
  templateUrl: './listcourse.component.html',
  styleUrl: './listcourse.component.css'
})
export class ListcourseComponent implements OnInit {
  courses: Course[] =[];

  constructor(private courseService: CourseService){}

  ngOnInit(): void {
      this.courseService.getCourses().subscribe((courses) =>{
        this.courses = courses;
      });
  }

}
