import React, { Component } from 'react'
import UpdateCourseForm from './UpdateCourseForm/UpdateCourseForm'
import AddCourseForm from './AddCourseForm/AddCourseForm'


class CourseManagement extends Component {

  state = {
    courseSearchId: null,
    course: null,
    courseFound: false,
    addCourseActive: false,
    updateCourseActive: false
  }

  searchCourse = () => {
    fetch('http://localhost:8080/api/course?id=' + this.state.courseSearchId)
      .then(res => res.json())
      .then((data) => {
        this.setState({ course: data, courseFound: true })
        console.log(data)
      })
      .catch(console.log)
  }

  handleCourseSearchChange(event) {
    this.setState({ courseSearchId: event.target.value })
  }

  handleAddCourseActive(event) {
    this.setState({
      addCourseActive: true,
      updateCourseActive: false
    })
  }

  handleUpdateCourseActive(event) {
    this.setState({
      updateCourseActive: true,
      addCourseActive: false
    })
  }



  render() {

    const containerStyle = {
      margin: '100px'
    }

    const columnContainerStyle = {
      columnCount: '2',
      columnFill: 'auto',
      margin: 'auto'
    }

    const formDivStyle = {
      margin: '100px',
    }

    let searchForm = null;
    let addForm = null;
    let updateForm = null;

    if (this.state.addCourseActive) {
      addForm = <AddCourseForm />;
    }else {
      addForm = null;
    }

    if (this.state.updateCourseActive) {
      searchForm = (
        <div>
        <p>Enter the user id below and click search</p>
        <input type="text" name="courseId" onChange={(event) => this.handleCourseSearchChange(event)} />
        <button value="Search" onClick={(event) => this.searchCourse(event)}>Search</button>
        </div>
      )
    }else {
      searchForm = null;
    }

    if (this.state.updateCourseActive && this.state.courseFound) {
      updateForm = <UpdateCourseForm course = {this.state.course}/>
    }else {
      updateForm = null;
    }

    return (
      <div style={containerStyle}>
        <div style={columnContainerStyle}>
          <div>
          <button onClick={(event) => this.handleAddCourseActive(event)}>Add New Course</button>
          </div>
          <div>
          <button onClick={(event) => this.handleUpdateCourseActive(event)}>Update Existing Course</button>
          </div>
        </div>
        <div style={formDivStyle}>
        {searchForm}
        {addForm}
        {updateForm}
        </div>
      </div>
    )
  }
}

export default CourseManagement;