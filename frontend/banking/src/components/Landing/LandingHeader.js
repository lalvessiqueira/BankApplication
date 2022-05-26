import React from 'react';
import {
    MDBContainer,
    MDBNavbar,
    MDBBtn
} from 'mdb-react-ui-kit';
import {Link} from "react-router-dom";

export default function LandingHeader() {
    return (
        <MDBNavbar dark bgColor='dark' className="my-3 rounded-3" >
            <MDBContainer fluid>
                <Link to="/">
                    <a className='navbar-brand'><i className="fas fa-university"/></a>
                </Link>
                <Link to="/staffCorner">
                    <a className='d-flex input-group w-auto'>
                        <MDBBtn color='primary'>Staff Corner</MDBBtn>
                    </a>
                </Link>
            </MDBContainer>
        </MDBNavbar>
    );
}