import React, {Component} from 'react';
import {MDBBtn, MDBCheckbox, MDBCol, MDBInput, MDBRow} from "mdb-react-ui-kit";
import axios from "axios";

class UpdatePassword extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: window.localStorage.getItem("username"),
            newPassword: '',
            confirmPassword: ''
        };
    }

    changeHandler = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = e => {
        e.preventDefault()
        console.log("this.state:")
        console.log(this.state)
        axios.put('http://localhost:8081/api/customer/' + this.state.username + "/forgot").then(response => {
            console.log(response.data)
            if (response.data === "Sorry password not updated") {
                window.location =  "/infoMismatch"
            } else {
                window.localStorage.setItem("username",this.state.username)
                window.location =  "/" // go to create account
            }
        }).catch(error => {
            console.log(error)
            // window.location =  "/infoMismatch"
        })
    }


    render() {
        return (
            <div className="container rounded-3" id='bg-glass'>
                <form>
                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <MDBInput className='mt-4' label={this.state.username} disabled/>
                        </MDBCol>
                    </MDBRow>

                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <MDBInput wrapperClass='mb-4'
                                      type='text'
                                      label='Enter Password'
                                      name="newPassword"
                                      value={this.state.newPassword}
                                      onChange={this.changeHandler}
                            />
                            <MDBInput wrapperClass='mb-2'
                                      type='text'
                                      label='Confirm Password'
                                      name="confirmPassword"
                                      value={this.state.confirmPassword}
                                      onChange={this.changeHandler}
                            />
                        </MDBCol>
                    </MDBRow>

                    <MDBBtn className='mb-4' type='submit'>
                        Update
                    </MDBBtn>

                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <p>Already have a Customer account? <a href='/'>Login here</a></p>
                        </MDBCol>
                    </MDBRow>
                </form>
            </div>
        );
    }
}

export default UpdatePassword;