import React from 'react'

const Users = ({ users }) => {

    console.log('In Users.js')
    return (
        <div>
            <center><h1>Users</h1></center>
            {users.map((user) => (
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">{user.firstName}</h5>
                </div>
            </div>
    ))}
    </div>
    )
};

export default Users