import React, { Component } from 'react'
import Register from './Components/Register/Register'
import Home from './Components/Home/Home'
import UserManagement from './Components/UserManagement/UserManagement'
import './App.css'
import CourseManagement from './Components/CourseManagement/CourseManagement';

import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'

import 'bootstrap/dist/css/bootstrap.min.css';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

class App extends Component {

  render() {
    return (
      <Router>
        <Navbar bg="dark" variant="dark">
          <Nav variant="pills">
            <Nav.Item>
              <Link className="nav-link" to="/">Home Page</Link>
            </Nav.Item>
            <Nav.Item>
              <Link className="nav-link" to="/register">Register</Link>
            </Nav.Item>
            <Nav.Item>
              <Link className="nav-link" to="/users">UserManagement</Link>
            </Nav.Item>
            <Nav.Item>
              <Link className="nav-link" to="/courses">CourseManagement</Link>
            </Nav.Item>
          </Nav>
        </Navbar>

        {/*The current component, the state of this will change when the nav bar is used*/}
        <Container>
          <Row>
          <Switch>
            <Route exact path="/">
              <Home />
            </Route>
            <Route path="/register">
              <Register />
            </Route>
            <Route path="/users">
              <UserManagement />
            </Route>
            <Route path="/courses">
              <CourseManagement />
            </Route>
          </Switch>
          </Row>
          </Container>
        </Router>
    )
  }
}

export default App;
