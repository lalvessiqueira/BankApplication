import React from 'react';
import {
    MDBContainer,
    MDBNavbar,
    MDBBtn
} from 'mdb-react-ui-kit';

export default function DashCustomerHeader() {
    return (
        <MDBNavbar dark bgColor='dark' className="my-3 rounded-3" >
            <MDBContainer fluid>
                <a className='navbar-brand' href='#'><i className="fas fa-university"/></a>
                <a className='navbar-brand' href='#'>Profile</a>
                <a className='navbar-brand' href='#'>Logout</a>
                <a className='d-flex input-group w-auto' style={{color: "white"}}>
                    Welcome, HenrryWith2Rs
                </a>
            </MDBContainer>
        </MDBNavbar>
    );
}