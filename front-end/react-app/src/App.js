import React, { Component } from 'react'
import Users from './components/users'
import './App.css'

class App extends Component {

  state = {
    users: []
  }

  componentDidMount() {
    fetch('http://localhost:8080/api/users')
    .then(res => res.json())
    .then((data) => {
      this.setState({ users: data})
    })
    .catch(console.log)
  }

  render() {
    return (
      <Users users={this.state.users} />
    )
  }

}

export default App;
