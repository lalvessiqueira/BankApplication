import React, {useState} from 'react';
import {
    MDBBtn,
    MDBCheckbox,
    MDBCol,
    MDBContainer, MDBIcon,
    MDBInput,
    MDBRow,
    MDBTabs, MDBTabsContent,
    MDBTabsItem,
    MDBTabsLink, MDBTabsPane
} from "mdb-react-ui-kit";
import LandingHeader from "../Landing/LandingHeader";
import './StaffDashboard.css';

export default function StaffLogin()  {
    const [loginOrRegister, setLoginOrRegister] = useState('login');
    const handleLoginOrRegister = (value: string) => {
        if (value === loginOrRegister) {
            return;
        }
        setLoginOrRegister(value);
    };

        return (
            <MDBContainer className='rounded-3'>
                <MDBRow>
                    <LandingHeader/>
                </MDBRow>
                <MDBRow className='col-md-12 my-3 d-flex justify-content-evenly rounded-3 g-0' id='bg-glass'>
                    <MDBCol className='col-md-4 my-4' >

                        <MDBTabs pills justify className='mb-3'>
                            <MDBTabsItem>
                                <MDBTabsLink onClick={() => handleLoginOrRegister('login')} active={loginOrRegister === 'login'}>
                                    LOGIN
                                </MDBTabsLink>
                            </MDBTabsItem>
                            <MDBTabsItem>
                                <MDBTabsLink onClick={() => handleLoginOrRegister('register')} active={loginOrRegister === 'register'}>
                                    REGISTER
                                </MDBTabsLink>
                            </MDBTabsItem>
                        </MDBTabs>

                        <MDBTabsContent>
                            <MDBTabsPane show={loginOrRegister === 'login'}>
                                <h4>Log in as Staff</h4>
                                <form>
                                    <MDBInput className='mb-4 text-white'
                                              type='text'
                                              label='Username'
                                              name='username'
                                              // value={}
                                              // onChange={}
                                    />
                                    <MDBInput className='mb-4 text-white'
                                              type='password'
                                              label='Password'
                                              name="password"
                                    />

                                    <MDBRow className='mb-4'>
                                        <MDBCol className='d-flex justify-content-center'>
                                            <MDBCheckbox label='Remember me' defaultChecked />
                                        </MDBCol>
                                        <MDBCol>
                                            <a href='/questionAuth'>Forgot password?</a>
                                        </MDBCol>
                                    </MDBRow>

                                    <MDBBtn type='submit' className='mb-4'>
                                        Log in
                                    </MDBBtn>
                                </form>
                            </MDBTabsPane>
                            <MDBTabsPane show={loginOrRegister === 'register'}>
                                <h4>Register Staff</h4>
                                <form>
                                    <MDBInput className='mb-4 text-white'
                                              type='text'
                                              label='Username'
                                              name='username'
                                    />
                                    <MDBInput className='mb-4 text-white'
                                              type='text'
                                              label='Full Name'
                                              name="fullName"
                                              // value={details.fullName}
                                              // onChange={(e) =>
                                              //     setDetails({...details, fullName: e.target.value})}
                                    />
                                    <MDBInput className='mb-4 text-white'
                                              type='password'
                                              label='Password'
                                              name="password"
                                              // value={details.password}
                                              // onChange={(e) =>
                                              //     setDetails({...details, password: e.target.value})}
                                    />
                                    <MDBCheckbox
                                        wrapperClass='d-flex justify-content-center mb-4'
                                        id='form8Example6'
                                        label='I have read and agree to the terms'
                                        defaultChecked
                                    />

                                    <MDBBtn type='submit' className='mb-4'>
                                        Register
                                    </MDBBtn>
                                </form>
                            </MDBTabsPane>
                        </MDBTabsContent>
                    </MDBCol>
                </MDBRow>
            </MDBContainer>
        );
}
