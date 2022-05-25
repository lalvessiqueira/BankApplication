import React, { useState } from 'react';
import {
    MDBTabs,
    MDBTabsItem,
    MDBTabsLink,
    MDBTabsContent,
    MDBTabsPane, MDBContainer, MDBRow, MDBCol, MDBBtn, MDBIcon, MDBInput, MDBCheckbox
} from 'mdb-react-ui-kit';
import './LoginRegister.css';
import axios from "axios";

export default function LoginRegister({setIsLoggedIn}) {

    // Handle form variables, submission, POST request
    const [details, setDetails] = useState(
        {
            username : '',
            fullName : '',
            password : ''
        }
    );

    // Handle Login or Register Pills
    const [loginOrRegister, setLoginOrRegister] = useState('login');
    const handleLoginOrRegister = (value: string) => {
        if (value === loginOrRegister) {
            return;
        }
        setLoginOrRegister(value);
    };

    /*
    TODO: register needs to authenticate user -> return
    TODO: why is authenticate POST and not GET
     */
    const submitRegister = (e) =>{
        e.preventDefault()
        axios.post('http://localhost:8081/api/customer/register', details).then(response => {
            console.log(response)
            window.localStorage.setItem("username",details.username)
            setIsLoggedIn(response.data)
        }).catch(error => {
            console.log(error)
            // window.location = "/infoMismatch"
        })
    }

    const submitLogin = (e) =>{
        e.preventDefault()
        console.log(details)
        axios.post('http://localhost:8081/api/customer/authenticate', details).then(response => {
            console.log(response.data)
            window.localStorage.setItem("username",details.username)
            setIsLoggedIn(true)

        }).catch(error => {
            console.log(error)
            window.location = "/infoMismatch"
        })
    }

    return (
        <MDBContainer className='rounded-3' id='bg-glass'>
            <MDBRow>
                <MDBCol>
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
                            <form onSubmit={submitLogin}>
                                <div className='text-center mb-3'>
                                    <p>Sign up with:</p>

                                    <MDBBtn floating className='mx-1'>
                                        <MDBIcon fab icon='facebook-f' />
                                    </MDBBtn>

                                    <MDBBtn floating className='mx-1'>
                                        <MDBIcon fab icon='google' />
                                    </MDBBtn>

                                    <MDBBtn floating className='mx-1'>
                                        <MDBIcon fab icon='twitter' />
                                    </MDBBtn>

                                    <MDBBtn floating className='mx-1'>
                                        <MDBIcon fab icon='github' />
                                    </MDBBtn>
                                </div>

                                <p className='text-center'>or:</p>

                                <MDBInput className='mb-4 text-white'
                                          type='text'
                                          label='Username'
                                          name='username'
                                          value={details.username}
                                          onChange={(e) =>
                                              setDetails({...details, username: e.target.value})}
                                />
                                <MDBInput className='mb-4 text-white'
                                          type='password'
                                          label='Password'
                                          name="password"
                                          value={details.password}
                                          onChange={(e) =>
                                              setDetails({...details, password: e.target.value})}
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
                            <form onSubmit={submitRegister}>
                                <MDBInput className='mb-4 text-white'
                                          type='text'
                                          label='Username'
                                          name='username'
                                          value={details.username}
                                          onChange={(e) =>
                                              setDetails({...details, username: e.target.value})}
                                />
                                <MDBInput className='mb-4 text-white'
                                          type='text' label='Full Name'
                                          name="fullName"
                                          value={details.fullName}
                                          onChange={(e) =>
                                              setDetails({...details, fullName: e.target.value})}
                                />
                                <MDBInput className='mb-4 text-white'
                                          type='password'
                                          label='Password'
                                          name="password"
                                          value={details.password}
                                          onChange={(e) =>
                                              setDetails({...details, password: e.target.value})}
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