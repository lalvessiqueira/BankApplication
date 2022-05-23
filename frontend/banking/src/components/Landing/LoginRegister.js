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

export default function LoginRegister() {

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

    const changeHandler = (e) => {
        setDetails({[e.target.name]: e.target.value})
    }

    const submitHandler = (e) =>{
        e.preventDefault()
        console.log("this.state:")
        console.log(details)
        axios.post('http://localhost:8081/api/customer/register', details).then(response => {
            console.log(response.data)
            console.log("here details")
            console.log(details)
        }).catch(error => {
            console.log(error)
            console.log("here details")
            console.log(details)
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
                            <form>
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

                                <MDBInput className='mb-4 text-white' type='text' label='Username'/>
                                <MDBInput className='mb-4 text-white' type='password' label='Password' />

                                <MDBRow className='mb-4'>
                                    <MDBCol className='d-flex justify-content-center'>
                                        <MDBCheckbox id='form7Example3' label='Remember me' defaultChecked />
                                    </MDBCol>
                                    <MDBCol>
                                        <a href='#!'>Forgot password?</a>
                                    </MDBCol>
                                </MDBRow>

                                <MDBBtn type='submit' className='mb-4'>
                                    Log in
                                </MDBBtn>
                            </form>
                        </MDBTabsPane>
                        <MDBTabsPane show={loginOrRegister === 'register'}>
                            <form onSubmit={submitHandler}>
                                <MDBInput className='mb-4 text-white'
                                          type='text'
                                          label='Username'
                                          name='username'
                                          value={details.username}
                                          onChange={(e) =>
                                              setDetails({...details, username: e.target.value,})}
                                />
                                <MDBInput className='mb-4 text-white'
                                          type='text' label='Full Name'
                                          name="fullName"
                                          value={details.fullName}
                                          onChange={(e) =>
                                              setDetails({...details, fullName: e.target.value,})}
                                />
                                <MDBInput className='mb-4 text-white'
                                          type='password'
                                          label='Password'
                                          name="password"
                                          value={details.password}
                                          onChange={(e) =>
                                              setDetails({...details, password: e.target.value,})}
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