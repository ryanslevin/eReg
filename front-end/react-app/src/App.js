import React, { Component } from 'react'
import User from './Components/User/User'
import './App.css'

class App extends Component {

  state = {
    userSearchId: null,
    user: null,
    userFound: false
  }

  searchUser = () => {
    fetch('http://localhost:8080/api/user?id=' + this.state.userSearchId)
      .then(res => res.json())
      .then((data) => {
        this.setState({ user: data, userFound: true })
      })
      .catch(console.log)
  }

  handleSearchChange(event) {
    this.setState({ userSearchId: event.target.value })
  }


  render() {

    let theUser = null;

    if (this.state.userFound) {
      console.log(this.state.user)
      theUser = (<User userData={this.state.user} />);
    }

    return (
      <div>
        <div>
          <p>Enter the user id below and click search</p>
          <input type="text" name="id" onChange={(event) => this.handleSearchChange(event)} />
          <button value="Search" onClick={(event) => this.searchUser(event)} />
          <br/>
          <br/>          
          <p>Selected User</p>
          {theUser}

        </div>
      </div>

    )
  }
}

export default App;
