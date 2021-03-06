import React, { Component } from 'react';

class UpdateUserForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            id: props.user.id,
            firstName: props.user.firstName,
            lastName: props.user.lastName,
            gender: props.user.gender,
            birthDate: props.user.birthDate,
            changed: false
        }
    }

    handleFirstNameChange(event) {
        this.setState({
            firstName: event.target.value,
            changed: true
        })
    }

    handleLastNameChange(event) {
        this.setState({
            lastName: event.target.value,
            changed: true
        })
    }

    handleGenderChange(event) {
        this.setState({
            gender: event.target.value,
            changed: true
        })
    }    

    handleBirthDateChange(event) {
        this.setState({
            birthDate: event.target.value,
            changed: true
        })
    } 


    handleFormSubmission() {
        let requestBody = JSON.stringify({
            id: this.state.id,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            birthDate: this.state.birthDate,
            gender: this.state.gender
        })
        console.log(requestBody)


        fetch('http://localhost:8080/api/user', {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: requestBody
        })
    }

    render() {
        return (
            <div>
                <form>
                    <p>First Name:</p>
                    <input type='text' onChange={(event) => this.handleFirstNameChange(event)}
                        defaultValue={this.state.firstName} />
                    <p>Last Name:</p>
                    <input type='text' onChange={(event) => this.handleLastNameChange(event)}
                        defaultValue={this.state.lastName} />
                    <p>Birth Date:</p>
                    <input type='date' onChange={(event) => this.handleBirthDateChange(event)}
                        defaultValue={this.state.birthDate}/>                          
                    <p>Gender:</p>
                    <input type='text' onChange={(event) => this.handleGenderChange(event)}
                        defaultValue={this.state.gender} />
                </form>
                <button onClick={(event) => this.handleFormSubmission()}>Update</button>
            </div>
        )

    }
}

export default UpdateUserForm;