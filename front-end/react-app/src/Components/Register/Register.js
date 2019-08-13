import React, { Component } from 'react'
import User from './User/User'
import Course from './Course/Course'

class Register extends Component {

  state = {
    userSearchId: null,
    user: null,
    userFound: false,
    courseSearchId: null,
    course: null,
    courseFound: false
  }

  searchUser = () => {
    fetch('http://localhost:8080/api/user?id=' + this.state.userSearchId)
      .then(res => res.json())
      .then((data) => {
        this.setState({ user: data, userFound: true })
      })
      .catch(console.log)
  }

  searchCourse = () => {
    fetch('http://localhost:8080/api/course?id=' + this.state.courseSearchId)
      .then(res => res.json())
      .then((data) => {
        this.setState({ course: data, courseFound: true })
      })
      .catch(console.log)
  }

  handleUserSearchChange(event) {
    this.setState({ userSearchId: event.target.value })
  }

  handleCourseSearchChange(event) {
    this.setState({ courseSearchId: event.target.value })
  }

  handleRegistration = () => {
    fetch('http://localhost:8080/api/registration/register?courseId=' + this.state.course.id + '&userId=' + this.state.user.id, {
      method: 'POST',
    })
  }

  render() {

    let theUser = null;

    if (this.state.userFound) {
      console.log(this.state.user)
      theUser = (<User userData={this.state.user} />);
    }

    let theCourse = null;

    if (this.state.courseFound) {
      console.log(this.state.course)
      theCourse = (<Course courseData={this.state.course} />);
    }

    const columnContainerStyle = {
      columnCount: '2',
      columnFill: 'auto',
      margin: 'auto'
    }

    const containerStyle = {
      margin: '100px'
    }

    const registerButtonStyle = {
      marginLeft: 'auto',
      marginRight: 'auto'
    }

    return (
      <div style={containerStyle}>
        <div style={columnContainerStyle}>
          <div>
            <p>Enter the user id below and click search</p>
            <input type="text" name="userId" onChange={(event) => this.handleUserSearchChange(event)} />
            <button value="Search" onClick={(event) => this.searchUser(event)}>Search</button>
            <br />
            <br />
          </div>
          <div>
            <p>Enter the course id below and click search</p>
            <input type="text" name="courseId" onChange={(event) => this.handleCourseSearchChange(event)} />
            <button value="Search" onClick={(event) => this.searchCourse(event)}>Search</button>
            <br />
            <br />
          </div>
        </div>
        <div style={columnContainerStyle}>
          <div>
            <p>Selected User</p>
            {theUser}
          </div>
          <div>
            <p>Selected Course</p>
            {theCourse}
          </div>
        </div>
        <button style={registerButtonStyle} value="Register" onClick={(event) => this.handleRegistration(event)}>Register</button>
      </div>

    )
  }
}

export default Register;
