import React, { Component } from 'react';

import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'

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
            startTime: event.target.value + ":00",
            changed: true
        })
    }

    /*Appends ":00" to the end of the value from the field, allows the API
    to convert it to a java.sql.time object*/
    handleEndTimeChange(event) {
        this.setState({
            endTime: event.target.value + ":00",
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

        alert(this.state.name + " added as a new course!")

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
                <Form>
                    <Form.Group>
                        <Form.Label>Course Name:</Form.Label>
                        <Form.Control type='text' onChange={(event) => this.handleNameChange(event)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Start Date:</Form.Label>
                        <Form.Control type='date' onChange={(event) => this.handleStartDateChange(event)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>End Date:</Form.Label>
                        <Form.Control type='date' onChange={(event) => this.handleEndDateChange(event)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Start Time:</Form.Label>
                        <Form.Control type='time' onChange={(event) => this.handleStartTimeChange(event)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>End Time:</Form.Label>
                        <Form.Control type='time' onChange={(event) => this.handleEndTimeChange(event)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Location:</Form.Label>
                        <Form.Control type='text' onChange={(event) => this.handleLocationChange(event)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Instructor:</Form.Label>
                        <Form.Control type='text' onChange={(event) => this.handleInstructorChange(event)} />
                    </Form.Group>
                    <Form.Group>
                        <Button onClick={(event) => this.handleFormSubmission()}>Add New Course</Button>
                    </Form.Group>
                </Form>

            </div>
        )

    }
}

export default AddCourseForm;