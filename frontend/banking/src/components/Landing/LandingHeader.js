import React from 'react';
import {
    MDBContainer,
    MDBNavbar,
    MDBBtn
} from 'mdb-react-ui-kit';

export default function LandingHeader() {
    return (
        <MDBNavbar dark bgColor='dark' className="my-3 rounded-3" >
            <MDBContainer fluid>
                <a className='navbar-brand'><i className="fas fa-university"/></a>
                <a className='d-flex input-group w-auto'>
                    <MDBBtn color='primary'>Staff Corner</MDBBtn>
                </a>
            </MDBContainer>
        </MDBNavbar>
    );
}