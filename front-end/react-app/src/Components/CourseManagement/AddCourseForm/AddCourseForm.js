import React, { Component } from 'react';

class AddUserForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            firstName: null,
            lastName: null,
            gender: null,
            birthDate: null
        }
    }

    handleFirstNameChange(event) {
        this.setState({
            firstName: event.target.value,
        })
    }

    handleLastNameChange(event) {
        this.setState({
            lastName: event.target.value,
        })
    }

    handleBirthDateChange(event) {
        this.setState({
            birthDate: event.target.value,
        })
    }    

    handleGenderChange(event) {
        this.setState({
            gender: event.target.value,
        })
    }    

    handleFormSubmission() {
        let requestBody = JSON.stringify({
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            birthDate: this.state.birthDate,
            gender: this.state.gender
        })
        console.log(requestBody)

        fetch('http://localhost:8080/api/user', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: requestBody
        })

        alert("New user added!")

    }
    
    render() {
        return (
            <div>
                <form>
                    <p>First Name:</p>
                    <input type='text' onChange={(event) => this.handleFirstNameChange(event)}/>
                    <p>Last Name:</p>
                    <input type='text' onChange={(event) => this.handleLastNameChange(event)}/>
                    <p>Birth Date:</p>
                    <input type='date' onChange={(event) => this.handleBirthDateChange(event)}/>                    
                    <p>Gender:</p>
                    <input type='text' onChange={(event) => this.handleGenderChange(event)}/>
                </form>
                <button onClick={(event) => this.handleFormSubmission()}>Add User</button>
            </div>
        )

    }
}

export default AddUserForm;