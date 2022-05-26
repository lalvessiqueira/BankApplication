import React from 'react';
import {
    MDBContainer,
    MDBNavbar,
    MDBBtn
} from 'mdb-react-ui-kit';

export default function DashCustomerHeader({setView, setIsLoggedIn}) {
    const onButtonClick = (view) => {
        setView(view)
    }
    return (
        <MDBNavbar dark bgColor='dark' className="my-3 rounded-3" >
            <MDBContainer fluid>
                <a className='navbar-brand' href='#'><i className="fas fa-university"/></a>
                <a className='navbar-brand' href='#' onClick={()=>onButtonClick('6')}>Profile</a>
                <a className='navbar-brand' href='#' onClick={() => setIsLoggedIn(false)}>Logout</a>
                <a className='d-flex input-group w-auto' style={{color: "white"}}>
                    Welcome, {localStorage.getItem("username")}
                </a>
            </MDBContainer>
        </MDBNavbar>
    );
}