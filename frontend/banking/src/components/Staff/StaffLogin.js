import React, {Component} from 'react';
import {MDBBtn, MDBCheckbox, MDBCol, MDBContainer, MDBInput, MDBRow} from "mdb-react-ui-kit";
import LandingHeader from "../Landing/LandingHeader";
import './StaffDashboard.css';

class StaffLogin extends Component {
    render() {
        return (
            <MDBContainer className='rounded-3'>
                <MDBRow>
                    <LandingHeader/>
                </MDBRow>
                <MDBRow className='col-md-12 my-3 d-flex justify-content-evenly rounded-3 g-0' id='bg-glass'>
                    <MDBCol className='col-md-4 my-4'>
                        <h4>Log in as Staff</h4>
                        <form>
                            <MDBInput className='mb-4' type='email' label='Username' />
                            <MDBInput className='mb-4' type='password' label='Password' />

                            <MDBRow className='mb-4'>
                                <MDBCol className='d-flex justify-content-center'>
                                    <MDBCheckbox label='Remember me' defaultChecked />
                                </MDBCol>
                                <MDBCol>
                                    <a href='#!'>Forgot password?</a>
                                </MDBCol>
                            </MDBRow>

                            <MDBBtn type='submit' block>
                                Sign in
                            </MDBBtn>
                        </form>
                    </MDBCol>
                </MDBRow>

            </MDBContainer>
        );
    }
}

export default StaffLogin;