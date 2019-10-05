import React, { Component } from 'react';

/*
This is the AddCourseForm component that is part of the CourseManagement component.

Loads an empty course form and sets the state when the fields change in value.

After filling out the fields a user will press the "Add New Course" button, a POST request
will be sent to the course API with the new course details as the request body.

*/

class AddCourseForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            name: null,
            startDate: null,
            endDate: null,
            startTime: null,
            endTime: null,
            location: null,
            instructor: null
        }
    }

    handleNameChange(event) {
        this.setState({
            name: event.target.value,
            changed: true
        })
    }

    handleStartDateChange(event) {
        this.setState({
            startDate: event.target.value,
            changed: true
        })
    }

    handleEndDateChange(event) {
        this.setState({
            endDate: event.target.value,
            changed: true
        })
    }    

    /*Appends ":00" to the end of the value from the field, allows the API
    to convert it to a java.sql.time object*/
    handleStartTimeChange(event) {
        this.setState({
            startTime: event.target.value+":00",
            changed: true
        })
    }

    /*Appends ":00" to the end of the value from the field, allows the API
    to convert it to a java.sql.time object*/
    handleEndTimeChange(event) {
        this.setState({
            endTime: event.target.value+":00",
            changed: true
        })
    }

    handleLocationChange(event) {
        this.setState({
            location: event.target.value,
            changed: true
        })
    }

    handleInstructorChange(event) {
        this.setState({
            instructor: event.target.value,
            changed: true
        })
    }

    handleFormSubmission() {
        let requestBody = JSON.stringify({
            name: this.state.name,
            startDate: this.state.startDate,
            endDate: this.state.endDate,
            startTime: this.state.startTime,
            endTime: this.state.endTime,
            location: this.state.location,
            instructor: this.state.instructor
        })
        console.log(requestBody)

        fetch('http://localhost:8080/api/course', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: requestBody
        })

        alert(this.state.name+" added as a new course!")

        this.setState({
            name: null,
            startDate: null,
            endDate: null,
            startTime: null,
            endTime: null,
            location: null,
            instructor: null
        })


    }


    

    render() {
        return (
            <div>
                <form>
                    <p>Course Name:</p>
                    <input type='text' onChange={(event) => this.handleNameChange(event)} />
                    <p>Start Date:</p>
                    <input type='date' onChange={(event) => this.handleStartDateChange(event)}/>
                    <p>End Date:</p>
                    <input type='date' onChange={(event) => this.handleEndDateChange(event)}/>
                    <p>Start Time:</p>
                    <input type='time' onChange={(event) => this.handleStartTimeChange(event)}/>                        
                    <p>End Time:</p>
                    <input type='time' onChange={(event) => this.handleEndTimeChange(event)}/>
                    <p>Location:</p>
                    <input type='text' onChange={(event) => this.handleLocationChange(event)}/>
                    <p>Instructor:</p>
                    <input type='text' onChange={(event) => this.handleInstructorChange(event)}/>
                </form>
                <button onClick={(event) => this.handleFormSubmission()}>Add New Course</button>
            </div>
        )

    }
}

export default AddCourseForm;