import React from 'react';

function User(props) {

    const style = {
        width: '200px',
        border: '2px solid black',
        shadow: '2px 2px black',
        padding: '10px',
        margin: '15px',
        display: 'inline-block'
    }

    return (
        <div style={style}>
            <p>{'UserID: '+props.userData.id}</p>
            <p>{'Name: '+props.userData.firstName + ' ' + props.userData.lastName}</p>
            <p>{'Gender: '+props.userData.gender}</p>
        </div>
    )
}

export default User;