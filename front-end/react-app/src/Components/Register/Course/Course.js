import React from 'react';

function Course(props) {

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
            <p>{'CourseID: '+props.courseData.id}</p>
            <p>{'Course Name: '+props.courseData.name}</p>
        </div>
    )
}

export default Course;