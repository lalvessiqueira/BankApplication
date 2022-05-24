import React from 'react';

export default function SecQuesMismatch() {
    return (
        <div className='container rounded-3' id='bg-glass'>
            <div className='row'>
                <img src='https://www.howtogeek.com/wp-content/uploads/2018/10/error.png?width=1198&trim=1,1&bg-color=000&pad=1,1'
                     className='img-fluid shadow-4 rounded-pill my-4' alt='...' />
            </div>
            <div className='row'>
                <p style={{color: "black"}}>Username, Security Question, & Security Answer are <strong>mismatched!</strong></p>
                <p><a href='#!'>Try again</a></p>
            </div>
        </div>
    );
}
