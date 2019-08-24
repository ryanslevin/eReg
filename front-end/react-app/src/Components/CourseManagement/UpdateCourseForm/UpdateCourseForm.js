import React, { Component } from 'react';

class UpdateCourseForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            id: props.course.id,
            name: props.course.name,
            startDate: props.course.startDate,
            endDate: props.course.endDate,
            startTime: props.course.startTime,
            endTime: props.course.endTime,
            location: props.course.location,
            instructor: props.course.instructor
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

    handleStartTimeChange(event) {
        this.setState({
            startTime: event.target.value+":00",
            changed: true
        })
    }

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
            id: this.state.id,
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
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: requestBody
        })
    }

    render() {
        return (
            <div>
                <form>
                    <p>Course Name:</p>
                    <input type='text' onChange={(event) => this.handleNameChange(event)}
                        defaultValue={this.state.name} />
                    <p>Start Date:</p>
                    <input type='date' onChange={(event) => this.handleStartDateChange(event)}
                        defaultValue={this.state.startDate}/>
                    <p>End Date:</p>
                    <input type='date' onChange={(event) => this.handleEndDateChange(event)}
                        defaultValue={this.state.endDate}/>
                    <p>Start Time:</p>
                    <input type='time' onChange={(event) => this.handleStartTimeChange(event)}
                        defaultValue={this.state.startTime}/>                        
                    <p>End Time:</p>
                    <input type='time' onChange={(event) => this.handleEndTimeChange(event)}
                        defaultValue={this.state.endTime}/>
                    <p>Location:</p>
                    <input type='text' onChange={(event) => this.handleLocationChange(event)}
                        defaultValue={this.state.location} />
                    <p>Instructor:</p>
                    <input type='text' onChange={(event) => this.handleInstructorChange(event)}
                        defaultValue={this.state.instructor} />
                </form>
                <button onClick={(event) => this.handleFormSubmission()}>Update</button>
            </div>
        )

    }
}

export default UpdateCourseForm;