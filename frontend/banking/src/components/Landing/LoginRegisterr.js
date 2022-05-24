import React, {Component, useState} from 'react';
import {
    MDBTabs,
    MDBTabsItem,
    MDBTabsLink,
    MDBTabsContent,
    MDBTabsPane, MDBContainer, MDBRow, MDBCol, MDBBtn, MDBIcon, MDBInput, MDBCheckbox
} from 'mdb-react-ui-kit';
import './LoginRegister.css';
import axios from "axios";
import {Link} from "react-router-dom";

class LoginRegisterr extends Component {

    constructor(props) {
        super(props);

        this.state = {
            username: '',
            fullName: '',
            password: '',
            loginOrRegister: 'login'
        };
    }

    handleLoginOrRegister = (value) => {
        if (value !== this.state.loginOrRegister) {
            this.setState(
                {loginOrRegister : value},
                () => console.log("after setState: " + this.state.loginOrRegister))
        }
    };

    changeHandler = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = e =>{
        e.preventDefault()
        console.log("this.state:")
        console.log(this.state)
        axios.post('http://localhost:8081/api/customer/register', this.state).then(response => {
            console.log(response)
        }).catch(error => {
            console.log(error)
        })
    }

    render() {
        let {username, fullName, password , loginOrRegister} = ['', '', '', "login"]
        return (
            <MDBContainer className='rounded-3' id='bg-glass'>
                <MDBRow>
                    <MDBCol>
                        <MDBTabs pills justify className='mb-3'>
                            <MDBTabsItem>
                                <MDBTabsLink onClick={() => this.handleLoginOrRegister("login")} value={"login"} active={loginOrRegister === 'login' || this.state.loginOrRegister === 'login'}>
                                    LOGIN
                                </MDBTabsLink>
                            </MDBTabsItem>
                            <MDBTabsItem>
                                <MDBTabsLink onClick={() => this.handleLoginOrRegister("register")} value={"register"}  active={this.state.loginOrRegister === 'register'}>
                                    REGISTER
                                </MDBTabsLink>
                            </MDBTabsItem>
                        </MDBTabs>

                        <MDBTabsContent>
                            <MDBTabsPane show={this.state.loginOrRegister === 'login' || loginOrRegister === "login"}>
                                {loginOrRegister = ""}
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
                                            <Link to="/resetPassword">
                                                <a href='/resetPassword'>Forgot password?</a>
                                            </Link>
                                        </MDBCol>
                                    </MDBRow>

                                    <MDBBtn type='submit' className='mb-4'>
                                        Log in
                                    </MDBBtn>
                                </form>
                            </MDBTabsPane>
                            <MDBTabsPane show={this.state.loginOrRegister === 'register'} >
                                <form onSubmit={this.submitHandler}>
                                    <MDBInput className='mb-4 text-white'
                                              type='text'
                                              label='Username'
                                              name='username'
                                              value={this.state.username}
                                              onChange={this.changeHandler}
                                    />
                                    <MDBInput className='mb-4 text-white'
                                              type='text'
                                              label='Full Name'
                                              name="fullName"
                                              value={this.state.fullName}
                                              onChange={this.changeHandler}
                                    />
                                    <MDBInput className='mb-4 text-white'
                                              type='password'
                                              label='Password'
                                              name="password"
                                              value={this.state.password}
                                              onChange={this.changeHandler}
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
}

export default LoginRegisterr;