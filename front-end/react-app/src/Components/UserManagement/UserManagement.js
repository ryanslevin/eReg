import React, { Component } from 'react'
import User from '../Register/User/User'
import UpdateUserForm from './UpdateUserForm/UpdateUserForm'


class UserManagement extends Component {


    state = {
        userSearchId: null,
        user: null,
        userFound: false,
      }
    
      searchUser = () => {
        fetch('http://localhost:8080/api/user?id=' + this.state.userSearchId)
          .then(res => res.json())
          .then((data) => {
            this.setState({ user: data, userFound: true })
            console.log(data)
          })
          .catch(console.log)
      }
    
      handleUserSearchChange(event) {
        this.setState({ userSearchId: event.target.value })
      }
    
      render() {
    
        let userForm = null;
    
        if (this.state.userFound) {
          console.log(this.state.user)
          userForm = (<UpdateUserForm user={this.state.user} />);
        }
    
        return (
              <div>
                <p>Enter the user id below and click search</p>
                <input type="text" name="userId" onChange={(event) => this.handleUserSearchChange(event)} />
                <button value="Search" onClick={(event) => this.searchUser(event)}>Search</button>
                {userForm}
              </div>
        )
      }

}

export default UserManagement;