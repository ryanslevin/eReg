import React, { Component } from 'react'
import UpdateUserForm from './UpdateUserForm/UpdateUserForm'
import AddUserForm from './AddUserForm/AddUserForm'


class UserManagement extends Component {

  state = {
    userSearchId: null,
    user: null,
    userFound: false,
    addUserActive: false,
    updateUserActive: false
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

  handleAddUserActive(event) {
    this.setState({
      addUserActive: true,
      updateUserActive: false
    })
  }

  handleUpdateUserActive(event) {
    this.setState({
      updateUserActive: true,
      addUserActive: false
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

    if (this.state.addUserActive) {
      addForm = <AddUserForm />;
    }else {
      addForm = null;
    }

    if (this.state.updateUserActive) {
      searchForm = (
        <div>
        <p>Enter the user id below and click search</p>
        <input type="text" name="userId" onChange={(event) => this.handleUserSearchChange(event)} />
        <button value="Search" onClick={(event) => this.searchUser(event)}>Search</button>
        </div>
      )
    }else {
      searchForm = null;
    }

    if (this.state.updateUserActive && this.state.userFound) {
      updateForm = <UpdateUserForm user = {this.state.user}/>
    }else {
      updateForm = null;
    }

    return (
      <div style={containerStyle}>
        <div style={columnContainerStyle}>
          <div>
          <button onClick={(event) => this.handleAddUserActive(event)}>Add New User</button>
          </div>
          <div>
          <button onClick={(event) => this.handleUpdateUserActive(event)}>Update Existing User</button>
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

export default UserManagement;