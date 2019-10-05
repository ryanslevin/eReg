import React, { Component } from 'react'
import Register from './Components/Register/Register'
import Home from './Components/Home/Home'
import UserManagement from './Components/UserManagement/UserManagement'
import './App.css'
import CourseManagement from './Components/CourseManagement/CourseManagement';

class App extends Component {

  state = {
    currentPage: <Home/>
  }

  //Loads the Register component when called
  handleRegisterPage() {
    this.setState({
      currentPage: <Register/>
    })
  }

  //Loads the Home component when called
  handleHomePage() {
    this.setState({
      currentPage: <Home/>
    })
  }

  //Loads the UserManagement component when called
  handleUserManagementPage() {
    this.setState({
      currentPage: <UserManagement/>
    })
  }

  //Loads the CourseManagement component when called
  handleCourseManagementPage() {
    this.setState({
      currentPage: <CourseManagement/>
    })
  }

  render() {
    return (
      /*Basic nav bar for navigating between the main components. On click
      it calls the appropriate handler and changes the currentPage state to that component
      
      This may not be the optimal/best practice way to manage navigation, usin it to develop
      MVP and will review at a later date*/
      <div>
        <button onClick={ (event) => this.handleHomePage()}>Home Page</button>
        <button onClick={ (event) => this.handleRegisterPage()}>Register</button>
        <button onClick={ (event) => this.handleUserManagementPage()}>UserManagement</button>
        <button onClick={ (event) => this.handleCourseManagementPage()}>CourseManagement</button>

        {/*The current component, the state of this will change when the nav bar is used*/}
        {this.state.currentPage}
      </div>

    )
  }
}

export default App;
