import React, { Component } from 'react'
import Register from './Components/Register/Register'
import Home from './Components/Home/Home'
import UserManagement from './Components/UserManagement/UserManagement'
import './App.css'

class App extends Component {

  state = {
    currentPage: <Home/>
  }

  handleRegisterPage() {
    this.setState({
      currentPage: <Register/>
    })
  }

  handleHomePage() {
    this.setState({
      currentPage: <Home/>
    })
  }

  handleUserManagementPage() {
    this.setState({
      currentPage: <UserManagement/>
    })
  }

  render() {

    return (
      <div>
        <button onClick={ (event) => this.handleHomePage()}>Home Page</button>
        <button onClick={ (event) => this.handleRegisterPage()}>Register Page</button>
        <button onClick={ (event) => this.handleUserManagementPage()}>UserManagement Page</button>        
        {this.state.currentPage}
      </div>

    )
  }
}

export default App;
