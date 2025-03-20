import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-main',
  imports: [FormsModule, CommonModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  title: string = "Welcome to the Training and Professional Services"
  num1: number = 456
  num2: number = 545
  pic1: string = "images\\pic1.jpg"
  altText: string = "Image unavailble Now..."
  link: string = "https://www.google.com"
  text: string = ""
  message: string = "Angular Technology"
  flag: boolean = true

  showCourses()
  {
    this.flag=true
  }

  hideCourses()
  {
    this.flag=false
  }

  courses: string[] = [
    "VMware courses",
    "Azure and AWs Courses",
    "Networking and security Courses",
    "Full Stack Development Courses"
  ]
 
  height: string = "300px"
  changeHeight(){
    this.height="400px"
  }

  className: string = "class1"
  changeClass(){
    this.className="class2"
  }

  showText(){
    this.text="Hello All!! Welcomes you..."
  }
}
